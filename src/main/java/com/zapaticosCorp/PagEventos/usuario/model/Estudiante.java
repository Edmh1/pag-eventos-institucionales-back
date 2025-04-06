package com.zapaticosCorp.PagEventos.usuario.model;

import jakarta.persistence.*;

@Entity(name = "estudiantes")
public class Estudiante {

    @Id
    @Column(name = "id_usuario_estudiante")
    private Integer idUsuarioEstudiante;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario_estudiante")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_programa_estudiante", nullable = false)
    private Programa idProgramaEstudiante;

    public Estudiante(){

    }

    public Estudiante(Usuario usuario, Programa idProgramaEstudiante) {
        this.usuario = usuario;
        this.idProgramaEstudiante = idProgramaEstudiante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Programa getIdProgramaEstudiante() {
        return idProgramaEstudiante;
    }

    public void setIdProgramaEstudiante(Programa idProgramaEstudiante) {
        this.idProgramaEstudiante = idProgramaEstudiante;
    }
}
