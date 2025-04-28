package com.zapaticosCorp.PagEventos.usuario.dto;

public class RegistroFuncionarioDto extends  RegistroUsuarioDto{

    private Integer idCargo;

    public RegistroFuncionarioDto(String nombre, String apellido, Integer codigo, String email, String contrasena, String tipo, Integer idCargo) {
        super(nombre, apellido, codigo, email, contrasena, tipo);
        this.idCargo = idCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
}
