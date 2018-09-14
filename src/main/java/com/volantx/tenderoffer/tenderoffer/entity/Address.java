package com.volantx.tenderoffer.tenderoffer.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressId, address.addressId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(addressId);
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city=" + city +
                ", district=" + district +
                '}';
    }
}
