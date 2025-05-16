package com.zapaticosCorp.PagEventos.evento.dto;


public class ActualizarEventoDto {

    private Integer idEvento;
    private String nombreEvento;
    private String lugarEvento;
    private String rutaImgEvento;

    public ActualizarEventoDto(Integer idEvento, String nombreEvento, String lugarEvento, String rutaImgEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.lugarEvento = lugarEvento;
        this.rutaImgEvento = rutaImgEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
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

    public String getRutaImgEvento() {
        return rutaImgEvento;
    }

    public void setRutaImgEvento(String rutaImgEvento) {
        this.rutaImgEvento = rutaImgEvento;
    }
}
