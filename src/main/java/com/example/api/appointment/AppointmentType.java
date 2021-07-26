package com.example.api.appointment;

import java.math.BigDecimal;

public enum AppointmentType {

    REGULAR_APPOINTMENT("regular",new BigDecimal(40),15),
    SURGERY("surgery",new BigDecimal(220),40),
    BLOOD_TEST("Blood test", new BigDecimal(50),10),
    VACCINATION("vaccination",new BigDecimal(35),10),
    CASTRATION("castration",new BigDecimal(300),40),
    FOLLOW_UP("Follow-up", new BigDecimal(25),10);

    private String name;
    private BigDecimal price;
    private int duration;

    AppointmentType(String name, BigDecimal price, int duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }
}
