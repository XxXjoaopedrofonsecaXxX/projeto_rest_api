package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String passportNumber;
    private String cpf;
    private String rg;

    @ManyToOne
    private Flight flight; // O voo no qual o passageiro está

    public Passenger() {
    }

    public Passenger(String name, String passportNumber, String cpf, String rg, Flight flight) {
        this.name = name;
        this.passportNumber = passportNumber;
        setCpf(cpf); // Use o setter para que a validação seja feita
        setRg(rg); // Use o setter para que a validação seja feita
        this.flight = flight; // Definindo o voo do passageiro
    }

	// ... getters e setters ...

	public void setCpf(String cpf) {
		if (isCpfValid(cpf)) {
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("CPF inválido");
		}
	}

	public void setRg(String rg) {
		if (isRgValid(rg)) {
			this.rg = rg;
		} else {
			throw new IllegalArgumentException("RG inválido");
		}
	}

	public boolean isCpfValid(String cpf) {
	    // Implementação da validação do CPF
	    // Aqui você pode adicionar a lógica para validar o CPF
	    return true;
	}
	
	public boolean isRgValid(String rg) {
	    // Implementação da validação do RG
	    // Aqui você pode adicionar a lógica para validar o RG
	    return true;
	}
	
	// ... equals, hashCode ...
}
