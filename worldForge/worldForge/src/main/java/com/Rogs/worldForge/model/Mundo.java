package com.Rogs.worldForge.model;

import java.time.LocalDateTime;
import java.util.List;

import com.Rogs.worldForge.DTO.MundoDTO;
import com.Rogs.worldForge.DTO.PersonagemDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mundo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "criador_id")
    private User criador;

    @OneToMany(mappedBy = "mundo", cascade = CascadeType.ALL)
    private List<Local> locais;
    
    private LocalDateTime dataCriacao;

     public Mundo(MundoDTO mundoDTO) {
        this.nome = mundoDTO.nome();
        this.descricao = mundoDTO.descricao();
        this.dataCriacao = LocalDateTime.now();
    }
    
}
