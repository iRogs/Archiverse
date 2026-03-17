package com.Rogs.worldForge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rogs.worldForge.model.Local;
import com.Rogs.worldForge.repositories.LocalRepository;
import com.Rogs.worldForge.repositories.MundoRepository;

@Service
public class LocalService {
    @Autowired private LocalRepository localRepository;
    @Autowired private MundoRepository mundoRepository;

    public Local salvar(Local local, Long mundoId) {
        var mundo = mundoRepository.findById(mundoId)
            .orElseThrow(() -> new RuntimeException("Mundo não encontrado"));
        
        local.setMundo(mundo);
        return localRepository.save(local);
    }        
}
