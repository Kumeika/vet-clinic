package com.example.api.vet;

import com.example.api.schedule.DaySchedule;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;

@Service
public class VetService {
    private final VetRepository vetRepository;
    private final ModelMapper modelMapper=new ModelMapper();

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Vet createOrUpdateVet(VetDTO vetDTO){
        Vet vet=modelMapper.map(vetDTO,Vet.class);
        return vetRepository.save(vet);
    }

    public Vet getVetById(Long id){
        return vetRepository.findById(id).orElse(null);
    }

    public List<Vet> getAllVets(){
        return vetRepository.findAll();
    }

    public Vet getVetByPhoneNumber(String phoneNumber){return vetRepository.getVetByPhoneNumber(phoneNumber);}

    public List<DaySchedule> getScheduleOfVet(Long vetId){
        return vetRepository.getScheduleOfVet(vetId);
    }

    public DaySchedule getDayScheduleOfVet(DayOfWeek day,Long vetId){
        return vetRepository.getDayScheduleOfVet(vetRepository.getScheduleOfVet(vetId),day);
    }

    @Transactional
    public int deleteVetById(Long id){
        return vetRepository.deleteVetById(id);
    }
}
