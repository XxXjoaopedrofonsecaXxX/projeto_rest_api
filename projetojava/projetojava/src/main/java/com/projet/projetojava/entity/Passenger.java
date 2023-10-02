package com.projet.projetojava.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

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
	@JoinColumn(name="flight_id", nullable=false)
	private Flight flight; // O voo no qual o passageiro está

	private String flightTime;

    public Passenger() {
    }

    public Passenger(String name, String cpf, String passportNumber, String flightTime) {
        this.name = name;
        this.cpf = cpf;
        this.passportNumber = passportNumber;
        this.flightTime = flightTime;
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
	    if (cpf == null || cpf.length() != 11 || !cpf.chars().allMatch(Character::isDigit)) {
	        return false;
	    }

	    int[] numbers = cpf.chars().map(Character::getNumericValue).toArray();

	    int sum = 0;
	    for (int i = 0; i < 9; i++) {
	        sum += numbers[i] * (10 - i);
	    }
	    int firstCheckDigit = 11 - (sum % 11);
	    if (firstCheckDigit >= 10) firstCheckDigit = 0;

	    sum = 0;
	    for (int i = 0; i < 10; i++) {
	        sum += numbers[i] * (11 - i);
	    }
	    int secondCheckDigit = 11 - (sum % 11);
	    if (secondCheckDigit >= 10) secondCheckDigit = 0;

	    return firstCheckDigit == numbers[9] && secondCheckDigit == numbers[10];
	}
	
	public boolean isRgValid(String rg) {
	    if (rg == null || rg.length() < 5 || rg.length() > 14) {
	        return false;
	    }

	    for (char c : rg.toCharArray()) {
	        if (!Character.isLetterOrDigit(c)) {
	            return false;
	        }
	    }

	    return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, flight, flightTime, id, name, passportNumber, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(flight, other.flight)
				&& Objects.equals(flightTime, other.flightTime) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(passportNumber, other.passportNumber)
				&& Objects.equals(rg, other.rg);
	}
	
	// ... equals, hashCode ...
}
