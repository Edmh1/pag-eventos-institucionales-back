package com.zapaticosCorp.PagEventos.evento.service.impl;

import com.zapaticosCorp.PagEventos.evento.dto.ActualizarEventoDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoCantResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.RegistroEventoDto;
import com.zapaticosCorp.PagEventos.evento.model.Evento;
import com.zapaticosCorp.PagEventos.evento.model.OrganizadorPorEvento;
import com.zapaticosCorp.PagEventos.evento.model.TipoEvento;
import com.zapaticosCorp.PagEventos.evento.repository.EventoRepository;
import com.zapaticosCorp.PagEventos.evento.repository.OrganizadorPorEventoRepository;
import com.zapaticosCorp.PagEventos.evento.repository.TipoEventoRepository;
import com.zapaticosCorp.PagEventos.evento.service.EventoService;
import com.zapaticosCorp.PagEventos.usuario.dto.BasicResponseDto;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import com.zapaticosCorp.PagEventos.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private TipoEventoRepository tipoEventoRepository;

    @Autowired
    private OrganizadorPorEventoRepository organizadorPorEventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public EventoCantResponseDto cantEventos() {
        Long cantidad = eventoRepository.count();
        return new EventoCantResponseDto(true, cantidad);
    }

    @Override
    public Page<EventoResponseDto> paginarEventos(Integer pagina, Integer nElementos) {
        Pageable pageable = PageRequest.of(pagina-1, nElementos);
        Page<Evento> eventosPage = eventoRepository.findAllByActivoTrue(pageable);
        return eventosPage.map(this::convertirADto);
    }

    @Override
    public Page<EventoResponseDto> paginarEventosPorUsuario(Integer pagina, Integer nElementos, Integer idUsuario) {
        Pageable pageable = PageRequest.of(pagina - 1, nElementos);
        // Obtener todos los eventos activos
        List<Evento> eventos = eventoRepository.findAllByActivoTrue();
        // Filtrar los eventos que pertenezcan al usuario
        List<EventoResponseDto> eventosFiltrados = eventos.stream()
                .filter(evento -> organizadorPorEventoRepository.existsByIdEventoOrgEve_IdEventoAndIdUsuarioOrgEve_IdUsuario(evento.getIdEvento(), idUsuario))
                .map(this::convertirADto)
                .toList();
        // Calcular el inicio y el fin de la sublista para la paginación
        int start = Math.toIntExact(pageable.getOffset());
        int end = Math.min((start + pageable.getPageSize()), eventosFiltrados.size());
        // Crear la sublista para la página actual
        List<EventoResponseDto> eventosPaginados = eventosFiltrados.subList(start, end);
        // Convertir la lista filtrada en un Page
        return new PageImpl<>(eventosPaginados, pageable, eventosFiltrados.size());
    }

    @Override
    public BasicResponseDto eliminarEvento(Integer idEvento) {
        if(idEvento == null) {
            return new BasicResponseDto(false, "idEvento no válido");
        }

        Optional<Evento> eventoOpt = eventoRepository.findById(idEvento);

        if (eventoOpt.isEmpty()) {
            return new BasicResponseDto(false, "Evento no encontrado en el sistema");
        }

        Evento evento = eventoOpt.get(); // Obtener el objeto real
        if(!evento.getActivo()){
            return new BasicResponseDto(false, "Evento no encontrado en el sistema");
        }

        evento.setActivo(false);
        eventoRepository.save(evento);

        return new BasicResponseDto(true, "El Evento ha sido eliminado correctamente");
    }

    private EventoResponseDto convertirADto(Evento evento) {
        return new EventoResponseDto(
                evento.getIdEvento(),
                evento.getRutaImgEvento(),
                evento.getNombreEvento(),
                evento.getLugarEvento(),
                evento.getFechaEvento(),
                evento.getHoraEvento()
        );
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
                dto.getRutaImgEvento(),
                true);

        eventoRepository.save(evento);

        Optional<Usuario> usuario = usuarioRepository.findById(dto.getIdUsuario());

        organizadorPorEventoRepository.save(new OrganizadorPorEvento(evento, usuario.get()));

        return new BasicResponseDto(true, "El evento " + evento.getNombreEvento() + " ha sido creado con éxito.");
    }

    @Override
    public BasicResponseDto actualizarEvento(ActualizarEventoDto dto) {
        try {
            Evento evento = eventoRepository.findById(dto.getIdEvento())
                    .orElse(null);

            if (evento == null) {
                return new BasicResponseDto(false, "El evento con ID " + dto.getIdEvento() + " no fue encontrado.");
            }

            if (dto.getNombreEvento() != null) {
                evento.setNombreEvento(dto.getNombreEvento());
            }

            if (dto.getLugarEvento() != null) {
                evento.setLugarEvento(dto.getLugarEvento());
            }

            if (dto.getRutaImgEvento() != null) {
                evento.setRutaImgEvento(dto.getRutaImgEvento());
            }

            eventoRepository.save(evento);
            return new BasicResponseDto(true, "El evento ha sido actualizado con éxito.");

        } catch (Exception e) {
            return new BasicResponseDto(false, "Ocurrió un error al actualizar el evento: " + e.getMessage());
        }
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
}
