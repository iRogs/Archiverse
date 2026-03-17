package com.Rogs.worldForge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Rogs.worldForge.DTO.PersonagemDTO;
import com.Rogs.worldForge.model.Mundo;
import com.Rogs.worldForge.model.Personagem;
import com.Rogs.worldForge.repositories.MundoRepository;
import com.Rogs.worldForge.repositories.PersonagemRepository;

@Controller
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    PersonagemRepository personagemRepository;
    @Autowired
    MundoRepository mundoRepository;

    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody PersonagemDTO personagemDTO) {
        

       if (!mundoRepository.existsById(personagemDTO.mundoId())) {
            return ResponseEntity.badRequest().build();
        } 
        Personagem personagem = new Personagem(personagemDTO);
        personagemRepository.save(personagem);
        return ResponseEntity.ok(personagem);
    }

}
