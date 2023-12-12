package com.projet.projetojava.service;

import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.entity.Stopover;
import com.projet.projetojava.repository.StopoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class StopoverService {

    private final StopoverRepository stopoverRepository;

    @Autowired
    public StopoverService(StopoverRepository stopoverRepository) {
        this.stopoverRepository = stopoverRepository;
    }

    public Stopover createStopover(Flight flight, String airport, Duration duration) {
        return stopoverRepository.save(new Stopover(flight, airport, duration));
    }
}