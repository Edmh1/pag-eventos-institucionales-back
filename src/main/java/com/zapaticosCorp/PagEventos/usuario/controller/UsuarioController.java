package com.zapaticosCorp.PagEventos.usuario.controller;


import com.zapaticosCorp.PagEventos.usuario.dto.*;
import com.zapaticosCorp.PagEventos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        LoginResponseDto response = usuarioService.login(request);

        if (!response.isSuccess()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(response);
        }

        return ResponseEntity.ok(response);
    }


    @PostMapping("/registro/funcionario")
    public ResponseEntity<RegistroResponseDto> registrarFuncionario(@RequestBody RegistroFuncionarioDto dto) {
        RegistroResponseDto response = usuarioService.registrarFuncionario(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/registro/estudiante")
    public ResponseEntity<RegistroResponseDto> registrarEstudiante(@RequestBody RegistroEstudianteDto dto) {
        RegistroResponseDto response = usuarioService.registrarEstudiante(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }
}
