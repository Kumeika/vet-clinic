package com.example.api.schedule;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ModelMapper modelMapper=new ModelMapper();

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional
    public DaySchedule createOrUpdateSchedule(DayScheduleDTO dayScheduleDTO, Long vet_id){
        modelMapper.typeMap(DayScheduleDTO.class,DaySchedule.class).addMappings(mapper->{
            mapper.map(DayScheduleDTO::getStartShift,DaySchedule::setStartShift);
            mapper.map(DayScheduleDTO::getEndShift,DaySchedule::setEndShift);
        });
        DaySchedule daySchedule=modelMapper.map(dayScheduleDTO,DaySchedule.class);
        DaySchedule schedule=scheduleRepository.save(daySchedule);
        scheduleRepository.setVetAndScheduleId(vet_id, schedule.getId());
        return schedule;
    }

    public List<DaySchedule> getSchedulesByDayOfWeek(DayOfWeek dayOfWeek){
        return scheduleRepository.getSchedulesByDayOfWeek(dayOfWeek);
    }

    public List<DaySchedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    @Transactional
    public int deleteScheduleById(Long id){
        return scheduleRepository.deleteScheduleById(id);
    }
}
