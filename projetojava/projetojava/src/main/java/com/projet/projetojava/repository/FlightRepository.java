package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByAirline(Airline airline);
}
