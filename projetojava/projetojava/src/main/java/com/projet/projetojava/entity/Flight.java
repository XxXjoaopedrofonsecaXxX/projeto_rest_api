package com.projet.projetojava.entity;

import java.time.Duration;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String flightNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id")
    private Airline airline;
    
    @Column
    private String origin;
    
    @Column
    private String destination;

    @Column
    private Duration duration;

    @Enumerated(EnumType.STRING)
    private FlightClass flightClass;

    @OneToMany(mappedBy = "flight")
    private List<Passenger> passengers;

    private String arrivalTime;
    private String departureTime;
    private String airplaneModel;

    // Construtor protegido sem argumentos para JPA
    public Flight() {}

    // Construtores públicos para criação de objetos Flight
    public Flight(String flightNumber, Airline airline) {
        this.flightNumber = flightNumber;
        this.airline = airline;
    }

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration, FlightClass flightClass) {
        this(flightNumber, airline);  // Reutilizando o construtor acima
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.flightClass = flightClass; 
    }

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration) {
        this(flightNumber, airline, origin, destination, duration, null);  // Reutilizando o construtor acima
    }

    public Flight(Airline airline, String airplaneModel, String origin, String destination, String departureTime, String arrivalTime) {
        this.airline = airline;
        this.airplaneModel = airplaneModel;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters e setters...

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airline getAirline() {
        return this.airline;
    }

    public Long getId() {
        return this.id;
    }

    public String getFlightNumber() {
        return this.flightNumber;
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

	public void setModel(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setId(long l) {
		// TODO Auto-generated method stub
		
	}

	public void setMaxCapacity(int i) {
		// TODO Auto-generated method stub
		
	}

	public Short getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Short getMaxCapacity() {
		// TODO Auto-generated method stub
		return null;
	}
}
