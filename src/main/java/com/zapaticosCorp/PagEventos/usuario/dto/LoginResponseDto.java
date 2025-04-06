package com.zapaticosCorp.PagEventos.usuario.dto;

public class LoginResponseDto {

    private boolean success;
    private String message;
    private boolean isAdmin;

    public LoginResponseDto(){

    }

    public LoginResponseDto(boolean success, String message, boolean isAdmin) {
        this.success = success;
        this.message = message;
        this.isAdmin = isAdmin;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
