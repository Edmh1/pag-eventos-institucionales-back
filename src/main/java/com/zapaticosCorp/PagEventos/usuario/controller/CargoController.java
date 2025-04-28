package com.zapaticosCorp.PagEventos.usuario.controller;

import com.zapaticosCorp.PagEventos.usuario.model.Cargo;
import com.zapaticosCorp.PagEventos.usuario.model.Programa;
import com.zapaticosCorp.PagEventos.usuario.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> getCargos() {
        List<Cargo> cargos = cargoService.getCargos();
        return ResponseEntity.ok(cargos);
    }
}
