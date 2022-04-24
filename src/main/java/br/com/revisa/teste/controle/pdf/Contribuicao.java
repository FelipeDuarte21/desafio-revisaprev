package br.com.revisa.teste.controle.pdf;

import java.math.BigDecimal;
import java.time.YearMonth;

public class Contribuicao {
	
	private String sequencia;
	private	YearMonth data;
	private BigDecimal salario;
	private Float indice;
	private BigDecimal salarioCorrigido;
	private String observacao;
	
	public Contribuicao() {
		
	}

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

	public YearMonth getData() {
		return data;
	}

	public void setData(YearMonth data) {
		this.data = data;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Float getIndice() {
		return indice;
	}

	public void setIndice(Float indice) {
		this.indice = indice;
	}

	public BigDecimal getSalarioCorrigido() {
		return salarioCorrigido;
	}

	public void setSalarioCorrigido(BigDecimal salarioCorrigido) {
		this.salarioCorrigido = salarioCorrigido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Contribuicao [sequencia=" + sequencia + ", data=" + data + ", salario=" + salario + ", indice=" + indice
				+ ", salarioCorrigido=" + salarioCorrigido + ", observacao=" + observacao + "]";
	}
	
}
