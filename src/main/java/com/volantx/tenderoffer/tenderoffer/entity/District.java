package com.volantx.tenderoffer.tenderoffer.entity;

import javax.persistence.*;

@Entity(name = "district")
public class District {

    @Id
    private int postCode;

    @ManyToOne
    private City city;

    private String name;

    public District() {
    }

    public District(int postCode, City city, String name) {
        this.postCode = postCode;
        this.city = city;
        this.name = name;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
