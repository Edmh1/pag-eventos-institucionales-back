package com.zapaticosCorp.PagEventos.usuario.controller;

import com.zapaticosCorp.PagEventos.usuario.model.Programa;
import com.zapaticosCorp.PagEventos.usuario.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/programas")
public class ProgramaController {

    @Autowired
    private ProgramaService programaService;

    @GetMapping
    public ResponseEntity<List<Programa>> getProgramas() {
        List<Programa> programas = programaService.getProgramas();
        return ResponseEntity.ok(programas);
    }
}
