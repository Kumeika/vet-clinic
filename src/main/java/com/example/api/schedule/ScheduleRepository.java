package com.example.api.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<DaySchedule,Long> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into vet_schedule(vet_id,schedule_id) values (:vet_id, :schedule_id)")
    void setVetAndScheduleId(Long vet_id, Long schedule_id);

    @Query(value = "select s from DaySchedule s where s.dayOfWeek=:dayOfWeek")
    List<DaySchedule> getSchedulesByDayOfWeek(DayOfWeek dayOfWeek);

    @Modifying
    @Query(value = "delete from DaySchedule s where s.id=:id")
    int deleteScheduleById(Long id);
}
