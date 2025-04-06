package com.zapaticosCorp.PagEventos.usuario.model;


import jakarta.persistence.*;

@Entity(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    @Column(nullable = false)
    private String nombreCargo;

    public Cargo(){

    }

    public Cargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
}
