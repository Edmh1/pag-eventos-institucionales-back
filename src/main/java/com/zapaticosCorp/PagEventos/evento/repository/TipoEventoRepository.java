package com.zapaticosCorp.PagEventos.evento.repository;

import com.zapaticosCorp.PagEventos.evento.model.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer> {


}
