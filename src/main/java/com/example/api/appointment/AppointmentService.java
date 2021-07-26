package com.example.api.appointment;

import com.example.api.exceptions.AppointmentNotFoundException;
import com.example.api.vet.VetService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final VetService vetService;
    private final ModelMapper modelMapper=new ModelMapper();

    public AppointmentService(AppointmentRepository appointmentRepository, VetService vetService) {
        this.appointmentRepository = appointmentRepository;
        this.vetService= vetService;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    public AppointmentDTO createOrUpdateAppointment(AppointmentCreateDTO appointmentDTO){
        modelMapper.typeMap(AppointmentCreateDTO.class,Appointment.class).addMappings(mapper->{
            mapper.map(AppointmentCreateDTO::getVetId, Appointment::setVet);
            mapper.map(AppointmentCreateDTO::getOwnerId, Appointment::setOwner);
            mapper.map(AppointmentCreateDTO::getPetId, Appointment::setPet);
        });
        Appointment appointment=modelMapper.map(appointmentDTO,Appointment.class);
        setAppTime(appointment,appointment.getAppointmentDay());
        appointmentRepository.save(appointment);
        return getAppointmentById(appointment.getId());
    }

    private void setAppTime(Appointment appointment, DayOfWeek appointmentDay){
        if (appointmentRepository.getAppointmentsByDayAndVet(appointmentDay,appointment.getVet().getId()).isEmpty()){
            LocalTime start=vetService.getDayScheduleOfVet2(appointmentDay,appointment.getVet().getId()).getStartShift();
            appointment.setAppointmentTime(start);
        }else {
            appointment.setAppointmentTime(appointmentRepository.getLatestAppointmentTime(appointment.getVet().getId()));
        }
        appointment.setAppointmentEndTime(appointment.getAppointmentTime().plusMinutes(appointment.getAppointmentType().getDuration()));
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> apps = appointmentRepository.findAll();
        return changeAppointmentsToDTOList(apps);
    }

    public AppointmentDTO getAppointmentById(Long id){
        Appointment app=appointmentRepository.findById(id).orElse(null);
        if(app==null){
            throw new AppointmentNotFoundException("Appointment with id "+id+" not found.");
        }
        mapAppointmentDTO();
        return modelMapper.map(app,AppointmentDTO.class);}

    public List<AppointmentDTO> getAppointmentsByDayAndVet(DayOfWeek day, Long id){
        List<Appointment> apps=appointmentRepository.getAppointmentsByDayAndVet(day,id);
        return changeAppointmentsToDTOList(apps);
    }

    public List<AppointmentDTO> getAppointmentsOfOwner(Long id){
        List<Appointment> apps=appointmentRepository.getAppointmentsOfOwner(id);
        return changeAppointmentsToDTOList(apps);
    }

    @Transactional
    public int deleteAppointmentById(Long id){
        return appointmentRepository.deleteAppointmentById(id);
    }

   private void mapAppointmentDTO(){
        modelMapper.typeMap(Appointment.class,AppointmentDTO.class).addMappings(mapper->{
            mapper.map(Appointment::getVetLastName,AppointmentDTO::setVetLastName);
            mapper.map(Appointment::getOwnerLastName,AppointmentDTO::setOwnerLastName);
            mapper.map(Appointment::getPetName,AppointmentDTO::setPetName);
        });
    }

    private List<AppointmentDTO> changeAppointmentsToDTOList(List<Appointment> apps) {
        if (apps.isEmpty()){
            throw new AppointmentNotFoundException("There are no appointments.");
        }
        List<AppointmentDTO> appdto = apps.stream()
                .map(a -> {mapAppointmentDTO();
                    return modelMapper.map(a, AppointmentDTO.class);
                }).collect(Collectors.toList());
        return appdto;
    }
}
