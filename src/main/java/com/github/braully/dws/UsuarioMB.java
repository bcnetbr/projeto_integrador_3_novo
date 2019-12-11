/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author bcnet
 */
@Scope("view")
@Component
public class UsuarioMB {
    
    @Autowired
    UsuarioDAO usuarioDao;
    
    Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void salvarUsuario(){
        
        usuario.setAtivado(true);
        usuarioDao.save(usuario);
        FacesMessage faceMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro de usuário","Cadastrado com sucesso");
        FacesContext . getCurrentInstance(). addMessage( "msgValidador" , faceMsg);
        usuario = new Usuario();
    }
    
}
