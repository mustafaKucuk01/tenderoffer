package com.volantx.tenderoffer.tenderoffer.entity;

import javax.persistence.*;

@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;


    @ManyToOne
    private City city;

    @ManyToOne
    private District district;

    public Address() {
    }


    public Address(City city, District district) {
        this.city = city;
        this.district = district;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

}
