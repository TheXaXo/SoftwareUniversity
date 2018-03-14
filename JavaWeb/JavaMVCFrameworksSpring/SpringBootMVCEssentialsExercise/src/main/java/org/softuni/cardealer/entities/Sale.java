package org.softuni.cardealer.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private double discount;

    @OneToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Sale() {

    }

    public Sale(double discount, Car car, Customer customer) {
        this.discount = discount;
        this.car = car;
        this.customer = customer;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getSalePrice() {
        return this.getCar().getParts().stream().mapToDouble(Part::getPrice).sum();
    }
}