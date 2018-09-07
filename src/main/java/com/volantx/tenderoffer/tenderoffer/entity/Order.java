package com.volantx.tenderoffer.tenderoffer.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long siparisId;

    @ManyToMany
    private List<Customer> customer;

    @ManyToMany
    private List<Product> product;


    //private Date date;

    private int number;

    public Order() {
    }

    public Order(List<Customer> customer, List<Product> product, int number) {
        this.customer = customer;
        this.product = product;
        this.number = number;
    }

    public long getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(long siparisId) {
        this.siparisId = siparisId;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
