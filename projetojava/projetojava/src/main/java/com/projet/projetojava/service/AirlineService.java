package com.projet.projetojava.service;

import org.springframework.stereotype.Service;

@Service
public class AirlineService {
    private String airlineName;
    
    public AirlineService() {
    }
    public AirlineService(String airlineName) {
        this.airlineName = airlineName;
    }
    
    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}