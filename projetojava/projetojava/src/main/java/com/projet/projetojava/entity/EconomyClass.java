package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EconomyClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String seatNumber;
    private double price;
    private boolean hasWindowSeat;

    public EconomyClass() {
    }

    public EconomyClass(Long id, String seatNumber, double price, boolean hasWindowSeat) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.price = price;
        this.hasWindowSeat = hasWindowSeat;
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

    public boolean getHasWindowSeat() {
        return hasWindowSeat;
    }

    public void setHasWindowSeat(boolean hasWindowSeat) {
        this.hasWindowSeat = hasWindowSeat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
