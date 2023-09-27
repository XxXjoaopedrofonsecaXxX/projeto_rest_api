package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class TravelClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Todos os tipos de classe de viagem terão esses campos
    private String seatNumber;
    private double price;

    // Construtor
    public TravelClass(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Métodos getters e setters
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
}

