package com.example.api.schedule;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "day_schedule")
public class DaySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "start_shift")
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime startShift;

    @Column(name = "end_shift")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime endShift;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartShift() {
        return startShift;
    }

    public void setStartShift(LocalTime startShift) {
        this.startShift = startShift;
    }

    public LocalTime getEndShift() {
        return endShift;
    }

    public void setEndShift(LocalTime endShift) {
        this.endShift = endShift;
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", startShift=" + startShift +
                ", endShift=" + endShift +
                '}';
    }
}
