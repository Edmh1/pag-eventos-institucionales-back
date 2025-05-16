package com.zapaticosCorp.PagEventos.evento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventoResponseDto {

    private Integer idEvento;
    private String rutaImgEvento;
    private String nombreEvento;
    private String lugarEvento;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;


    public EventoResponseDto(Integer idEvento, String rutaImgEvento, String nombreEvento, String lugarEvento, LocalDate fechaEvento, LocalTime horaEvento) {
        this.idEvento = idEvento;
        this.rutaImgEvento = rutaImgEvento;
        this.nombreEvento = nombreEvento;
        this.lugarEvento = lugarEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getRutaImgEvento() {
        return rutaImgEvento;
    }

    public void setRutaImgEvento(String rutaImgEvento) {
        this.rutaImgEvento = rutaImgEvento;
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
