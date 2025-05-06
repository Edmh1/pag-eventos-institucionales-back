package com.zapaticosCorp.PagEventos.evento.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_evento", nullable = false)
    private TipoEvento idTipoEvento;

    @Column(name = "nombre_evento", nullable = false)
    private String nombreEvento;

    @Column(name = "lugar_evento")
    private String lugarEvento;

    @Column(name = "fecha_evento")
    private LocalDate fechaEvento;

    @Column(name = "hora_evento")
    private LocalTime horaEvento;

    @Column
    private String rutaImgEvento;

    public Evento(){}

    public Evento(TipoEvento idTipoEvento, String nombreEvento, String lugarEvento, LocalDate fechaEvento, LocalTime horaEvento, String rutaImgEvento) {
        this.idTipoEvento = idTipoEvento;
        this.nombreEvento = nombreEvento;
        this.lugarEvento = lugarEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.rutaImgEvento = rutaImgEvento;
    }

    public String getRutaImgEvento() {
        return rutaImgEvento;
    }

    public void setRutaImgEvento(String rutaImgEvento) {
        this.rutaImgEvento = rutaImgEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public TipoEvento getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(TipoEvento idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getLugarEvento() {
        return lugarEvento;
    }

    public void setLugarEvento(String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public LocalTime getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(LocalTime horaEvento) {
        this.horaEvento = horaEvento;
    }
}
