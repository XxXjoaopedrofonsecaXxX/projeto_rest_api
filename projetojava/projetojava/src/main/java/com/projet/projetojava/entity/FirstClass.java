package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FirstClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String seatNumber;
    private double price;
    private boolean hasPersonalChef;

    public FirstClass() {
    }

    public FirstClass(Long id, String seatNumber, double price, boolean hasPersonalChef) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.price = price;
        this.hasPersonalChef = hasPersonalChef;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getHasPersonalChef() {
        return hasPersonalChef;
    }

    public void setHasPersonalChef(boolean hasPersonalChef) {
        this.hasPersonalChef = hasPersonalChef;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
