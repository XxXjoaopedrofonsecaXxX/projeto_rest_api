package com.projet.projetojava.repository;

import com.projet.projetojava.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ticketrepository extends JpaRepository<Ticket, Long> {
    
}
