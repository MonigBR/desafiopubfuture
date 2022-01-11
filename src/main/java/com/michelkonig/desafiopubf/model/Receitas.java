package com.michelkonig.desafiopubf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Receitas {
	
	public Receitas(Integer valor, String dataRecebimento, String dataRecebimentoEsperado, String descricao,
			Conta conta, TipoReceita tipoReceita) {
		this.valor = valor;
		this.dataRecebimento = dataRecebimento;
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
		this.descricao = descricao;
		this.conta = conta;
		this.tipoReceita = tipoReceita;
	}
	
	public Receitas() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer valor;
	private String dataRecebimento;
	private String dataRecebimentoEsperado;
	private String descricao;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CONTA", referencedColumnName= "id" ) 
	private Conta conta;
	
	private TipoReceita tipoReceita;
	
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
	
	public Conta getConta() {
		return conta;
	}	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}	
	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
}