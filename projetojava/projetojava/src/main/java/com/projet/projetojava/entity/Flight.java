package com.projet.projetojava.entity;

import jakarta.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String flightNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline; // Referência à entidade Airline
    
    @Column(nullable = false)
    private String origin;
    
    @Column(nullable = false)
    private String destination;
    
    @Column(nullable = false)
    private Duration duration; // Duração do voo

    public Flight() {}

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration; // Definindo a duração do voo
    }

	public Long getId() {
		return this.id;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public Airline getAirline() {
		return this.airline;
	}

	public String getOrigin() {
		return this.origin;
	}

	public String getDestination() {
		return this.destination;
	}

	public Duration getDuration() {
		return this.duration;
	}
}
