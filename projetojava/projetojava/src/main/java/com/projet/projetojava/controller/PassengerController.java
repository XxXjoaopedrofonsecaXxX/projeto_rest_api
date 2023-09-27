package com.projet.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet.projetojava.service.PassengerService;
import com.projet.projetojava.entity.Passenger;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

   
    @GetMapping
    public List<Passenger> getPassengers() {
        return passengerService.getPassengers();
    }

    
    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable Long id) {
        return passengerService.getPassenger(id);
    }

    
    @PostMapping
    public void addNewPassenger(@RequestBody Passenger passenger) {
        passengerService.addNewPassenger(passenger);
    }

   
    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }
}
