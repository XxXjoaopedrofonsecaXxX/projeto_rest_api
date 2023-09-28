package com.projet.projetojava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirplaneRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class AirlineService {
    private String airlineName;
    private Map<Long, Airplane> airplanes;
    private AirplaneRepository airplaneRepository; 

    public AirlineService() {
        this.airplanes = new HashMap<>();
    }

    @Autowired
    public void setAirplaneRepository(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Map<Long, Airplane> getAirplanes() {
        List<Airplane> airplaneList = airplaneRepository.findAll();
        for (Airplane airplane : airplaneList) {
            airplanes.put(airplane.getId(), airplane);
        }
        return airplanes;
    }

    public void addAirplane(Airplane airplane) {
        airplaneRepository.save(airplane);
        this.airplanes.put(airplane.getId(), airplane);
    }

    public void removeAirplane(Long id) {
        boolean exists = airplaneRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Airplane with id " + id + " does not exist");
        }
        airplaneRepository.deleteById(id);
        this.airplanes.remove(id);
    }
}
