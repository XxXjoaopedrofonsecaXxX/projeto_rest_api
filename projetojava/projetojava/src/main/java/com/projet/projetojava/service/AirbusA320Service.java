package com.projet.projetojava.service;

import com.projet.projetojava.entity.AirbusA320;
import com.projet.projetojava.rRepository.AirbusA320Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirbusA320Service {

    private final AirbusA320Repository airbusA320Repository;

    @Autowired 
    public AirbusA320Service(AirbusA320Repository airbusA320Repository) {
        this.airbusA320Repository = airbusA320Repository;
    }

    // Método para buscar todos os AirbusA320
    public List<AirbusA320> findAll() {
        return airbusA320Repository.findAll();
    }

    // Método para salvar um AirbusA320
    public AirbusA320 save(AirbusA320 airbusA320) {
        return airbusA320Repository.save(airbusA320);
    }

    // Método para atualizar um AirbusA320
    public AirbusA320 update(AirbusA320 airbusA320) {
        return airbusA320Repository.save(airbusA320);
    }

    // Método para deletar um AirbusA320
    public void delete(Long id) {
        airbusA320Repository.deleteById(id);
    }
}
