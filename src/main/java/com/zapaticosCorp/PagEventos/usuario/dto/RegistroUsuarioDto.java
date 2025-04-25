package com.zapaticosCorp.PagEventos.usuario.dto;

public abstract class RegistroUsuarioDto {

    private String nombre;
    private String apellido;
    private Integer codigo;
    private String email;
    private String contrasena;
    private String tipo;

    public RegistroUsuarioDto(String nombre, String apellido, Integer codigo, String email, String contrasena, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.email = email;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
