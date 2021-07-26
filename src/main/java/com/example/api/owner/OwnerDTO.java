package com.example.api.owner;

import com.example.api.pet.PetDTO;
import com.sun.istack.NotNull;

import java.util.List;

public class OwnerDTO {

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    private List<PetDTO> pet;

    @NotNull
    private String addressStreet;

    @NotNull
    private String addressHouseNumber;

    @NotNull
    private String addressPostalCode;

    @NotNull
    private String addressCity;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PetDTO> getPet() {
        return pet;
    }

    public void setPet(List<PetDTO> pet) {
        this.pet = pet;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressHouseNumber() {
        return addressHouseNumber;
    }

    public void setAddressHouseNumber(String addressHouseNumber) {
        this.addressHouseNumber = addressHouseNumber;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", pet=" + pet +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressHouseNumber='" + addressHouseNumber + '\'' +
                ", addressPostalCode='" + addressPostalCode + '\'' +
                ", addressCity='" + addressCity + '\'' +
                '}';
    }
}
