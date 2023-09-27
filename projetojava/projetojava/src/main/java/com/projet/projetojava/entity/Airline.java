package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	
	public Airline() {
	}
		public Airline(Long id, String name) {
	        this.id = id;
	        this.name = name;
	    }
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

