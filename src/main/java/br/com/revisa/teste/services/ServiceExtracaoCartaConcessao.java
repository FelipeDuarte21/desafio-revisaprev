/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.services;

import br.com.revisa.teste.services.impl.ResultadoExtracaoCartaConcessao;
import java.io.Serializable;

/**
 * @author renan
 * Aqui é uma interface que demonstra como deve ser a implementação da extração da carta de concessão. 
 * Recebe o arquivo em byte e retorna o objeto ResultadoExtracaoCartaConcessao que contém as informações do resultado
 */
public interface ServiceExtracaoCartaConcessao extends Serializable {

    public ResultadoExtracaoCartaConcessao onExtrairCartaConcessao(byte[] pdf) throws ServiceExtracaoCartaConcessaoException;

    public class ServiceExtracaoCartaConcessaoException extends Exception {

        public ServiceExtracaoCartaConcessaoException(String message) {
            super(message);
        }

    }

}
