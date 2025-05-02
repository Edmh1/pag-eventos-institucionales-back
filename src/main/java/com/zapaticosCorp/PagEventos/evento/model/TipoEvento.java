package com.zapaticosCorp.PagEventos.evento.model;

import jakarta.persistence.*;

@Entity(name = "tipos_eventos")
public class TipoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoEvento;

    @Column(name = "nombre_tipo_evento", nullable = false)
    private String nombreTipoEvento;

    public TipoEvento(){}

    public TipoEvento(String nombreTipoEvento) {
        this.nombreTipoEvento = nombreTipoEvento;
    }

    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getNombreTipoEvento() {
        return nombreTipoEvento;
    }

    public void setNombreTipoEvento(String nombreTipoEvento) {
        this.nombreTipoEvento = nombreTipoEvento;
    }
}
