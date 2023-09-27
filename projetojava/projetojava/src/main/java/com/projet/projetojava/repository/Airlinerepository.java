package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Airlinerepository extends JpaRepository<Airline, Long> {
   
}