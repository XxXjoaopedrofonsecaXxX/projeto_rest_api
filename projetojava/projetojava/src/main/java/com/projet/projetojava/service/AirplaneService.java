package com.projet.projetojava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirplaneRepository;

import java.util.List;

@Service
public class AirplaneService {
    private final AirplaneRepository airplaneRepository; 

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

   
    public List<Airplane> getAirplanes() {
        return airplaneRepository.findAll();
    }

   
    public Airplane getAirplane(Long id) {
        return airplaneRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Airplane with id " + id + " does not exist"));
    }

    
    public void addNewAirplane(Airplane airplane) {
        airplaneRepository.save(airplane);
    }


    public void deleteAirplane(Long id) {
        boolean exists = airplaneRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Airplane with id " + id + " does not exist");
        }
        airplaneRepository.deleteById(id);
    }
}