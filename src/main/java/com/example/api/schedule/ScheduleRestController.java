package com.example.api.schedule;

import com.example.api.exceptions.ScheduleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ScheduleRestController {

    private final ScheduleService scheduleService;

    public ScheduleRestController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")
    public ResponseEntity<DaySchedule> createOrUpdateSchedule(@RequestBody DayScheduleDTO dayScheduleDTO, @RequestParam Long vet_id){
        return new ResponseEntity<>(scheduleService.createOrUpdateSchedule(dayScheduleDTO,vet_id), HttpStatus.OK);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<DaySchedule>> getAllSchedules(){
        List<DaySchedule> schedules=scheduleService.getAllSchedules();
        if (schedules.isEmpty()){
            throw new ScheduleNotFoundException("There are no schedules");
        }
        return new ResponseEntity<>(schedules,HttpStatus.OK);
    }

    @GetMapping("/schedules/{dayOfWeek}")
    public ResponseEntity<List<DaySchedule>> getScheduleByDayOfWeek(@PathVariable DayOfWeek dayOfWeek){
        List<DaySchedule> schedules=scheduleService.getSchedulesByDayOfWeek(dayOfWeek);
        if (schedules.isEmpty()){
            throw new ScheduleNotFoundException("No schedule on "+dayOfWeek);
        }
        return new ResponseEntity<>(schedules,HttpStatus.OK);
    }

    @DeleteMapping("schedules/{id}/delete")
    public ResponseEntity<?> deleteScheduleById(@PathVariable Long id){
        if (scheduleService.deleteScheduleById(id)>0){
            return new ResponseEntity<>(scheduleService.deleteScheduleById(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
