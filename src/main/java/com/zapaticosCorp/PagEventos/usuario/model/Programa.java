package com.zapaticosCorp.PagEventos.usuario.model;

import jakarta.persistence.*;

@Entity(name = "programas")
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrograma;

    @Column(nullable = false)
    private String nombrePrograma;

    public Programa(){

    }

    public Programa(Integer idPrograma, String nombrePrograma) {
        this.idPrograma = idPrograma;
        this.nombrePrograma = nombrePrograma;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
}
