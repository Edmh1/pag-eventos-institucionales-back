package com.zapaticosCorp.PagEventos.evento.dto;

public class EventoCantResponseDto {

    private boolean success;
    private Long cantidadEventos;

    public EventoCantResponseDto(boolean success, Long cantidadEventos) {
        this.success = success;
        this.cantidadEventos = cantidadEventos;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getCantidadEventos() {
        return cantidadEventos;
    }

    public void setCantidadEventos(Long cantidadEventos) {
        this.cantidadEventos = cantidadEventos;
    }
}
