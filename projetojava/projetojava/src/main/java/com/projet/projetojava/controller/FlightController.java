package com.projet.projetojava.controller;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.service.AirlineService;
import com.projet.projetojava.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;
    private final AirlineService airlineService;

    @Autowired
    public FlightController(FlightService flightService, AirlineService airlineService) {
        this.flightService = flightService;
        this.airlineService = airlineService;
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        Airline airline = airlineService.findByName(flight.getAirline().getName());
        if (airline != null) {
            flight.setAirline(airline);
        }
        return flightService.createFlight(flight);
    }
}
