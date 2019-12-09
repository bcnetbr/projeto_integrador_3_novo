package com.github.braully.dws;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class VotacaoMB {

    @RequestMapping(value = "/votar")
    public void votar(Integer id) {
        Usuario usuario = null;
        NecessidadePorBairro necessidadePorBairro = null;
        ControleVoto voto = new ControleVoto();
        voto.setUsuario(usuario);
        voto.setNecessidade(necessidadePorBairro);
        //salvar no banco
    }
}