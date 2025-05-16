package com.zapaticosCorp.PagEventos.evento.service.impl;

import com.zapaticosCorp.PagEventos.evento.model.TipoEvento;
import com.zapaticosCorp.PagEventos.evento.repository.TipoEventoRepository;
import com.zapaticosCorp.PagEventos.evento.service.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEventoServiceImpl implements TipoEventoService {

    @Autowired
    private TipoEventoRepository tipoEventoRepository;

    @Override
    public List<TipoEvento> getTiposEvento() {
        return tipoEventoRepository.findAll();
    }
}
