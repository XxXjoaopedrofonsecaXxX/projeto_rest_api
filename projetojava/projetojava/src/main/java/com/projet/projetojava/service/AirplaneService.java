package com.projet.projetojava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.Airplanerepository;

import java.util.List;

@Service
public class AirplaneService {
    private final Airplanerepository airplanerepository; 

    @Autowired
    public AirplaneService(Airplanerepository airplanerepository) {
        this.airplanerepository = airplanerepository;
    }

   
    public List<Airplane> getAirplanes() {
        return airplanerepository.findAll();
    }

   
    public Airplane getAirplane(Long id) {
        return airplanerepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Airplane with id " + id + " does not exist"));
    }

    
    public void addNewAirplane(Airplane airplane) {
        airplanerepository.save(airplane);
    }


    public void deleteAirplane(Long id) {
        boolean exists = airplanerepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Airplane with id " + id + " does not exist");
        }
        airplanerepository.deleteById(id);
    }
}
