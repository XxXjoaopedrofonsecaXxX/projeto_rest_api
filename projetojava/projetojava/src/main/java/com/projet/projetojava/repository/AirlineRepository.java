package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Airline findByName(String name);
    List<Airline> findAll(); // Novo método para encontrar todas as companhias aéreas
}
