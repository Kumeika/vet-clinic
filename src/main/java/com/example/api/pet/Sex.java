package com.example.api.pet;

public enum Sex {
    MALE("M"),FEMALE("F");
    private String sex;

    Sex(String sex) {
        this.sex=sex;
    }

    public String getSex() {
        return sex;
    }
}
