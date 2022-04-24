/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.services;

import br.com.revisa.teste.entidades.Usuario;
import java.io.Serializable;

/**
 * ALÉM DAS FUNÇÕES DE BUSCA GENERICA, TAMBÉM CONTEM O MÉTODO PARA LOGAR
 *
 * @author Renan
 */
public interface ServiceUsuario extends Serializable {

    /**
     * CASO LOGUE COM SUCESSO É RETORNADO O USUÁRIO SENÃO RETORNA NULL
     *
     * @param usuario
     * @return
     */
    public Usuario onLogar(Usuario usuario);

}
