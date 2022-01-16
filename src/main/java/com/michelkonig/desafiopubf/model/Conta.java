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
import com.michelkonig.desafiopubf.enumeration.TipoConta;

/** Classe Conta, onde serão contidos os parâmetros e métodos para o mesmo.
 * 
 * @author Michel Konig
 *
 */
@Entity
@Table(name = "Conta")
public class Conta {

/**	Parâmetros que compõem a Classe Conta:
 * 
 * @param id long - Identificação da conta;
 * @param saldo double - Valor do sando em conta;
 * @param tipoConta TipoConta - Tipo de conta que o usuário possui;
 * @param instituicaoFinanceira String - Instituição financeira a qual a conta do usuário está vinculada;
 * @param receitas List - Lista de receiras presentes na conta do usuário;
 * @param despesas List - Lista de despesas presentes na conta do usuário.
 * 
 */
	public Conta(Double saldo, TipoConta tipoConta, String instituicaoFinanceira, List<Receitas> valorReceitas,
			List<Despesas> valorDespesas) {
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instituicaoFinanceira = instituicaoFinanceira;
		this.valorReceitas = valorReceitas;
		this.valorDespesas = valorDespesas;
	}

	public Conta() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double saldo;
	private TipoConta tipoConta;
	private String instituicaoFinanceira;
	
	@JsonManagedReference
	@OneToMany(mappedBy= "conta", cascade= CascadeType.ALL)
	private List<Receitas> valorReceitas;
	
	@JsonManagedReference
	@OneToMany(mappedBy= "conta", cascade= CascadeType.ALL)
	private List<Despesas> valorDespesas;

/** Método para retorno de saldo da conta.
 * 
 * @return Double - O saldo em conta do usuário.
 * 
 */
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
/** Método para retorno de tipo de conta.
 * 	
 * @return TipoConta - O tipo da conta do usuário (carteira, corrente ou poupança).
 * 
 */
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

/** Método para retorno da instituição financeira.
 * 	
 * @return String - A instituição financeira ao qual pertence a conta do usuário.
 *  
 */
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}

/** Método para retorno da lista de receitas creditadas na conta.
* 	
* @return List - Uma lista com as receitas creditadas na conta do usuário.
*  
*/	
	public List<Receitas> getValorReceitas() {
		return valorReceitas;
	}
	public void setValorReceitas(List<Receitas> valorReceitas) {
		this.valorReceitas = valorReceitas;
	}

/** Método para retorno da lista de despesas debitadas da conta.
* 	
* @return List - Uma lista com as despesas debitadas da conta do usuário.
*  
*/	
	public List<Despesas> getValorDespesas() {
		return valorDespesas;
	}
	public void setValorDespesas(List<Despesas> valorDespesas) {
		this.valorDespesas = valorDespesas;
	}

	public Long getId() {
		return id;
	}

}
