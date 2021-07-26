package com.example.api.appointment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppointmentRestController {

    private final AppointmentService appointmentService;

    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentDTO> createOrUpdateAppointment(@RequestBody AppointmentCreateDTO appointment){
        return new ResponseEntity<>(appointmentService.createOrUpdateAppointment(appointment), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointment(){
        List<AppointmentDTO> appointments=appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id){
        AppointmentDTO appointment= appointmentService.getAppointmentById(id);
        return new ResponseEntity<>(appointment,HttpStatus.OK);
    }

    @DeleteMapping("appointments/{id}/delete")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable Long id){
        if (appointmentService.deleteAppointmentById(id)>0){
            return new ResponseEntity<>(appointmentService.deleteAppointmentById(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/appointments/vet")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByDayAndVet(DayOfWeek day,Long id){
        List<AppointmentDTO> appointments=appointmentService.getAppointmentsByDayAndVet(day,id);
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }

    @GetMapping("/appointments/owner")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByOwner(Long id){
        List<AppointmentDTO> appointments=appointmentService.getAppointmentsOfOwner(id);
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }
}
