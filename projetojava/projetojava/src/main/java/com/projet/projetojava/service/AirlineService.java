package com.projet.projetojava.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirplaneRepository;
import com.projet.projetojava.repository.AirlineRepository;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AirlineService {
    private final AirlineRepository airlineRepository;
    private final AirplaneRepository airplaneRepository; 

    public AirlineService(AirlineRepository airlineRepository, AirplaneRepository airplaneRepository) {
        this.airlineRepository = airlineRepository;
        this.airplaneRepository = airplaneRepository;
    }

    public Airline createAirline(String name) {
        Airline airline = new Airline();
        airline.setName(name);
        return airlineRepository.save(airline);
    }

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline getAirlineById(Long id) {
        return airlineRepository.findById(id).orElse(null);
    }

    public Long getAirlineIdByName(String name) {
        Airline airline = airlineRepository.findByName(name);
        return (airline != null) ? airline.getId() : null;
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }

    public List<Airplane> getAirplanes(Long airlineId) {
        return airplaneRepository.findAllByAirlineId(airlineId);
    }

    public void addAirplane(Airplane airplane) {
        System.out.println("Modelo: " + airplane.getModel() + ", Capacidade Máxima: " + airplane.getMaxCapacity());
        airplaneRepository.save(airplane);
    }

    public void removeAirplane(Long id) {
        boolean exists = airplaneRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Airplane with id " + id + " does not exist");
        }
        airplaneRepository.deleteById(id);
    }
}