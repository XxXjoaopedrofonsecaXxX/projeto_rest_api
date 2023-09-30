package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private List<Airplane> airplanes;

    public Airline() {
        this.airplanes = new ArrayList<>();
    }

    public Airline(Long id, String name) {
        this.id = id;
        this.name = name;
        this.airplanes = new ArrayList<>();
    }

    public static Airline createAirLine(String name) {
        Airline airline = new Airline();
        airline.setName(name);
        return airline;
    }

    public void addAirplane(Airplane airplane) {
        this.airplanes.add(airplane);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Airplane> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
        this.name = name;
    }
}
