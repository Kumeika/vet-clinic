package com.example.api.vet;

import com.example.api.schedule.DayScheduleDTO;
import com.sun.istack.NotNull;

import java.util.List;

public class VetDTO {

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    private List<DayScheduleDTO> schedule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<DayScheduleDTO> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<DayScheduleDTO> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "VetDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
