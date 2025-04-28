package com.zapaticosCorp.PagEventos.usuario.service.impl;

import com.zapaticosCorp.PagEventos.usuario.model.Programa;
import com.zapaticosCorp.PagEventos.usuario.repository.ProgramaRepository;
import com.zapaticosCorp.PagEventos.usuario.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private ProgramaRepository programaRepository;

    @Override
    public List<Programa> getProgramas(){
        ArrayList<Programa> programas = (ArrayList<Programa>) programaRepository.findAll();
        return programas;
    }

}
