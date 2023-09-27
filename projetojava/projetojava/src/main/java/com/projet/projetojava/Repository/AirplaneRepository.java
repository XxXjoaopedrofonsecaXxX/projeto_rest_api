package com.projet.projetojava.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.projetojava.entity.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
