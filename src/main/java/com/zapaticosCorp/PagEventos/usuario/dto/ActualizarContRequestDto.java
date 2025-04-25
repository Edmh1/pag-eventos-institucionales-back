package com.zapaticosCorp.PagEventos.usuario.dto;

public class ActualizarContRequestDto {
    private String email;
    private String contrasenaActual;
    private String nuevaContrasena;

    public ActualizarContRequestDto(String email, String contrasenaActual, String nuevaContrasena) {
        this.email = email;
        this.contrasenaActual = contrasenaActual;
        this.nuevaContrasena = nuevaContrasena;
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

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }
}
