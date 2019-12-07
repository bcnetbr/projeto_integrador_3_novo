package com.github.braully.dws;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ControleVoto {

    @Id
    @GeneratedValue
    private long id;
    @Basic
    @ManyToOne
    @JoinColumn(name = "id_voto")
    NecessidadePorBairro necessidade;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NecessidadePorBairro getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(NecessidadePorBairro necessidade) {
        this.necessidade = necessidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}