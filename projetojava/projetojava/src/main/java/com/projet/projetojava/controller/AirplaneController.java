package com.projet.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet.projetojava.service.AirplaneService;
import com.projet.projetojava.entity.Airplane;

import java.util.List;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    
    @GetMapping
    public List<Airplane> getAirplanes() {
        return airplaneService.getAirplanes();
    }

  
    @GetMapping("/{id}")
    public Airplane getAirplane(@PathVariable Long id) {
        return airplaneService.getAirplane(id);
    }

 
    @PostMapping
    public void addNewAirplane(@RequestBody Airplane airplane) {
        airplaneService.addNewAirplane(airplane);
    }

    
    @DeleteMapping("/{id}")
    public void deleteAirplane(@PathVariable Long id) {
        airplaneService.deleteAirplane(id);
    }
}
