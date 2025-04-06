package com.zapaticosCorp.PagEventos.usuario.dto;

public class RegistroFuncionarioDto extends  RegistroUsuarioDto{

    private String cargo;

    public RegistroFuncionarioDto(String nombre, String apellido, Integer codigo, String email, String contrasena, String tipo, String cargo) {
        super(nombre, apellido, codigo, email, contrasena, tipo);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
