package com.Rogs.worldForge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rogs.worldForge.DTO.PersonagemDTO;
import com.Rogs.worldForge.model.Local;
import com.Rogs.worldForge.model.Mundo;
import com.Rogs.worldForge.model.Personagem;
import com.Rogs.worldForge.model.User;
import com.Rogs.worldForge.repositories.LocalRepository;
import com.Rogs.worldForge.repositories.MundoRepository;
import com.Rogs.worldForge.repositories.PersonagemRepository;
import com.Rogs.worldForge.repositories.UserRepository;

@Service
public class PersonagemService {

    @Autowired private PersonagemRepository personagemRepository;
    @Autowired private MundoRepository mundoRepository;
    @Autowired private LocalRepository localRepository;


    public Personagem salvar(PersonagemDTO dto) {

        Mundo mundo = mundoRepository.findById(dto.mundoId())
            .orElseThrow(() -> new RuntimeException("Mundo não encontrado"));
        Personagem personagem = new Personagem(dto);
        
        personagem.setMundo(mundo);

        if (dto.localOrigemId() != null) {
            Local local = localRepository.findById(dto.localOrigemId())
                .orElseThrow(() -> new RuntimeException("Local de origem não encontrado!"));
            
            if (!local.getMundo().getId().equals(mundo.getId())) {
                throw new RuntimeException("Este local não pertence a este mundo!");
            }
            
            personagem.setLocalOrigem(local);
        }

        return personagemRepository.save(personagem);

    }

    public Optional<Personagem> buscarPorId(Long id) {
        return personagemRepository.findById(id);
    }
}