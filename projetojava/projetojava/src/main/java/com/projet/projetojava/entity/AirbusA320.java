package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class AirbusA320 {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

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
	private String nome;
    private int capacidadePassageiros;
   
    
}