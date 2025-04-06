package com.zapaticosCorp.PagEventos.usuario.model;


import jakarta.persistence.*;

@Entity(name = "funcionarios")
public class Funcionario {

    @Id
    @Column(name = "id_usuario_funcionario")
    private Integer idUsuarioFuncionario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario_funcionario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cargo_funcionario", nullable = false)
    private Cargo idCargoFuncionario;

    public Funcionario(){

    }

    public Funcionario(Usuario usuario, Cargo idCargoFuncionario) {
        this.usuario = usuario;
        this.idCargoFuncionario = idCargoFuncionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cargo getIdCargoFuncionario() {
        return idCargoFuncionario;
    }

    public void setIdCargoFuncionario(Cargo idCargoFuncionario) {
        this.idCargoFuncionario = idCargoFuncionario;
    }
}
