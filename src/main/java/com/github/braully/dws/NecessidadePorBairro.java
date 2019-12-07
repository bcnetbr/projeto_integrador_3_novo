/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.util.Date;
import java.util.HashSet;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Aluno
 */
@Entity
//@Table(name="")
public class NecessidadePorBairro {
    
    @Id
    @GeneratedValue
    private long id;
    @Basic
    int votos;
    
    @ManyToOne
    @JoinColumn(name="id_pais")
    Pais pais;
    @ManyToOne
    @JoinColumn(name="id_estado")
    Estado estado;
    @ManyToOne
    @JoinColumn(name="id_cidade")
    Cidade cidade;
    @ManyToOne
    @JoinColumn(name="id_bairro")
    Bairro bairro;
    @ManyToOne
    @JoinColumn(name="id_necessidade")
    Necessidades necessidade;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    Usuario usuario;
    
   /* @Basic
    long id_pais;
    @Basic
    long id_estado;
    @Basic
    long id_cidade;
    @Basic
    long id_bairro;
    @Basic
    long id_necessidade;
    @Basic
    long id_usuario;
  */  
    @Basic
    String observacao;
       
    public int getVotos() {
        return votos;
    }
   
    public void setVotos(int votos) {
        this.votos = votos;
    }
    
     public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Necessidades getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(Necessidades necessidade) {
        this.necessidade = necessidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


   /* public long getId_pais() {
        return id_pais;
    }

    public void setId_pais(String id_pais) {
        
        this.id_pais = Long.parseLong(id_pais);
    }

    public long getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = Long.parseLong(id_estado);
    }

    public long getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(String id_cidade) {
        this.id_cidade = Long.parseLong(id_cidade);
    }

    public long getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(String id_bairro) {
        this.id_bairro = Long.parseLong(id_bairro);
    }

    public long getId_necessidade() {
        return id_necessidade;
    }

    public void setId_necessidade(String id_necessidade) {
        this.id_necessidade = Long.parseLong(id_necessidade);
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = Long.parseLong(id_usuario);
    }
    
  */  
    
    
    
}
