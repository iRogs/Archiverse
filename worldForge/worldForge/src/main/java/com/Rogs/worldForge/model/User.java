package com.Rogs.worldForge.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "criador")
    private List<Mundo> mundosCriados;

    private String username;
    private String email;
    private String password;
    private String role;
    
}
