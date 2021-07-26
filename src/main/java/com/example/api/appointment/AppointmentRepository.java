package com.example.api.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query(value = "select a from Appointment a where a.appointmentDay=:appointmentDay and a.vet.id=:vetId")
    List<Appointment> getAppointmentsByDayAndVet(DayOfWeek appointmentDay, Long vetId);

    @Query(value = "select max(a.appointmentEndTime) from Appointment a where a.vet.id=:vetId")
    LocalTime getLatestAppointmentTime(Long vetId);

    @Modifying
    @Query(value = "delete from Appointment a where a.id=:id")
    int deleteAppointmentById(Long id);

    @Query(value = "select a from Appointment a where a.owner.id=:id")
    List<Appointment> getAppointmentsOfOwner(Long id);
}
