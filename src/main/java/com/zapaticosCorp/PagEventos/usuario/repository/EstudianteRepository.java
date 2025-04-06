package com.zapaticosCorp.PagEventos.usuario.repository;

import com.zapaticosCorp.PagEventos.usuario.model.Estudiante;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Usuario> {
}
