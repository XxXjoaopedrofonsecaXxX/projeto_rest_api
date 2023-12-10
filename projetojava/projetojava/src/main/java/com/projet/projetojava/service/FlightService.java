package com.projet.projetojava.service;

import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }
}
