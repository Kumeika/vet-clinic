package com.example.api.vet;

import com.example.api.exceptions.ScheduleNotFoundException;
import com.example.api.exceptions.VetNotFoundException;
import com.example.api.schedule.DaySchedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VetRestController {
    private final VetService vetService;

    public VetRestController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping("/vets")
    public ResponseEntity<Vet> createOrUpdateVet(@RequestBody VetDTO vet){
        return new ResponseEntity<>(vetService.createOrUpdateVet(vet), HttpStatus.OK);
    }

    @GetMapping("/vets")
    public ResponseEntity<?> getVets(@RequestParam(required = false) String phoneNumber) {
        if(phoneNumber != null) {
            Vet vet=vetService.getVetByPhoneNumber(phoneNumber);
            if (vet == null) {
                throw new VetNotFoundException("Vet with phone number: "+phoneNumber+" not found.");
            }
            return new ResponseEntity<>(vet, HttpStatus.OK);
        }
        List<Vet> vets = vetService.getAllVets();
        if (vets.isEmpty()){
            throw new VetNotFoundException("There are no registered vets.");
        }
        return new ResponseEntity<>(vets,HttpStatus.OK);
    }

    @GetMapping("/vets/{id}")
    public ResponseEntity<Vet> getVetById(@PathVariable Long id){
        Vet vet= vetService.getVetById(id);
        if (vet==null){
            throw new VetNotFoundException("Vet with id "+id+" not found.");
        }
        return new ResponseEntity<>(vet,HttpStatus.OK);
    }

    @GetMapping("vets/{vetId}/schedule")
    public ResponseEntity<List<DaySchedule>> getScheduleOfVet(@PathVariable Long vetId){
        List<DaySchedule> schedule= vetService.getScheduleOfVet(vetId);
        if (schedule.isEmpty()){
            throw new ScheduleNotFoundException("Vet has no schedule.");
        }
        return new ResponseEntity<>(schedule,HttpStatus.OK);
    }

    @GetMapping("/vets/{vetId}/daySchedule")
    public ResponseEntity<DaySchedule> getDayScheduleOfVet(@PathVariable Long vetId, DayOfWeek day){
        DaySchedule schedule= vetService.getDayScheduleOfVet2(day,vetId);
        if (schedule==null){
            throw new ScheduleNotFoundException("Vet has no schedule.");
        }
        return new ResponseEntity<>(schedule,HttpStatus.OK);
    }

    @DeleteMapping("vets/{id}/delete")
    public ResponseEntity<?> deleteVetById(@PathVariable Long id){
        if (vetService.deleteVetById(id)>0){
            return new ResponseEntity<>(vetService.deleteVetById(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
