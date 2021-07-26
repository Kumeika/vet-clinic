package com.example.api.appointment;

import com.sun.istack.NotNull;

public class AppointmentCreateDTO {

    @NotNull
    private String appointmentType;

    @NotNull
    private String appointmentDay;

    private String vetId;

    private String ownerId;

    private String petId;

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

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        this.vetId = vetId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
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
                ", vetId='" + vetId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", petId='" + petId + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
