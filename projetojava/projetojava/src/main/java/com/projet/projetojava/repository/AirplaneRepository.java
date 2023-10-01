package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    List<Airplane> findAllByAirlineId(Long airlineId);
    List<Airplane> findAllBySeatClass(String seatClass); // Novo método para encontrar todos os aviões por classe de assento
}
