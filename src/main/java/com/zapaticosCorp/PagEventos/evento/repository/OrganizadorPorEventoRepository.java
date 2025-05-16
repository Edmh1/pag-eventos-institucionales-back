package com.zapaticosCorp.PagEventos.evento.repository;


import com.zapaticosCorp.PagEventos.evento.model.Evento;
import com.zapaticosCorp.PagEventos.evento.model.OrganizadorPorEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizadorPorEventoRepository extends JpaRepository<OrganizadorPorEvento,Integer> {

    boolean existsByIdEventoOrgEve_IdEventoAndIdUsuarioOrgEve_IdUsuario(Integer idEvento, Integer idUsuario);
}
