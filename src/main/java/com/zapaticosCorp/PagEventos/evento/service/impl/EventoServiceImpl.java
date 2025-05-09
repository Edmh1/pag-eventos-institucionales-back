package com.zapaticosCorp.PagEventos.evento.service.impl;

import com.zapaticosCorp.PagEventos.evento.dto.EventoCantResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoResponseDto;
import com.zapaticosCorp.PagEventos.evento.model.Evento;
import com.zapaticosCorp.PagEventos.evento.repository.EventoRepository;
import com.zapaticosCorp.PagEventos.evento.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public EventoCantResponseDto cantEventos() {
        Long cantidad = eventoRepository.count();
        return new EventoCantResponseDto(true, cantidad);
    }

    @Override
    public Page<EventoResponseDto> paginarEventos(Integer pagina, Integer nElementos) {
        Pageable pageable = PageRequest.of(pagina-1, nElementos);
        Page<Evento> eventosPage = eventoRepository.findAll(pageable);
        return eventosPage.map(this::convertirADto);
    }

    private EventoResponseDto convertirADto(Evento evento) {
        return new EventoResponseDto(
                evento.getRutaImgEvento(),
                evento.getNombreEvento(),
                evento.getLugarEvento(),
                evento.getFechaEvento(),
                evento.getHoraEvento()
        );
    }
}
