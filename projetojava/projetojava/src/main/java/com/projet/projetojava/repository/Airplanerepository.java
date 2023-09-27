package com.projet.projetojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.projetojava.entity.Airplane;

public interface Airplanerepository extends JpaRepository<Airplane, Long> {

}
