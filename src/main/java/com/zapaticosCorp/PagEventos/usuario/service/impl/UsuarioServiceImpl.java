package com.zapaticosCorp.PagEventos.usuario.service.impl;

import com.zapaticosCorp.PagEventos.email.dto.EmailDto;
import com.zapaticosCorp.PagEventos.email.service.EmailService;
import com.zapaticosCorp.PagEventos.usuario.dto.*;
import com.zapaticosCorp.PagEventos.usuario.model.*;
import com.zapaticosCorp.PagEventos.usuario.repository.*;
import com.zapaticosCorp.PagEventos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailService email;


    public BasicResponseDto existUsuario(RegistroUsuarioDto dto) {
        if (usuarioRepository.existsByEmailUsuarioAndActivoTrue(dto.getEmail())) {
            return new BasicResponseDto(false, "Ya existe un usuario activo con ese correo.");
        }

        if (usuarioRepository.existsByCodigoUsuarioAndActivoTrue(dto.getCodigo())) {
            return new BasicResponseDto(false, "Ya existe un usuario activo con ese código.");
        }

        return null; // No hay conflicto, todo fino
    }

    public TipoUsuario existTipoUsuario(RegistroUsuarioDto dto) {
        return tipoUsuarioRepository.findByNombreTipoUsuarioIgnoreCase(dto.getTipo());
    }

    @Override
    public BasicResponseDto registrarFuncionario(RegistroFuncionarioDto dto) {
        BasicResponseDto conflicto = existUsuario(dto);
        if (conflicto != null) return conflicto;

        TipoUsuario tipoUsuario = existTipoUsuario(dto);
        if (tipoUsuario == null) {
            return new BasicResponseDto(false, "Tipo de usuario no válido.");
        }

        Optional<Cargo> cargo = cargoRepository.findById(dto.getIdCargo());
        if (cargo.isEmpty()) {
            return new BasicResponseDto(false, "Cargo no encontrado.");
        }

        // 4. Crear y guardar el Usuario
        Usuario nuevoUsuario = new Usuario(
                dto.getNombre(),
                dto.getApellido(),
                dto.getCodigo(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getContrasena()),
                tipoUsuario,
                true
        );
        usuarioRepository.save(nuevoUsuario);

        Funcionario funcionario = new Funcionario(nuevoUsuario, cargo.orElse(null));
        funcionarioRepository.save(funcionario);

        return new BasicResponseDto(true, "Funcionario registrado correctamente.");
    }



    @Override
    public BasicResponseDto registrarEstudiante(RegistroEstudianteDto dto) {
        BasicResponseDto conflicto = existUsuario(dto);
        if (conflicto != null) return conflicto;

        TipoUsuario tipoUsuario = existTipoUsuario(dto);
        if (tipoUsuario == null) {
            return new BasicResponseDto(false, "Tipo de usuario no válido.");
        }

        Optional<Programa> programa = programaRepository.findById(dto.getIdPrograma());
        if (programa.isEmpty()) {
            return new BasicResponseDto(false, "Programa no encontrado.");
        }

        Usuario usuario = new Usuario(
                dto.getNombre(),
                dto.getApellido(),
                dto.getCodigo(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getContrasena()),
                tipoUsuario,
                true
        );
        usuarioRepository.save(usuario);


        Estudiante estudiante = new Estudiante(usuario, programa.orElse(null));
        estudianteRepository.save(estudiante);


        return new BasicResponseDto(true, "Estudiante registrado exitosamente.");
    }


    @Override
    public Usuario buscarPorCorreo(String correo) {
        Optional<Usuario> optUser = usuarioRepository.findByEmailUsuarioAndActivoTrue(correo);
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
    public BasicResponseDto actualizarContrasena(ActualizarContRequestDto request) {
        if(request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            return new BasicResponseDto(false, "Debe ingresar el correo del usuario.");
        }

        Usuario usuario = buscarPorCorreo(request.getEmail());
        if (usuario == null) {
            return new BasicResponseDto(false, "Usuario no encontrado.");
        }

        if (!passwordEncoder.matches(request.getContrasenaActual(), usuario.getContrasenaUsuario())) {
            return new BasicResponseDto(false, "La contraseña actual no es correcta.");
        }

        if (passwordEncoder.matches(request.getContrasenaNueva(), usuario.getContrasenaUsuario())) {
            return new BasicResponseDto(false, "La nueva contraseña no puede ser igual a la anterior.");
        }

        usuario.setContrasenaUsuario(passwordEncoder.encode(request.getContrasenaNueva()));
        usuarioRepository.save(usuario);

        return new BasicResponseDto(true, "Contraseña actualizada correctamente.");
    }

    @Override
    public BasicResponseDto eliminarUsuario(Integer idUsuario) {
        if (idUsuario == null) {
            return new BasicResponseDto(false, "idUsuario no válido");
        }

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);

        if (usuarioOpt.isEmpty()) {
            return new BasicResponseDto(false, "Usuario no encontrado en el sistema");
        }

        Usuario usuario = usuarioOpt.get(); // Obtener el objeto real
        usuario.setActivo(false);
        usuarioRepository.save(usuario);

        email.sendEmail(new EmailDto(usuario.getEmailUsuario())); // Enviar correo al usuario eliminado
        return new BasicResponseDto(true, "El usuario ha sido eliminado correctamente");
    }



    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        if(request.getEmail() == null || request.getEmail().trim().isEmpty()){
            return new LoginResponseDto(false, "Ingrese un Correo", false);
        }
        Usuario usuario = buscarPorCorreo(request.getEmail());
        if (usuario == null || !usuario.getActivo()) {
            return new LoginResponseDto(false, "Usuario no encontrado", false);
        }

        if (!passwordEncoder.matches(request.getContrasena(), usuario.getContrasenaUsuario())) {
            return new LoginResponseDto(false, "Contraseña incorrecta", false);
        }

        boolean isAdmin = isAdmin(usuario);
        return new LoginResponseDto(true, "Inicio de sesión exitoso", isAdmin, usuario.getIdUsuario(), usuario.getIdTipoUsuario().getNombreTipoUsuario(), usuario.getNombreUsuario(), usuario.getEmailUsuario() ,usuario.getRutaImg());
    }



}
