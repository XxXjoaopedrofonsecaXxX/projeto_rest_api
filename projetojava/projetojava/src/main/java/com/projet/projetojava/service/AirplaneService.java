package com.projet.projetojava.service;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public Airplane createAirplane(String model, int maxCapacity, Airline airline) {
        return airplaneRepository.save(new Airplane(model, maxCapacity, airline));
    }

    public int getTotalCapacity(Airline airline) {
        List<Airplane> airplanes = airplaneRepository.findByAirline(airline);
        return airplanes.stream().mapToInt(Airplane::getMaxCapacity).sum();
    }
}
