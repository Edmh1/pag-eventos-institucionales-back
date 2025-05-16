package com.zapaticosCorp.PagEventos.evento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroEventoDto {

    private Integer idTipoEvento;
    private String nombreEvento;
    private String lugarEvento;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;
    private LocalTime horaFinEvento;
    private String rutaImgEvento;
    private Integer idUsuario;

    public RegistroEventoDto(Integer idTipoEvento, String nombreEvento, String lugarEvento, LocalDate fechaEvento, LocalTime horaEvento, LocalTime horaFinEvento, String rutaImgEvento, Integer idUsuario) {
        this.idTipoEvento = idTipoEvento;
        this.nombreEvento = nombreEvento;
        this.lugarEvento = lugarEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.horaFinEvento = horaFinEvento;
        this.rutaImgEvento = rutaImgEvento;
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Integer idTipoEvento) {
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

    public LocalTime getHoraFinEvento() {
        return horaFinEvento;
    }

    public void setHoraFinEvento(LocalTime horaFinEvento) {
        this.horaFinEvento = horaFinEvento;
    }

    public String getRutaImgEvento() {
        return rutaImgEvento;
    }

    public void setRutaImgEvento(String rutaImgEvento) {
        this.rutaImgEvento = rutaImgEvento;
    }
}
