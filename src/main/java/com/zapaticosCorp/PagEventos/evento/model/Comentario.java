package com.zapaticosCorp.PagEventos.evento.model;

import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuarioComentario;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEventoComentario;

    @Column(name = "titulo_comentario", nullable = false)
    private String tituloComentario;

    @Column(name = "descripcion_comentario", nullable = false)
    private String descripcionComentario;

    @Column(name = "fecha_comentario", nullable = false)
    private LocalDate fechaComentario;

    public Comentario(){}

    public Comentario(Usuario idUsuarioComentario, Evento idEventoComentario, String tituloComentario, String descripcionComentario, LocalDate fechaComentario) {
        this.idUsuarioComentario = idUsuarioComentario;
        this.idEventoComentario = idEventoComentario;
        this.tituloComentario = tituloComentario;
        this.descripcionComentario = descripcionComentario;
        this.fechaComentario = fechaComentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Usuario getIdUsuarioComentario() {
        return idUsuarioComentario;
    }

    public void setIdUsuarioComentario(Usuario idUsuarioComentario) {
        this.idUsuarioComentario = idUsuarioComentario;
    }

    public Evento getIdEventoComentario() {
        return idEventoComentario;
    }

    public void setIdEventoComentario(Evento idEventoComentario) {
        this.idEventoComentario = idEventoComentario;
    }

    public String getTituloComentario() {
        return tituloComentario;
    }

    public void setTituloComentario(String tituloComentario) {
        this.tituloComentario = tituloComentario;
    }

    public String getDescripcionComentario() {
        return descripcionComentario;
    }

    public void setDescripcionComentario(String descripcionComentario) {
        this.descripcionComentario = descripcionComentario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}
