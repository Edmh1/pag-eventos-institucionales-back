package com.zapaticosCorp.PagEventos.evento.service.impl;

import com.zapaticosCorp.PagEventos.evento.dto.EventoCantResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.RegistroEventoDto;
import com.zapaticosCorp.PagEventos.evento.model.Evento;
import com.zapaticosCorp.PagEventos.evento.model.TipoEvento;
import com.zapaticosCorp.PagEventos.evento.repository.EventoRepository;
import com.zapaticosCorp.PagEventos.evento.repository.TipoEventoRepository;
import com.zapaticosCorp.PagEventos.evento.service.EventoService;
import com.zapaticosCorp.PagEventos.usuario.dto.BasicResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private TipoEventoRepository tipoEventoRepository;

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

    @Override
    public BasicResponseDto crearEvento(RegistroEventoDto dto) {
        BasicResponseDto conflicto = existEvento(dto);
        if(conflicto != null) return conflicto;

        Optional<TipoEvento> tipoEvento = existTipoEvento(dto);
        if(tipoEvento.isEmpty()){
            return new BasicResponseDto(false, "Tipo de evento no valido.");
        }

        if (dto.getNombreEvento() == null || dto.getNombreEvento().isBlank()) {
            return new BasicResponseDto(false, "El nombre del evento no puede estar vacío.");
        }

        if (dto.getLugarEvento() == null || dto.getLugarEvento().isBlank()) {
            return new BasicResponseDto(false, "El lugar del evento no puede estar vacío.");
        }

        if (dto.getFechaEvento() == null) {
            return new BasicResponseDto(false, "La fecha del evento no puede ser nula.");
        }

        if (dto.getHoraEvento() == null) {
            return new BasicResponseDto(false, "La hora del evento no puede ser nula.");
        }

        // Verificar conflictos de horario con otros eventos
        List<Evento> eventosExistentes = eventoRepository.findByLugarEventoAndFechaEvento(
                dto.getLugarEvento(), dto.getFechaEvento()
        );

        LocalTime nuevaHoraInicio = dto.getHoraEvento();

        for (Evento existente : eventosExistentes) {
            LocalTime inicioExistente = existente.getHoraEvento();
            LocalTime finExistente = existente.getHoraFinEvento();

            if (nuevaHoraInicio.isBefore(finExistente.plusMinutes(30)) &&
                    nuevaHoraInicio.isAfter(inicioExistente.minusMinutes(30))) {
                return new BasicResponseDto(false, "El evento se traslapa con otro existente entre las " +
                        inicioExistente + " y " + finExistente + ". Debe haber al menos 30 minutos de separación.");
            }
        }

        Evento evento = new Evento(tipoEvento.get(),
                dto.getNombreEvento(),
                dto.getLugarEvento(),
                dto.getFechaEvento(),
                dto.getHoraEvento(),
                dto.getHoraFinEvento(),
                dto.getRutaImgEvento());

        eventoRepository.save(evento);

        return new BasicResponseDto(true, "El evento " + evento.getNombreEvento() + " ha sido creado con éxito.");
    }


    private Optional<TipoEvento> existTipoEvento(RegistroEventoDto dto) {
        return tipoEventoRepository.findById(dto.getIdTipoEvento());
    }

    private BasicResponseDto existEvento(RegistroEventoDto dto) {
        if(eventoRepository.existsByLugarEventoAndFechaEventoAndHoraEvento(dto.getLugarEvento(), dto.getFechaEvento(), dto.getHoraEvento())){
            return new BasicResponseDto(false, "No puede existir un evento que se desarrollo en el mismo espacio y momento.");
        }
        return null;
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
