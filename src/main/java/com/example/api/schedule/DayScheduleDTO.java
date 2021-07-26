package com.example.api.schedule;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class DayScheduleDTO {

    private String dayOfWeek;

    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "HH:mm")
    private String startShift;

    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "HH:mm")
    private String endShift;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartShift() {
        return LocalTime.parse(startShift);
    }

    public void setStartShift(String startShift) {
        this.startShift = startShift;
    }

    public LocalTime getEndShift() {
        return LocalTime.parse(endShift);
    }

    public void setEndShift(String endShift) {
        this.endShift = endShift;
    }

    @Override
    public String toString() {
        return "DayScheduleDTO{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", startShift='" + startShift + '\'' +
                ", endShift='" + endShift + '\'' +
                '}';
    }
}
