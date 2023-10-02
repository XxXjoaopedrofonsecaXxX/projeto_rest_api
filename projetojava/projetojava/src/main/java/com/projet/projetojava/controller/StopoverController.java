package com.projet.projetojava.controller;

import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.entity.Stopover;
import com.projet.projetojava.service.FlightService;
import com.projet.projetojava.service.StopoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/stopovers")//
public class StopoverController {

    private final StopoverService stopoverService;
    private final FlightService flightService;

    @Autowired
    public StopoverController(StopoverService stopoverService, FlightService flightService) {
        this.stopoverService = stopoverService;
        this.flightService = flightService;
    }

    @PostMapping
    public Stopover createStopover(@RequestBody Stopover stopover) {
        Flight flight = flightService.findById(stopover.getFlight().getId());
        return stopoverService.createStopover(flight, stopover.getAirport(), stopover.getDuration());
    }
}
