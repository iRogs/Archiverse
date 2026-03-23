package com.Rogs.worldForge.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "mundo_id")
    private Mundo mundo; 

    @OneToMany(mappedBy = "localOrigem")
    private List<Personagem> personagensNativos;
}
