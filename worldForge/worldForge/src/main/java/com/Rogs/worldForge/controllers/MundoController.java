package com.Rogs.worldForge.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Rogs.worldForge.DTO.MundoDTO;
import com.Rogs.worldForge.model.Mundo;
import com.Rogs.worldForge.services.MundoService;

@Controller
@RequestMapping("/mundos")
public class MundoController {
    @Autowired
    private MundoService mundoService;

    @PostMapping
    public ResponseEntity<Mundo> criarMundo(@RequestBody MundoDTO mundoDTO, @RequestParam Long usuarioId) {
        Mundo salvo = mundoService.salvar(mundoDTO, usuarioId);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Mundo> obterMundo(@PathVariable Long id) {
        return mundoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
