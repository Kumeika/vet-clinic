package com.example.api.appointment;

import com.sun.istack.NotNull;

public class AppointmentDTO {

    @NotNull
    private String appointmentType;

    @NotNull
    private String appointmentDay;

    @NotNull
    private String appointmentTime;

    private String vetLastName;

    private String ownerLastName;

    private String petName;

    private String comment;

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(String appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getVetLastName() {
        return vetLastName;
    }

    public void setVetLastName(String vetLastName) {
        this.vetLastName = vetLastName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointmentType='" + appointmentType + '\'' +
                ", appointmentDay='" + appointmentDay + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", vetLastName='" + vetLastName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                ", petName='" + petName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
