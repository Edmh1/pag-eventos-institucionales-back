package com.zapaticosCorp.PagEventos.usuario.controller;


import com.zapaticosCorp.PagEventos.usuario.dto.*;
import com.zapaticosCorp.PagEventos.usuario.model.Programa;
import com.zapaticosCorp.PagEventos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<BasicResponseDto> registrarFuncionario(@RequestBody RegistroFuncionarioDto dto) {
        BasicResponseDto response = usuarioService.registrarFuncionario(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/registro/estudiante")
    public ResponseEntity<BasicResponseDto> registrarEstudiante(@RequestBody RegistroEstudianteDto dto) {
        BasicResponseDto response = usuarioService.registrarEstudiante(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @PutMapping("/actualizar/contrasena")
    public ResponseEntity<BasicResponseDto> actualizarContrasena(@RequestBody ActualizarContRequestDto dto) {
        BasicResponseDto response = usuarioService.actualizarContrasena(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @PutMapping("/actualizar/img")
    public ResponseEntity<BasicResponseDto> actualizarImg(@RequestBody ActualizarImgRequestDto dto) {
        BasicResponseDto response = usuarioService.actualizarImg(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<BasicResponseDto> eliminarUsuario(@PathVariable Integer idUsuario){
        BasicResponseDto response = usuarioService.eliminarUsuario(idUsuario);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

}
