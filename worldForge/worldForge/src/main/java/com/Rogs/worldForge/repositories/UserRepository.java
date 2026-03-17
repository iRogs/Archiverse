package com.Rogs.worldForge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Rogs.worldForge.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
