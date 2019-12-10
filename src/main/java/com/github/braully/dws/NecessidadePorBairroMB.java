/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aluno
 */
@Scope("view")
@Component
public class NecessidadePorBairroMB {

    @Autowired
    NecessidadePorBairroDAO necessidadePorBairroDao;

    @Autowired
    PaisDAO paisDao;

    @Autowired
    EstadoDAO estadoDao;

    @Autowired
    CidadeDAO cidadeDao;

    @Autowired
    BairroDAO bairroDao;

    @Autowired
    NecessidadesDAO necessidadeDao;

    @Autowired
    UsuarioDAO usuarioDao;

    @Autowired
    DataSource dataSource;

    NecessidadePorBairro necessidadePorBairro = new NecessidadePorBairro();

    public NecessidadePorBairro getNecessidadePorBairro() {
        return necessidadePorBairro;
    }

    public void salvarNecessidadePorBairro() {

        necessidadePorBairroDao.save(necessidadePorBairro);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Necessidade salva com sucesso"));
        necessidadePorBairro = new NecessidadePorBairro();

    }

    List<String[]> resultadoResumoVotacao = new ArrayList<>();

    public List<String[]> getResultadoResumoVotacao() {
        return resultadoResumoVotacao;
    }

    public void buscarResumoVotos() {
        try {
            resultadoResumoVotacao.clear();
//            Statement statement = dataSource.getConnection().createStatement();
//            statement.execute("SELECT count(id) as num_votos, id_bairro, id_necessidade, id_usuario, "
//                    + "id_pais, id_estado, id_cidade, observacao\n"
//                    + "FROM public.necessidade_por_bairro GROUP BY id_pais, id_estado, id_necessidade");

            resultadoResumoVotacao.add(new String[]{"Farmacia", "100"});
            resultadoResumoVotacao.add(new String[]{"Banco", "120"});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    List<Usuario> listaUsuario;

    public List<Usuario> getListaUsuario() {
        if (listaUsuario == null) {
            listaUsuario = new ArrayList<>();
            for (Usuario u : usuarioDao.findAll()) {
                listaUsuario.add(u);
            }

        }
        return listaUsuario;
    }

    List<Pais> listaPais;

    public List<Pais> getListaPais() {
        if (listaPais == null) {
            listaPais = new ArrayList<>();
            for (Pais p : paisDao.findAll()) {
                listaPais.add(p);
            }

        }
        return listaPais;
    }

    List<Estado> listaEstado;

    public List<Estado> getListaEstado() {
        if (listaEstado == null) {
            listaEstado = new ArrayList<>();
            for (Estado e : estadoDao.findAll()) {
                listaEstado.add(e);
            }

        }
        return listaEstado;
    }

    List<Cidade> listaCidade;

    public List<Cidade> getListaCidade() {
        if (listaCidade == null) {
            listaCidade = new ArrayList<>();
            for (Cidade c : cidadeDao.findAll()) {
                listaCidade.add(c);
            }

        }
        return listaCidade;
    }

    List<Bairro> listaBairro;

    public List<Bairro> getListaBairro() {
        if (listaBairro == null) {
            listaBairro = new ArrayList<>();
            for (Bairro b : bairroDao.findAll()) {
                listaBairro.add(b);
            }

        }
        return listaBairro;
    }

    List<Necessidades> listaNecessidade;

    public List<Necessidades> getListaNecessidades() {
        if (listaNecessidade == null) {
            listaNecessidade = new ArrayList<>();
            for (Necessidades n : necessidadeDao.findAll()) {
                listaNecessidade.add(n);
            }

        }
        return listaNecessidade;
    }
    List<NecessidadePorBairro> listaNecessidadePorBairros;

    public List<NecessidadePorBairro> getListaNecessidadePorBairros() {
        if (listaNecessidadePorBairros == null) {
            listaNecessidadePorBairros = new ArrayList<>();
            for (NecessidadePorBairro n : necessidadePorBairroDao.findAll()) {
                listaNecessidadePorBairros.add(n);
            }
        }
        return listaNecessidadePorBairros;
    }

    String paisSelecionado;

    public String getPaisSelecionado() {
        return paisSelecionado;
    }

    public void setPaisSelecionado(String paisSelecionado) {
        this.paisSelecionado = paisSelecionado;
    }

    String estadoSelecionado;

    public String getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(String estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }

    String cidadeSelecionada;

    public String getCidadeSelecionada() {
        return cidadeSelecionada;
    }

    public void setCidadeSelecionada(String cidadeSelecionada) {
        this.cidadeSelecionada = cidadeSelecionada;
    }

    String bairroSelecionado;

    public String getBairroSelecionado() {
        return bairroSelecionado;
    }

    public void setBairroSelecionado(String BairroSelecionado) {
        this.bairroSelecionado = bairroSelecionado;
    }

    String necessidadeSelecionada;

    public String getNecessidadeSelecionada() {
        return necessidadeSelecionada;
    }

    public void setNecessidadeSelecionada(String NecessidadeSelecionada) {
        this.necessidadeSelecionada = necessidadeSelecionada;
    }

}
