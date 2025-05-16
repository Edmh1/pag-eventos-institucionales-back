package com.zapaticosCorp.PagEventos.evento.controller;

import com.zapaticosCorp.PagEventos.evento.dto.EventoCantResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.EventoResponseDto;
import com.zapaticosCorp.PagEventos.evento.dto.RegistroEventoDto;
import com.zapaticosCorp.PagEventos.evento.service.EventoService;
import com.zapaticosCorp.PagEventos.usuario.dto.BasicResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/contar")
    public ResponseEntity<EventoCantResponseDto> contarEventos(){
        EventoCantResponseDto response = eventoService.cantEventos();
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @GetMapping
    public ResponseEntity<Page<EventoResponseDto>> paginacionEventos(@RequestParam("pagina") Integer pagina,
                                                                     @RequestParam("limite") Integer nElementos){
        Page<EventoResponseDto> response = eventoService.paginarEventos(pagina, nElementos);
        HttpStatus status = response != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @PostMapping
    public ResponseEntity<BasicResponseDto> crearEvento(@RequestBody RegistroEventoDto evento){
        BasicResponseDto response = eventoService.crearEvento(evento);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }
}
