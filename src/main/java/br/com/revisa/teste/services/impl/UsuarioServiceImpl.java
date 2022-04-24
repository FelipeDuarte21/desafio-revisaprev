/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.services.impl;

import br.com.revisa.teste.entidades.Usuario;
import br.com.revisa.teste.services.ServiceUsuario;
import br.com.revisa.teste.entidades.TipoUsuario;

/**
 *
 * @author Renan
 */
public class UsuarioServiceImpl implements ServiceUsuario {

    @Override
    public Usuario onLogar(Usuario usuario) {
        //validando usuário e senha 
        if (usuario.getLogin().getLogin().equals("admin")
                && usuario.getLogin().getSenhaDescrip().equals("admin")) {
            return getUsuarioAdmin();
        }

        return null;
    }

    //apenas cria um usuário admin ficticio
    private Usuario getUsuarioAdmin() {
        Usuario usuarioAdmin = new Usuario();
        usuarioAdmin.setTipoUsuario(TipoUsuario.USUARIO_ADMINISTRADOR);
        usuarioAdmin.setNome("Administrador");
        usuarioAdmin.setId(Long.MIN_VALUE); // só para simular que veio do banco de dados
        return usuarioAdmin;
    }

}
