package com.zapaticosCorp.PagEventos.evento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventoResponseDto {

    private String nombreEvento;
    private String lugarEvento;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;


    public EventoResponseDto(String nombreEvento, String lugarEvento, LocalDate fechaEvento, LocalTime horaEvento) {
        this.nombreEvento = nombreEvento;
        this.lugarEvento = lugarEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
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
