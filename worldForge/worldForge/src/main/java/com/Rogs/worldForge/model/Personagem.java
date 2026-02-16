package com.Rogs.worldForge.model;


import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mundo mundo;

    @ManyToOne
    @JoinColumn(name = "local_origem_id")
    private Local localOrigem; // Nome claro ajuda na manutenção

    @ManyToMany
    private List<Local> locaisVisitados; // Aqui ele pode interagir com vários!

    private String nome;
    private String descricao;
}