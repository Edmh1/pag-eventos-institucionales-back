package com.zapaticosCorp.PagEventos.evento.controller;

import com.zapaticosCorp.PagEventos.evento.dto.ActualizarEventoDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoCantResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.RegistroEventoDto;
import com.zapaticosCorp.PagEventos.evento.service.EventoService;
import com.zapaticosCorp.PagEventos.usuario.dto.BasicResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/eventos")
@Tag(name = "Eventos", description = "Operaciones relacionadas con eventos")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @Operation(summary = "Verificar estado del servicio", description = "Devuelve OK si el servicio está activo")
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("OK");
    }

    @Operation(summary = "Contar eventos", description = "Devuelve la cantidad total de eventos registrados")
    @GetMapping("/contar")
    public ResponseEntity<EventoCantResponseDto> contarEventos(){
        EventoCantResponseDto response = eventoService.cantEventos();
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Listar eventos paginados",
            description = "Obtiene una lista paginada de eventos"
    )
    @GetMapping
    public ResponseEntity<Page<EventoResponseDto>> paginacionEventos(
            @Parameter(description = "Número de página (inicia en 0)") @RequestParam("pagina") Integer pagina,
            @Parameter(description = "Número de elementos por página") @RequestParam("limite") Integer nElementos){
        Page<EventoResponseDto> response = eventoService.paginarEventos(pagina, nElementos);
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Listar eventos por usuario",
            description = "Obtiene una lista paginada de eventos creados por un usuario específico"
    )
    @GetMapping("/por-user")
    public ResponseEntity<Page<EventoResponseDto>> paginacionEventosPorUsuario(
            @Parameter(description = "Número de página (inicia en 0)") @RequestParam("pagina") Integer pagina,
            @Parameter(description = "Número de elementos por página") @RequestParam("limite") Integer nElementos,
            @Parameter(description = "ID del usuario") @RequestParam("idUsuario") Integer idUsuario){
        Page<EventoResponseDto> response = eventoService.paginarEventosPorUsuario(pagina, nElementos, idUsuario);
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Crear evento",
            description = "Registra un nuevo evento en el sistema"
    )
    @PostMapping
    public ResponseEntity<BasicResponseDto> crearEvento(@RequestBody RegistroEventoDto evento){
        BasicResponseDto response = eventoService.crearEvento(evento);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Actualizar evento",
            description = "Modifica los datos de un evento existente"
    )
    @PatchMapping
    public ResponseEntity<BasicResponseDto> actualizarEvento(@RequestBody ActualizarEventoDto evento){
        BasicResponseDto response = eventoService.actualizarEvento(evento);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Eliminar evento",
            description = "Elimina un evento por su ID"
    )
    @DeleteMapping("/{idEvento}")
    public ResponseEntity<BasicResponseDto> eliminarEvento(
            @Parameter(description = "ID del evento a eliminar") @PathVariable Integer idEvento){
        BasicResponseDto response = eventoService.eliminarEvento(idEvento);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }


}
