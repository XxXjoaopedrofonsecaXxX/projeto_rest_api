package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.Duration;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String flightNumber;
    
    @ManyToOne
    private Airline airline; // Referência à entidade Airline
    
    private String origin;
    private String destination;
    private Duration duration; // Duração do voo

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration) {
        this.setFlightNumber(flightNumber);
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration; // Definindo a duração do voo
    }

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Duration getDuration() {
	    return duration; // Getter para a duração do voo
	}
	
	public void setDuration(Duration duration) {
	    this.duration = duration; // Setter para a duração do voo
	}
}
