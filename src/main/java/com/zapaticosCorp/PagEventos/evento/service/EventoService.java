package com.zapaticosCorp.PagEventos.evento.service;

import com.zapaticosCorp.PagEventos.evento.dto.EventoCantResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoResponseDto;
import org.springframework.data.domain.Page;


public interface EventoService {

    EventoCantResponseDto cantEventos();
    Page<EventoResponseDto> paginarEventos(Integer pagina, Integer nElementos);
}
