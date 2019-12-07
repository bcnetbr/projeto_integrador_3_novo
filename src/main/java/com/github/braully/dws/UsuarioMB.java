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
        
        usuarioDao.save(usuario);
        FacesContext . getCurrentInstance(). addMessage( null , new FacesMessage ("Usuárior salvo com sucesso"));
        usuario = new Usuario();
    }
    
}
