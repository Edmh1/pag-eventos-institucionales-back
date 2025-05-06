package com.zapaticosCorp.PagEventos.evento.repository;

import com.zapaticosCorp.PagEventos.evento.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {


}
