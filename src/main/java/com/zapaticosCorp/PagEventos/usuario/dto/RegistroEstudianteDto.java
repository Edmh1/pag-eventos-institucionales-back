package com.zapaticosCorp.PagEventos.usuario.dto;

public class RegistroEstudianteDto extends  RegistroUsuarioDto{

    private Integer idPrograma;

    public RegistroEstudianteDto(String nombre, String apellido, Integer codigo, String email, String contrasena, String tipo, Integer idPrograma) {
        super(nombre, apellido, codigo, email, contrasena, tipo);
        this.idPrograma = idPrograma;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }
}
