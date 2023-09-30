package com.projet.projetojava.controller;

import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.service.Flightservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final Flightservice flightService;

    @Autowired
    public FlightController(Flightservice flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @GetMapping
    public List<Flight> findAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return "Flight removed !! " + id;
    }
}
