package com.projet.projetojava.service;

import org.springframework.stereotype.Service;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.repository.AirplaneRepository;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AirlineService {
    private String airlineName;
    private Map<Long, Airplane> airplanes;
    private final AirplaneRepository airplaneRepository; 

    public AirlineService(AirplaneRepository airplaneRepository) {
        this.airplanes = new ConcurrentHashMap<>();
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

	public Airline getAirlineById(Long airlineId) {
		// TODO Auto-generated method stub
		return null;
	}
}
