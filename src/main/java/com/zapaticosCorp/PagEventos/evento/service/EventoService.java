package com.zapaticosCorp.PagEventos.evento.service;

import com.zapaticosCorp.PagEventos.evento.dto.ActualizarEventoDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoCantResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.RegistroEventoDto;
import com.zapaticosCorp.PagEventos.usuario.dto.BasicResponseDto;
import org.springframework.data.domain.Page;


public interface EventoService {

    EventoCantResponseDto cantEventos();
    Page<EventoResponseDto> paginarEventos(Integer pagina, Integer nElementos);

    BasicResponseDto crearEvento(RegistroEventoDto evento);

    BasicResponseDto actualizarEvento(ActualizarEventoDto evento);
}
