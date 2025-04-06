package com.zapaticosCorp.PagEventos.usuario.repository;

import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailUsuario(String email);

    boolean existsByEmailUsuario(String email);
    boolean existsByCodigoUsuario(Integer cod);
}
