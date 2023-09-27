package com.projet.projetojava.service;

import com.projet.projetojava.entity.Passenger;
import com.projet.projetojava.repository.Passengerrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private final Passengerrepository passengerrepository;

    @Autowired
    public PassengerService(Passengerrepository passengerrepository) {
        this.passengerrepository = passengerrepository;
    }

    public List<Passenger> getPassengers() {
        return passengerrepository.findAll();
    }

    public Passenger getPassenger(Long id) {
        return passengerrepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Passenger with id " + id + " does not exist"));
    }

    public void addNewPassenger(Passenger passenger) {
        passengerrepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        boolean exists = passengerrepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Passenger with id " + id + " does not exist");
        }
        passengerrepository.deleteById(id);
    }
}
