package com.michelkonig.desafiopubf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Receitas {
	
	public Receitas(Integer valor, String dataRecebimento, String dataRecebimentoEsperado, String descricao,
			String conta, String tipoReceita) {
		super();
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.conta = conta;
		this.tipoReceita = tipoReceita;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer valor;
	private String dataRecebimento;
	private String dataRecebimentoEsperado;
	private String descricao;
	private String conta;
	private String tipoReceita;
	
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public String getDataRecebimento() {
		return dataRecebimento;
	}	
	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
	
	public String getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}	
	public void setDataRecebimentoEsperado(String dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}
	
	public String getDescricao() {
		return descricao;
	}	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getConta() {
		return conta;
	}	
	public void setConta(String conta) {
		this.conta = conta;
	}
	
	public String getTipoReceita() {
		return tipoReceita;
	}	
	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
}