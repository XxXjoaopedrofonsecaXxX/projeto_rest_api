package com.projet.projetojava.entity;

import jakarta.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;
    private int maxCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    public Airplane() {
    }

    public Airplane(String model, int maxCapacity, Airline airline) {
        this.model = model;
        this.maxCapacity = maxCapacity;
        this.airline = airline;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
