package com.projet.projetojava.entity;

import jakarta.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity // Indica que esta classe é uma entidade JPA
public class Flight {
    @Id // Indica que este campo é a chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) // Indica que o valor será gerado automaticamente
    private Long id;

    @Column(nullable = false) // Indica que este campo não pode ser nulo no banco de dados
    private String flightNumber;
    
    @ManyToOne(fetch = FetchType.LAZY) // Indica uma relação muitos-para-um com a entidade Airline
    @JoinColumn(name = "airline_id", nullable = false) // Indica a coluna de junção no banco de dados
    private Airline airline; // Referência à entidade Airline
    
    @Column(nullable = false) // Indica que este campo não pode ser nulo no banco de dados
    private String origin;
    
    @Column(nullable = false) // Indica que este campo não pode ser nulo no banco de dados
    private String destination;
    
    @Column(nullable = false) // Indica que este campo não pode ser nulo no banco de dados
    private Duration duration; // Duração do voo

    @Enumerated(EnumType.STRING) // Indica que este campo é um enum e deve ser armazenado como string no banco de dados
    @Column(nullable = false) // Indica que este campo não pode ser nulo no banco de dados
    private FlightClass flightClass; // Classe do voo (Executiva, Primeira Classe, Econômica)

    @OneToOne(mappedBy = "flight") // Indica uma relação um-para-muitos com a entidade Passenger
    private List<Passenger> passengers; // Lista de passageiros

	private String arrivalTime;

	private String departureTime;

	private String airplaneModel;

    public Flight() {} // Construtor padrão necessário para JPA

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    public Flight(String flightNumber, Airline airline, String origin, String destination, Duration duration, FlightClass flightClass) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration; 
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
