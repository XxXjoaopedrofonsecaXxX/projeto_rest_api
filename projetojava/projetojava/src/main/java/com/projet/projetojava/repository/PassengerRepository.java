package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
   
    List<Passenger> findByName(String name);

    
    List<Passenger> findByPassportNumber(String passportNumber);

    
    List<Passenger> findByCpf(String cpf);

   
    List<Passenger> findByRg(String rg);
}
