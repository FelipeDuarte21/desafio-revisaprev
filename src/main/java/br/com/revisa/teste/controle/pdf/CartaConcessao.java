package br.com.revisa.teste.controle.pdf;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartaConcessao {
	
	private String nome;
	private LocalDate data; 
	private List<Contribuicao> contribuicoes = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public List<Contribuicao> getContribuicoes() {
		return contribuicoes;
	}
	
	public void setContribuicoes(List<Contribuicao> contribuicoes) {
		this.contribuicoes = contribuicoes;
	}
	
	public void addContribuicao(Contribuicao contribuicao) {
		this.contribuicoes.add(contribuicao);
	}

	@Override
	public String toString() {
		return "CartaConcessao [nome=" + nome + ", data=" + data + ", contribuicoes=" + contribuicoes + "]";
	}
	
	public int quantidadeDeContribuicoes() {
		return this.contribuicoes.size();
	}
	
	public BigDecimal obterMediaSalarial() {
		
		BigDecimal qtd = new BigDecimal(quantidadeDeContribuicoes());
		
		BigDecimal soma = new BigDecimal("0.00");
		
		for(Contribuicao c : this.contribuicoes) {
			soma = soma.add(c.getSalarioCorrigido());
		}
		
		return soma.divide(qtd,2,RoundingMode.HALF_EVEN);
		
	} 
	
	
}
