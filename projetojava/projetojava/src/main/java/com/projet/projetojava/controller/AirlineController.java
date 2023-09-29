package com.projet.projetojava.controller;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    private final AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public String getAirlineName() {
        return airlineService.getAirlineName();
    }

    @PostMapping
    public void setAirlineName(@RequestBody String airlineName) {
        airlineService.setAirlineName(airlineName);
    }

    @GetMapping("/airlines/{airlineId}")
    public Airline getAirlineById(@PathVariable Long airlineId) {
        return airlineService.getAirlineById(airlineId);
    }

    
    }
