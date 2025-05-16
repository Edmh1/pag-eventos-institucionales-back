package com.zapaticosCorp.PagEventos.evento.repository;


import com.zapaticosCorp.PagEventos.evento.model.OrganizadorPorEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizadorPorEventoRepository extends JpaRepository<OrganizadorPorEvento,Integer> {

}
