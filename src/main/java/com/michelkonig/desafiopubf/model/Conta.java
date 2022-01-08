package com.michelkonig.desafiopubf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Conta")
public class Conta {
	
	public Conta(Integer saldo, TipoConta tipoconta, String instituicaoFinanceira, List<Receitas> receitas,
			List<Despesas> despesas) {
		super();
		this.saldo = saldo;
		this.tipoconta = tipoconta;
		this.instituicaoFinanceira = instituicaoFinanceira;
		this.receitas = receitas;
		this.despesas = despesas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer saldo;
	private TipoConta tipoconta;
	private String instituicaoFinanceira;
	
	@OneToMany
	@JoinColumn(name="ID_CONTA")
	private List<Receitas> receitas;
	
	@OneToMany
	@JoinColumn(name="ID_CONTA")
	private List<Despesas> despesas;
	
	public Integer getSaldo() {
		return saldo;
	}
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	public TipoConta getTipoconta() {
		return tipoconta;
	}
	public void setTipoconta(TipoConta tipoconta) {
		this.tipoconta = tipoconta;
	}
	
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	
	public List<Receitas> getReceitas() {
		return receitas;
	}
	public void setReceitas(List<Receitas> receitas) {
		this.receitas = receitas;
	}
	
	public List<Despesas> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<Despesas> despesas) {
		this.despesas = despesas;
	}

	


}
