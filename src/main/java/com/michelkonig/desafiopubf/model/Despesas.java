package com.michelkonig.desafiopubf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.michelkonig.desafiopubf.enumeration.TipoDespesa;

/** Classe Despesas, onde serão contidos os parâmetros e métodos para o mesmo.
 * 
 * @author Michel Konig
 *
 */
@Entity

public class Despesas {

/**	Parâmetros que compõem a Classe Despesas:
 * 	
 * @param valorDespesa double - Valor da despesa;
 * @param dataPagamento date - Data de pagamento realizado referente a despesa;
 * @param dataPagamentoEsperado date - Data limite de pagamento esperado referente a despesa; 
 * @param conta Conta - Conta na qual a despesa está vinculada;
 * @param tipoDespesa TipoDespesa - Tipo de despesa paga.
 * 
 */
	public Despesas(Double valorDespesa, Date dataPagamento, Date dataPagamentoEsperado, Conta conta,
			TipoDespesa tipoDespesa) {
		this.valorDespesa = valorDespesa;
		this.dataPagamento = dataPagamento;
		this.dataPagamentoEsperado = dataPagamentoEsperado;
		this.conta = conta;
		this.tipoDespesa = tipoDespesa;
	}
	
	public Despesas() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valorDespesa;
	private Date dataPagamento;
	private Date dataPagamentoEsperado;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA", referencedColumnName= "id") 
	private Conta conta;
	
	private TipoDespesa tipoDespesa;

/** Método para retorno do valorDespesa da despesa.
 * 
 * @return Double - O valorDespesa referente a despesa.
 * 
 */
	public Double getValorDespesa() {
		return valorDespesa;
	}
	public void setValorDespesa(Double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

/** Método para retorno da data de pagamento da despesa.
 * 
 * @return date - A data em que foi feito o pagamente da referida despesa.
 * 
 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Europe/Ireland")
	public Date getDataPagamento() {
		return dataPagamento;
	}	
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

/** Método para retorno da data de pagamento esperado da despesa.
 * 
 * @return date - A data de pagamente esperada para a referida despesa (data de vencimento).
 * 
 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Europe/Ireland")
	public Date getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}	
	public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

/** Método para retorno da conta.
 * 
 * @return Conta - Conta na qual a despesa está vinculada.
 * 
 */
	public Conta getConta() {
		return conta;
	}	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
/** Método para retorno do tipo de despesa.
 * 
 * @return TipoDespesa - Tipo da despesa realizada (alimentação, educação, lazer, moradia, roupa, saúde, transporte ou outros).
 * 
 */
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}	
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Long getId() {
		return id;
	}
	
}