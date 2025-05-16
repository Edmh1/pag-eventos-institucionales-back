package com.zapaticosCorp.PagEventos.evento.controller;

import com.zapaticosCorp.PagEventos.evento.model.TipoEvento;
import com.zapaticosCorp.PagEventos.evento.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos-evento")
public class TipoEventoController {

    @Autowired
    private TipoEventoService tipoEventoService;

    @GetMapping
    public ResponseEntity<List<TipoEvento>> getTipoEvento(){
        List<TipoEvento> tipos = tipoEventoService.getTiposEvento();
        return ResponseEntity.ok(tipos);
    }
}
