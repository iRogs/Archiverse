package com.Rogs.worldForge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rogs.worldForge.model.Mundo;

public interface MundoRepository extends JpaRepository<Mundo, Long> {
    
}
