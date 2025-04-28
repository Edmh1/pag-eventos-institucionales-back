package com.zapaticosCorp.PagEventos.usuario.repository;

import com.zapaticosCorp.PagEventos.usuario.model.Cargo;
import com.zapaticosCorp.PagEventos.usuario.model.Estudiante;
import com.zapaticosCorp.PagEventos.usuario.model.Programa;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Usuario> {
}
