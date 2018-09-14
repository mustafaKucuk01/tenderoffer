package com.volantx.tenderoffer.tenderoffer.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Orderr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @ManyToMany
    private List<Customer> customer;

    @ManyToMany
    private List<Product> product;


    //private Date date;

    private int number;

    public Orderr() {
    }

    public Orderr(List<Customer> customer, List<Product> product, int number) {
        this.customer = customer;
        this.product = product;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderr orderr = (Orderr) o;
        return Objects.equals(orderId, orderr.orderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    @Override
    public String toString() {
        return "Orderr{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", product=" + product +
                ", number=" + number +
                '}';
    }
}
