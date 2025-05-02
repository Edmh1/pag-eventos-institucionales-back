package com.zapaticosCorp.PagEventos.evento;

import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import jakarta.persistence.*;

@Entity(name = "organizadores_por_evento")
public class OrganizadorPorEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrganizadorEvento;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEventoOrgEve;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuarioOrgEve;

    public OrganizadorPorEvento(){}

    public OrganizadorPorEvento(Evento idEventoOrgEve, Usuario idUsuarioOrgEve) {
        this.idEventoOrgEve = idEventoOrgEve;
        this.idUsuarioOrgEve = idUsuarioOrgEve;
    }

    public Integer getIdOrganizadorEvento() {
        return idOrganizadorEvento;
    }

    public void setIdOrganizadorEvento(Integer idOrganizadorEvento) {
        this.idOrganizadorEvento = idOrganizadorEvento;
    }

    public Evento getIdEventoOrgEve() {
        return idEventoOrgEve;
    }

    public void setIdEventoOrgEve(Evento idEventoOrgEve) {
        this.idEventoOrgEve = idEventoOrgEve;
    }

    public Usuario getIdUsuarioOrgEve() {
        return idUsuarioOrgEve;
    }

    public void setIdUsuarioOrgEve(Usuario idUsuarioOrgEve) {
        this.idUsuarioOrgEve = idUsuarioOrgEve;
    }
}
