package com.zapaticosCorp.PagEventos.usuario.dto;

public class RegistroResponseDto {

    private boolean success;
    private String message;

    public RegistroResponseDto(){

    }

    public RegistroResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
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
}
