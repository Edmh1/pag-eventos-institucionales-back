package com.zapaticosCorp.PagEventos.evento.repository;

import com.zapaticosCorp.PagEventos.evento.model.Evento;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    boolean existsByLugarEventoAndFechaEventoAndHoraEvento(String lugarEvento, LocalDate fechaEvento, LocalTime horaEvento);
    List<Evento> findByLugarEventoAndFechaEvento(String lugarEvento, LocalDate fechaEvento);

    Page<Evento> findAllByActivoTrue(Pageable pageable);
}
