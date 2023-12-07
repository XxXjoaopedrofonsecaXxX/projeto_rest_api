package com.projet.projetojava.service;

import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public Airline createAirLine(String name) {
        return airlineRepository.save(new Airline(name));
    }

    public Airline findByName(String name) {
        return airlineRepository.findByName(name);
    }

	public void save(Airline airline) {
		// TODO Auto-generated method stub
		
	}
}
