package com.zapaticosCorp.PagEventos.usuario.service.impl;

import com.zapaticosCorp.PagEventos.usuario.model.Cargo;
import com.zapaticosCorp.PagEventos.usuario.repository.CargoRepository;
import com.zapaticosCorp.PagEventos.usuario.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<Cargo> getCargos() {
        ArrayList<Cargo> cargos = (ArrayList<Cargo>) cargoRepository.findAll();
        return cargos;
    }
}
