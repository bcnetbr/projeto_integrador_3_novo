/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;


import java.util.Date;
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
public class Bairro {
    
    @Id
    @GeneratedValue
    private long id;
    @Basic
    String nome;
    @Basic
    String qtd_habitantes;
    @ManyToOne
    @JoinColumn(name="id_cidade")
    Cidade cidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtd_habitantes() {
        return qtd_habitantes;
    }

    public void setQtd_habitantes(String qtd_habitantes) {
        this.qtd_habitantes = qtd_habitantes;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
    
    
    
}
