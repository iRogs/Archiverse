package com.Rogs.worldForge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Rogs.worldForge.DTO.PersonagemDTO;
import com.Rogs.worldForge.model.Mundo;
import com.Rogs.worldForge.model.Personagem;
import com.Rogs.worldForge.repositories.MundoRepository;
import com.Rogs.worldForge.repositories.PersonagemRepository;
import com.Rogs.worldForge.services.PersonagemService;

@Controller
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;
    @Autowired
    MundoRepository mundoRepository;

    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody PersonagemDTO personagemDTO) {
        
       if (!mundoRepository.existsById(personagemDTO.mundoId())) {
            return ResponseEntity.badRequest().build();
        } 
        Personagem salvo = personagemService.salvar(personagemDTO);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> obterPersonagem(@PathVariable Long id) {
        Personagem personagem = personagemService.buscarPorId(id);
        return ResponseEntity.ok(personagem);
    }

}
