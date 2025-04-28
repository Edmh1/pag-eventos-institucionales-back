package com.zapaticosCorp.PagEventos.usuario.repository;

import com.zapaticosCorp.PagEventos.usuario.dto.RegistroEstudianteDto;
import com.zapaticosCorp.PagEventos.usuario.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Integer> {

    Programa findByNombreProgramaIgnoreCase(String programa);
}
