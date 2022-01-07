package com.michelkonig.desafiopubf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Conta")
public class ContaModel {
	
	public ContaModel(Integer saldo, String instituicaoFinanceira) {
		this.saldo = saldo;
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer saldo;
	private String instituicaoFinanceira;
	
	public Integer getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

	


}
