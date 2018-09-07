package com.volantx.tenderoffer.tenderoffer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "city")
public class City {

    @Id
    private int plaqueCode; //plaka no

    private int dialingCode; //posta kodu

    private String name;

    public City() {
    }

    public City(int plaqueCode, int dialingCode, String name) {
        this.plaqueCode = plaqueCode;
        this.dialingCode = dialingCode;
        this.name = name;
    }

    public int getPlaqueCode() {
        return plaqueCode;
    }

    public void setPlaqueCode(int plaqueCode) {
        this.plaqueCode = plaqueCode;
    }

    public int getDialingCode() {
        return dialingCode;
    }

    public void setDialingCode(int dialingCode) {
        this.dialingCode = dialingCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
