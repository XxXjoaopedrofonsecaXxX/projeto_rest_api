package com.projet.projetojava.entity;

import java.time.Duration;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String flightNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;
    
    @Column(nullable = false)
    private String origin;
    
    @Column(nullable = false)
    private String destination;

    // Altere a anotação Column para permitir valores NULL na coluna duration
    @Column(nullable = true)
    private Duration duration;

    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @OneToMany(mappedBy = "flight")
    private List<Passenger> passengers;

	private String arrivalTime;

	private String departureTime;

	private String airplaneModel;

	public Flight() {}

	public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration) {
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
	}

	public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration, FlightClass flightClass) {
		this(flightNumber, airline, origin, destination, duration);
		this.flightClass = flightClass; 
	}

	public Flight(Airline airline, String airplaneModel, String origin, String destination, String departureTime, String arrivalTime) {
		this.airline = airline;
		this.airplaneModel = airplaneModel;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
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

	public FlightClass getFlightClass() {
		return this.flightClass;
	}

	public List<Passenger> getPassengers() {
		return this.passengers;
	}
}
