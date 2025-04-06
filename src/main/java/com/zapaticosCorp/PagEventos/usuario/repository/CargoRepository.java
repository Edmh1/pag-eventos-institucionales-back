package com.zapaticosCorp.PagEventos.usuario.repository;

import com.zapaticosCorp.PagEventos.usuario.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Integer> {

    Cargo findByNombreCargoIgnoreCase(String cargo);
}
