package com.Rogs.worldForge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rogs.worldForge.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
