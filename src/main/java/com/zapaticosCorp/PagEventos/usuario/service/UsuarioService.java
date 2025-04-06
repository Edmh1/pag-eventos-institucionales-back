package com.zapaticosCorp.PagEventos.usuario.service;

import com.zapaticosCorp.PagEventos.usuario.dto.*;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;

public interface UsuarioService {

    RegistroResponseDto registrarFuncionario(RegistroFuncionarioDto request);
    RegistroResponseDto registrarEstudiante(RegistroEstudianteDto request);

    Usuario buscarPorCorreo(String correo);
    LoginResponseDto login(LoginRequestDto request);
    boolean isAdmin(Usuario usuario);


}
