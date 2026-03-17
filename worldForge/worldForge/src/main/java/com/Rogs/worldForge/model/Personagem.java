package com.Rogs.worldForge.model;


import java.time.LocalDateTime;
import java.util.*;

import com.Rogs.worldForge.DTO.PersonagemDTO;

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
    private Local localOrigem;  //pode ou não existir um local de origem para o personagem (nullable = true)

    @ManyToMany
    private List<Local> locaisVisitados; //nullable = true

    @ManyToOne
    @JoinColumn(name = "dono_id")
    private User dono;

    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao;


    public Personagem(PersonagemDTO personagemDTO) {
        this.nome = personagemDTO.nome();
        this.descricao = personagemDTO.descricao();
        this.dataCriacao = LocalDateTime.now();
    }
}   
