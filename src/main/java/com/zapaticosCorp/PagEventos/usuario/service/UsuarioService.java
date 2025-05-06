package com.zapaticosCorp.PagEventos.usuario.service;

import com.zapaticosCorp.PagEventos.usuario.dto.*;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface UsuarioService {

    BasicResponseDto registrarFuncionario(RegistroFuncionarioDto request);
    BasicResponseDto registrarEstudiante(RegistroEstudianteDto request);
    BasicResponseDto actualizarContrasena(ActualizarContRequestDto request);
    BasicResponseDto eliminarUsuario(Integer idUsuario);

    Usuario buscarPorCorreo(String correo);
    LoginResponseDto login(LoginRequestDto request);
    boolean isAdmin(Usuario usuario);


}
