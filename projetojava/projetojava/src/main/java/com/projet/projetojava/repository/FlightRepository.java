package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findById(Long id);
}
