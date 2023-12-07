package com.projet.projetojava.controller;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.service.AirlineService;
import com.projet.projetojava.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airplanes")
public class AirplaneController {

    private final AirplaneService airplaneService;
    private final AirlineService airlineService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService, AirlineService airlineService) {
        this.airplaneService = airplaneService;
        this.airlineService = airlineService;
    }

    @PostMapping
    public Airplane createAirplane(@RequestBody Airplane airplane) {
        Airline airline = airlineService.findByName(airplane.getAirline().getName());
        if (airline != null) {
            airplane.setAirline(airline);
        }
        return airplaneService.createAirplane(airplane.getModel(), airplane.getMaxCapacity(), airline);
    }

    @GetMapping("/totalCapacity/{airlineName}")
    public int getTotalCapacity(@PathVariable String airlineName) {
        Airline airline = airlineService.findByName(airlineName);
        return airplaneService.getTotalCapacity(airline);
    }
}
