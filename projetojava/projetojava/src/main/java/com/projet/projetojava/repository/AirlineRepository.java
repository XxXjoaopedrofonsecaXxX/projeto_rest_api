package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Airline findByName(String name);
}
