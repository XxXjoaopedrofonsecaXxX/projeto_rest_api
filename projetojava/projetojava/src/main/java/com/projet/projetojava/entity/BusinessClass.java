package com.projet.projetojava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BusinessClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String businessName;
    private String businessType;
    private int numberOfEmployees;

    public BusinessClass() {
    }

    public BusinessClass(Long id, String businessName, String businessType, int numberOfEmployees) {
        this.id = id;
        this.businessName = businessName;
        this.businessType = businessType;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
