package com.michelkonig.desafiopubf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Despesas {
	
	public Despesas(Integer valor, String dataPagamento, String dataPagamentoEsperado, Conta conta,
			TipoDespesa tipoDespesa) {
		super();
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.conta = conta;
		this.tipoDespesa = tipoDespesa;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer valor;
	private String dataPagamento;
	private String dataPagamentoEsperado;
	
	@ManyToOne
	@JoinColumn(name="ID_CONTA")
	private Conta conta;
	
	private TipoDespesa tipoDespesa;

	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public String getDataPagamento() {
		return dataPagamento;
	}	
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public String getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}	
	public void setDataPagamentoEsperado(String dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public Conta conta() {
		return conta;
	}	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}	
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
}