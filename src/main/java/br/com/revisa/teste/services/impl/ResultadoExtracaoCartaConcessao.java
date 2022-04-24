/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.services.impl;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author renan
 */
public class ResultadoExtracaoCartaConcessao {

    private String nome;

    private Date dataConcessao;

    private int quantidadeSalarios;

    private BigDecimal mediaSalarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataConcessao() {
        return dataConcessao;
    }

    public void setDataConcessao(Date dataConcessao) {
        this.dataConcessao = dataConcessao;
    }

    public int getQuantidadeSalarios() {
        return quantidadeSalarios;
    }

    public void setQuantidadeSalarios(int quantidadeSalarios) {
        this.quantidadeSalarios = quantidadeSalarios;
    }

    public BigDecimal getMediaSalarios() {
        return mediaSalarios;
    }

    public void setMediaSalarios(BigDecimal mediaSalarios) {
        this.mediaSalarios = mediaSalarios;
    }

}
