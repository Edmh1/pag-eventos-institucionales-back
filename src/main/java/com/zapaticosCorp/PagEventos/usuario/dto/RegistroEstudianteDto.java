package com.zapaticosCorp.PagEventos.usuario.dto;

public class RegistroEstudianteDto extends  RegistroUsuarioDto{

    private String programa;

    public RegistroEstudianteDto(String nombre, String apellido, Integer codigo, String email, String contrasena, String tipo, String programa) {
        super(nombre, apellido, codigo, email, contrasena, tipo);
        this.programa = programa;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
