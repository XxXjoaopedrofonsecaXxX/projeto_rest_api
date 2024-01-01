package com.projet.projetojava.service;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public Airline createAirLine(String name) {
        validateAirlineName(name);
        Airline airline = new Airline(name.trim());
        return airlineRepository.save(airline);
    }

    private void validateAirlineName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Airline name cannot be null or empty.");
        }
    }

    public Airline findByName(String name) {
        return airlineRepository.findByName(name);
    }

    public void save(Airline airline) {
        validateAirline(airline);
        airline.setName(airline.getName().trim());
        airlineRepository.save(airline);
    }

    private void validateAirline(Airline airline) {
        if (airline == null) {
            throw new IllegalArgumentException("Airline cannot be null.");
        }
        if (airline.getName() == null || airline.getName().isEmpty()) {
            throw new IllegalArgumentException("Airline name cannot be null or empty.");
        }
    }
}
