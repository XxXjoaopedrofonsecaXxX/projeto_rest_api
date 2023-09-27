package com.projet.projetojava.controller;

import com.projet.projetojava.entity.AirbusA320;
import com.projet.projetojava.service.AirbusA320Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/airbusa320") 
public class AirbusA320Controller {

    private final AirbusA320Service airbusA320Service;

    @Autowired 
    public AirbusA320Controller(AirbusA320Service airbusA320Service) {
        this.airbusA320Service = airbusA320Service;
    }

    // 
    @GetMapping // Anotação para mapear as requisições GET para este método
    public ResponseEntity<List<AirbusA320>> findAll() {
        return ResponseEntity.ok(airbusA320Service.findAll());
    }

    // Método para salvar um AirbusA320
    @PostMapping // Anotação para mapear as requisições POST para este método
    public ResponseEntity<AirbusA320> save(@RequestBody AirbusA320 airbusA320) {
        return ResponseEntity.ok(airbusA320Service.save(airbusA320));
    }

    // Método para atualizar um AirbusA320
    @PutMapping // Anotação para mapear as requisições PUT para este método
    public ResponseEntity<AirbusA320> update(@RequestBody AirbusA320 airbusA320) {
        return ResponseEntity.ok(airbusA320Service.update(airbusA320));
    }

    // Método para deletar um AirbusA320
    @DeleteMapping("/{id}") // Anotação para mapear as requisições DELETE para este método
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        airbusA320Service.delete(id);
        return ResponseEntity.ok().build();
    }
}

