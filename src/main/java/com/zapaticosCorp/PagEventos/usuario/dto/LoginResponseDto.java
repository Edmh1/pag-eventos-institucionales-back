package com.zapaticosCorp.PagEventos.usuario.dto;

public class LoginResponseDto {

    private boolean success;
    private String info;
    private boolean isAdmin;
    private Integer idUsuario;
    private String tipoUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String rutaImg;

    public LoginResponseDto(){

    }

    public LoginResponseDto(boolean success, String info, boolean isAdmin) {
        this.success = success;
        this.info = info;
        this.isAdmin = isAdmin;
    }

    public LoginResponseDto(boolean success, String info, boolean isAdmin, Integer idUsuario ,String tipoUsuario, String nombreUsuario, String emailUsuario, String rutaImg) {
        this.success = success;
        this.info = info;
        this.isAdmin = isAdmin;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.rutaImg = rutaImg;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
