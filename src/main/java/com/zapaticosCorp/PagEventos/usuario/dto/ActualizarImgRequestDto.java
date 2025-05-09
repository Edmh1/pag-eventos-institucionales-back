package com.zapaticosCorp.PagEventos.usuario.dto;

public class ActualizarImgRequestDto {

    private String email;
    private String url;

    public ActualizarImgRequestDto(String email, String url) {
        this.email = email;
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
