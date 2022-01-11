package com.michelkonig.desafiopubf.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Conta")
public class Conta {
	
	public Conta(Long id, Integer saldo, TipoConta tipoConta, String instituicaoFinanceira, List<Receitas> receitas,
			List<Despesas> despesas) {

		this.id = id;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
		this.receitas = receitas;
		this.despesas = despesas;
	}

	public Conta() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer saldo;
	private TipoConta tipoConta;
	private String instituicaoFinanceira;
	
	@JsonManagedReference
	@OneToMany(mappedBy= "conta", cascade= CascadeType.ALL)
	private List<Receitas> receitas;
	
	@JsonManagedReference
	@OneToMany(mappedBy= "conta", cascade= CascadeType.ALL)
	private List<Despesas> despesas;
	
	public Integer getSaldo() {
		return saldo;
	}
	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
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
