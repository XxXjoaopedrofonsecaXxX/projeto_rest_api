package com.projet.projetojava.controller;

import com.projet.projetojava.service.AirlineService;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;

import java.util.List;

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

    @PostMapping("/create")
    public void createAirline(@RequestBody String airlineName) {
        airlineService.createAirline(airlineName);
    }

    @GetMapping("/{id}")
    public Airline getAirlineById(@PathVariable Long id) {
        return airlineService.getAirlineById(id);
    }

    @GetMapping("/name/{name}")
    public Long getAirlineIdByName(@PathVariable String name) {
        return airlineService.getAirlineIdByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteAirline(@PathVariable Long id) {
        airlineService.deleteAirline(id);
    }

    @GetMapping("/airplanes/{id}")
    public List<Airplane> getAirplanes(@PathVariable Long id) {
        return airlineService.getAirplanes(id);
    }

    @PostMapping("/airplane")
    public void addAirplane(@RequestBody Airplane airplane) {
        airlineService.addAirplane(airplane);
    }

    @DeleteMapping("/airplane/{id}")
    public void removeAirplane(@PathVariable Long id) {
        airlineService.removeAirplane(id);
    }
}
