package com.projet.projetojava.controller;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.service.AirlineService;
import com.projet.projetojava.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

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
        return flightService.createFlight(flight.getFlightNumber(), airline, flight.getOrigin(), flight.getDestination(), flight.getDuration());
    }
}
