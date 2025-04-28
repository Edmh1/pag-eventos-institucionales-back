package com.zapaticosCorp.PagEventos.usuario.dto;

public class ActualizarContRequestDto {
    private String email;
    private String contrasenaActual;
    private String ContrasenaNueva;

    public ActualizarContRequestDto(String email, String contrasenaActual, String contrasenaNueva) {
        this.email = email;
        this.contrasenaActual = contrasenaActual;
        ContrasenaNueva = contrasenaNueva;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenaActual() {
        return contrasenaActual;
    }

    public void setContrasenaActual(String contrasenaActual) {
        this.contrasenaActual = contrasenaActual;
    }

    public String getContrasenaNueva() {
        return ContrasenaNueva;
    }

    public void setContrasenaNueva(String contrasenaNueva) {
        ContrasenaNueva = contrasenaNueva;
    }
}
