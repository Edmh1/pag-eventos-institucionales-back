package com.zapaticosCorp.PagEventos.usuario.dto;

public class LoginResponseDto {

    private boolean success;
    private String info;
    private boolean isAdmin;
    private String tipoUsuario;
    private String nombreUsuario;

    public LoginResponseDto(){

    }

    public LoginResponseDto(boolean success, String info, boolean isAdmin) {
        this.success = success;
        this.info = info;
        this.isAdmin = isAdmin;
    }

    public LoginResponseDto(boolean success, String info, boolean isAdmin, String tipoUsuario, String nombreUsuario) {
        this.success = success;
        this.info = info;
        this.isAdmin = isAdmin;
        this.tipoUsuario = tipoUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
