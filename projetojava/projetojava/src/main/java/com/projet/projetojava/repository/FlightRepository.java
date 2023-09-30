package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	Flight save(Flight flight);


}
