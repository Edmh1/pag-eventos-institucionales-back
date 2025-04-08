package com.zapaticosCorp.PagEventos.usuario.service.impl;

import com.zapaticosCorp.PagEventos.usuario.dto.*;
import com.zapaticosCorp.PagEventos.usuario.model.*;
import com.zapaticosCorp.PagEventos.usuario.repository.*;
import com.zapaticosCorp.PagEventos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ProgramaRepository programaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;


    public RegistroResponseDto existUsuario(RegistroUsuarioDto dto) {
        if (usuarioRepository.existsByEmailUsuario(dto.getEmail())) {
            return new RegistroResponseDto(false, "Ya existe un usuario con ese correo.");
        }
        if (usuarioRepository.existsByCodigoUsuario(dto.getCodigo())) {
            return new RegistroResponseDto(false, "Ya existe un usuario con ese código.");
        }
        return null; // No hay conflicto, todo fino
    }

    public TipoUsuario existTipoUsuario(RegistroUsuarioDto dto) {
        return tipoUsuarioRepository.findByNombreTipoUsuarioIgnoreCase(dto.getTipo());
    }

    @Override
    public RegistroResponseDto registrarFuncionario(RegistroFuncionarioDto dto) {
        RegistroResponseDto conflicto = existUsuario(dto);
        if (conflicto != null) return conflicto;

        TipoUsuario tipoUsuario = existTipoUsuario(dto);
        if (tipoUsuario == null) {
            return new RegistroResponseDto(false, "Tipo de usuario no válido.");
        }

        Cargo cargo = cargoRepository.findByNombreCargoIgnoreCase(dto.getCargo());
        if (cargo == null) {
            return new RegistroResponseDto(false, "Cargo no encontrado.");
        }

        // 4. Crear y guardar el Usuario
        Usuario nuevoUsuario = new Usuario(
                dto.getNombre(),
                dto.getApellido(),
                dto.getCodigo(),
                dto.getEmail(),
                dto.getContrasena(),
                tipoUsuario
        );
        usuarioRepository.save(nuevoUsuario);

        Funcionario funcionario = new Funcionario(nuevoUsuario, cargo);
        funcionarioRepository.save(funcionario);

        return new RegistroResponseDto(true, "Funcionario registrado correctamente.");
    }



    @Override
    public RegistroResponseDto registrarEstudiante(RegistroEstudianteDto dto) {
        RegistroResponseDto conflicto = existUsuario(dto);
        if (conflicto != null) return conflicto;

        TipoUsuario tipoUsuario = existTipoUsuario(dto);
        if (tipoUsuario == null) {
            return new RegistroResponseDto(false, "Tipo de usuario no válido.");
        }

        Programa programa = programaRepository.findByNombreProgramaIgnoreCase(dto.getPrograma());
        if (programa == null) {
            return new RegistroResponseDto(false, "Programa no encontrado.");
        }

        Usuario usuario = new Usuario(
                dto.getNombre(),
                dto.getApellido(),
                dto.getCodigo(),
                dto.getEmail(),
                dto.getContrasena(),
                tipoUsuario
        );
        usuarioRepository.save(usuario);


        Estudiante estudiante = new Estudiante(usuario, programa);
        estudianteRepository.save(estudiante);


        return new RegistroResponseDto(true, "Estudiante registrado exitosamente.");
    }


    @Override
    public Usuario buscarPorCorreo(String correo) {
        Optional<Usuario> optUser = usuarioRepository.findByEmailUsuario(correo);
        return optUser.orElse(null);
    }

    @Override
    public boolean isAdmin(Usuario usuario) {
        String tipoUsuario = usuario.getIdTipoUsuario().getNombreTipoUsuario();
        if (!"Funcionario".equalsIgnoreCase(tipoUsuario)) {
            return false;
        }
        Funcionario funcionario = funcionarioRepository.findByIdUsuarioFuncionario(usuario.getIdUsuario());
        if(funcionario == null){
            return false;
        }
        String nombreCargo = funcionario.getIdCargoFuncionario().getNombreCargo();
        if (!"Administrador de eventos".equalsIgnoreCase(nombreCargo)) {
            return false;
        }
        return true;

    }


    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        if(request.getEmail() == null || request.getEmail().trim().isEmpty()){
            return new LoginResponseDto(false, "Ingrese un Correo", false);
        }
        Usuario usuario = buscarPorCorreo(request.getEmail());
        if (usuario == null) {
            return new LoginResponseDto(false, "Usuario no encontrado", false);
        }

        if (!usuario.getContrasenaUsuario().equals(request.getContrasena())) {
            return new LoginResponseDto(false, "Contraseña incorrecta", false);
        }

        boolean isAdmin = isAdmin(usuario);
        return new LoginResponseDto(true, "Inicio de sesión exitoso", isAdmin, usuario.getIdTipoUsuario().getNombreTipoUsuario(), usuario.getNombreUsuario());
    }



}
