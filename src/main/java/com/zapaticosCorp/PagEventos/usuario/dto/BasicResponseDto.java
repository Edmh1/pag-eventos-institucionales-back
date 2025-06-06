package com.zapaticosCorp.PagEventos.usuario.dto;

public class BasicResponseDto {

    private boolean success;
    private String info;

    public BasicResponseDto(){

    }

    public BasicResponseDto(boolean success, String info) {
        this.success = success;
        this.info = info;
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
}
