package com.zapaticosCorp.PagEventos.usuario.controller;

import com.zapaticosCorp.PagEventos.usuario.dto.*;
import com.zapaticosCorp.PagEventos.usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(
            summary = "Iniciar sesión",
            description = "Permite a un usuario autenticarse con su correo y contraseña. Devuelve un token o mensaje de error."
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto request) {

        LoginResponseDto response = usuarioService.login(request);

        if (!response.isSuccess()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(response);
        }

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Registrar funcionario",
            description = "Registra un nuevo usuario con rol de funcionario en el sistema."
    )
    @PostMapping("/registro/funcionario")
    public ResponseEntity<BasicResponseDto> registrarFuncionario(
            @RequestBody RegistroFuncionarioDto dto) {

        BasicResponseDto response = usuarioService.registrarFuncionario(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Registrar estudiante",
            description = "Registra un nuevo usuario con rol de estudiante en el sistema."
    )
    @PostMapping("/registro/estudiante")
    public ResponseEntity<BasicResponseDto> registrarEstudiante(
            @RequestBody RegistroEstudianteDto dto) {

        BasicResponseDto response = usuarioService.registrarEstudiante(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Actualizar contraseña",
            description = "Actualiza la contraseña de un usuario dado su correo actual y nueva clave."
    )
    @PutMapping("/actualizar/contrasena")
    public ResponseEntity<BasicResponseDto> actualizarContrasena(
            @RequestBody ActualizarContRequestDto dto) {

        BasicResponseDto response = usuarioService.actualizarContrasena(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Actualizar imagen de perfil",
            description = "Actualiza la URL de la imagen de perfil del usuario."
    )
    @PutMapping("/actualizar/img")
    public ResponseEntity<BasicResponseDto> actualizarImg(
            @RequestBody ActualizarImgRequestDto dto) {

        BasicResponseDto response = usuarioService.actualizarImg(dto);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }

    @Operation(
            summary = "Eliminar usuario",
            description = "Elimina un usuario del sistema por su ID."
    )
    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<BasicResponseDto> eliminarUsuario(
            @Parameter(description = "ID del usuario a eliminar") @PathVariable Integer idUsuario) {

        BasicResponseDto response = usuarioService.eliminarUsuario(idUsuario);
        HttpStatus status = response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, status);
    }
}
