package com.example.api.pet;

import com.sun.istack.NotNull;


public class PetDTO {

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String birthDate;

    @NotNull
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
