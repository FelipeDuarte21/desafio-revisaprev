/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.services.impl;

import java.time.ZoneId;
import java.util.Date;

import br.com.revisa.teste.services.ServiceExtracaoCartaConcessao;
import br.com.revisa.teste.util.pdf.CartaConcessao;
import br.com.revisa.teste.util.pdf.PDFUtil;

/**
 *
 * @author renan
 */
public class ServiceExtracaoCartaConcessaoImpl implements ServiceExtracaoCartaConcessao {

    public ServiceExtracaoCartaConcessaoImpl() {
    }

    @Override
    public ResultadoExtracaoCartaConcessao onExtrairCartaConcessao(byte[] pdf) throws ServiceExtracaoCartaConcessaoException {
    	
    	try {
    	
	    	PDFUtil pdfUtil = new PDFUtil();
	    	CartaConcessao carta = pdfUtil.extrairInformacoes(pdf);
	    	
	    	if(carta.getNome() == null || carta.getData() == null || carta.getContribuicoes().isEmpty())
	    		throw new ServiceExtracaoCartaConcessaoException("Erro! não foi possivel obter dados do pdf!");
	      
	        ResultadoExtracaoCartaConcessao retorno = new ResultadoExtracaoCartaConcessao();
	        retorno.setDataConcessao(Date.from(carta.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));
	        retorno.setNome(carta.getNome());
	        retorno.setMediaSalarios(carta.obterMediaSalarial());
	        retorno.setQuantidadeSalarios(carta.quantidadeDeContribuicoes());
	
	        return retorno;
	        
    	}catch (RuntimeException ex) {
			throw new ServiceExtracaoCartaConcessaoException(ex.getMessage());
			
		}

    }

}
