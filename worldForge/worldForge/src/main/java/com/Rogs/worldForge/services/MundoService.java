package com.Rogs.worldForge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rogs.worldForge.repositories.MundoRepository;
import com.Rogs.worldForge.repositories.UserRepository;
import com.Rogs.worldForge.DTO.MundoDTO;
import com.Rogs.worldForge.infra.exceptions.ResourceNotFoundException;
import com.Rogs.worldForge.model.Mundo;
import com.Rogs.worldForge.model.User;

@Service
public class MundoService {

    @Autowired private MundoRepository mundoRepository;
    @Autowired private UserRepository userRepository;


    public Mundo salvar(MundoDTO mundoDTO, Long usuarioId) {

        User dono = userRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        Mundo mundo = new Mundo(mundoDTO);

        mundo.setCriador(dono);

        return mundoRepository.save(mundo);
    }

    public Mundo buscarPorId(Long id) {
        return mundoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Mundo não encontrado"));
    }
}