package com.projet.projetojava.service;

import com.projet.projetojava.repository.AirbusA320repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirbusA320service {

    public AirbusA320repository getAirbusA320repository() {
		return airbusA320repository;
	}

	private final AirbusA320repository airbusA320repository;

    @Autowired
    public AirbusA320service(AirbusA320repository airbusA320repository) {
        this.airbusA320repository = airbusA320repository;
    }

    // restante do código
}

