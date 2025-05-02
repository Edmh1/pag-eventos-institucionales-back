package com.zapaticosCorp.PagEventos.evento.model;

import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLike;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuarioLike;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEventoLike;

    @Column(name = "fecha_like", nullable = false)
    private LocalDateTime fechaLike;

    public Like(){}

    public Like(Usuario idUsuarioLike, Evento idEventoLike, LocalDateTime fechaLike) {
        this.idUsuarioLike = idUsuarioLike;
        this.idEventoLike = idEventoLike;
        this.fechaLike = fechaLike;
    }

    public Integer getIdLike() {
        return idLike;
    }

    public void setIdLike(Integer idLike) {
        this.idLike = idLike;
    }

    public Usuario getIdUsuarioLike() {
        return idUsuarioLike;
    }

    public void setIdUsuarioLike(Usuario idUsuarioLike) {
        this.idUsuarioLike = idUsuarioLike;
    }

    public Evento getIdEventoLike() {
        return idEventoLike;
    }

    public void setIdEventoLike(Evento idEventoLike) {
        this.idEventoLike = idEventoLike;
    }

    public LocalDateTime getFechaLike() {
        return fechaLike;
    }

    public void setFechaLike(LocalDateTime fechaLike) {
        this.fechaLike = fechaLike;
    }
}
