package com.example.api.appointment;

import com.example.api.owner.Owner;
import com.example.api.pet.Pet;
import com.example.api.vet.Vet;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_type",nullable = false)
    private AppointmentType appointmentType;

    @Column(name = "appointment_day",nullable = false)
    private DayOfWeek appointmentDay;

    @Column(name = "appointment_time",nullable = false)
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime appointmentTime;

    @Column(name = "appointment_end_time",nullable = false)
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime appointmentEndTime;

    @OneToOne
    @JoinColumn(name = "vet_id",nullable = false)
    private Vet vet;

    @OneToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private Owner owner;

    @OneToOne
    @JoinColumn(name = "pet_id",nullable = false)
    private Pet pet;

    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public DayOfWeek getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(DayOfWeek appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public void setVetId(Long id){vet.setId(id);}

    public String getVetLastName(){return vet.getLastName();}

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setOwnerId(Long id){owner.setId(id);}

    public String getOwnerLastName(){return owner.getLastName();}

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setPetId(Long id){pet.setId(id);}

    public String getPetName(){return pet.getName();}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentType=" + appointmentType +
                ", appointmentDay=" + appointmentDay +
                ", appointmentTime=" + appointmentTime +
                ", appointmentEndTime=" + appointmentEndTime +
                ", vet=" + vet +
                ", owner=" + owner +
                ", pet=" + pet +
                ", comment='" + comment + '\'' +
                '}';
    }
}
