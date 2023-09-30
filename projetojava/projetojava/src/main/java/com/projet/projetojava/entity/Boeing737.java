package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Boeing737 {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private int capacidadePassageiros;
    private final int capacidadeMaxima;

    public Boeing737(String nome, int capacidadePassageiros) {
        this.nome = nome;
        this.capacidadePassageiros = capacidadePassageiros;
        this.capacidadeMaxima = 85;  // Capacidade máxima para Boeing 737
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
}

