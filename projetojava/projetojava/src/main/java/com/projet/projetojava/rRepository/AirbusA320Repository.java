package com.projet.projetojava.rRepository;

import com.projet.projetojava.entity.AirbusA320;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirbusA320Repository extends JpaRepository<AirbusA320, Long> {
}