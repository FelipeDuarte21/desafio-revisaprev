/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.controle;

import br.com.revisa.teste.services.ServiceExtracaoCartaConcessao;
import br.com.revisa.teste.services.impl.ResultadoExtracaoCartaConcessao;
import br.com.revisa.teste.services.impl.ServiceExtracaoCartaConcessaoImpl;
import br.com.revisa.teste.util.FacesMensagensUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 * CLASSE QUE COMUNICA COM A TELA INICIAL DEPOIS DE LOGADO
 *
 * @author Renan
 */
@Named
@ViewScoped // lembrando que esse scopo só vale enquanto a tela estiver aberta, se atualizar ela é recriada perdendo as informações dela
public class InicioMB implements Serializable {

    private ServiceExtracaoCartaConcessao serviceExtracaoCartaConcessao;

    private ResultadoExtracaoCartaConcessao resultado; // objeto responsável por mostrar o resultado

    @PostConstruct
    private void init() {
        // A implementação está vazia, é preciso implementar ela
        serviceExtracaoCartaConcessao = new ServiceExtracaoCartaConcessaoImpl();
    }

    //chamado logo após escolher o arquivo
    public void onCarregarArquivoConcessao(FileUploadEvent uploadEvent) {
        try {
            System.out.println("Enviando Concessão");
            UploadedFile arquivoUpload = uploadEvent.getFile();
            byte[] conteudoArquivo = arquivoUpload.getContent();
            resultado = serviceExtracaoCartaConcessao.onExtrairCartaConcessao(conteudoArquivo);
            FacesMensagensUtil.adcionarMensagem("Arquivo de " + resultado.getNome() + " carregado com sucesso!");
        } catch (ServiceExtracaoCartaConcessao.ServiceExtracaoCartaConcessaoException ex) {
            FacesMensagensUtil.adcionarMensagemErro("Ocorreu um erro ao extrair o documento: " + ex.getMessage());
        }
    }

    //sempre precisamos do get para conseguir acessar do xhtml
    public ResultadoExtracaoCartaConcessao getResultado() {
        return resultado;
    }

}
