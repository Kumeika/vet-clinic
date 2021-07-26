package com.example.api.vet;

import com.example.api.schedule.DaySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.util.List;

public interface VetRepository extends JpaRepository<Vet,Long> {

    @Query(value = "select v.schedule from Vet v where v.id=:vetId")
    List<DaySchedule> getScheduleOfVet(Long vetId);

    @Query(value = "select s from DaySchedule s where s in(:schedules) and s.dayOfWeek=:day")
    DaySchedule getDayScheduleOfVet(List<DaySchedule> schedules, DayOfWeek day);

    @Query(value = "select v from Vet v where v.phoneNumber=:phoneNumber")
    Vet getVetByPhoneNumber(String phoneNumber);

    @Modifying
    @Query(value = "delete from Vet v where v.id=:id")
    int deleteVetById(Long id);
}
