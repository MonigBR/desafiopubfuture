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
import com.michelkonig.desafiopubf.enumeration.TipoReceita;

/** Classe Receitas, onde serão contidos os parâmetros e métodos para o mesmo.
 * 
 * @author Michel Konig
 *
 */
@Entity
public class Receitas {
	
	/**	Parâmetros que compõem a Classe Receitas:
	 * 	
	 * @param valorReceita double - Valor da receita;
	 * @param dataRecebimento date - Data de recebimento realizado referente a receita;
	 * @param dataRecebimentoEsperado date - Data limite de recebimento esperado referente a receita; 
	 * @param descricao String - Descrição da receita recebida;
	 * @param conta Conta - Conta na qual a despesa está vinculada;
	 * @param tipoReceita TipoReceita - Tipo de despesa paga.
	 * 
	 */
	public Receitas(Double valorReceita, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao,
			Conta conta, TipoReceita tipoReceita) {
		this.valorReceita = valorReceita;
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
	private Double valorReceita;
	private Date dataRecebimento;
	private Date dataRecebimentoEsperado;
	private String descricao;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA", referencedColumnName= "id" ) 
	private Conta conta;
	
	private TipoReceita tipoReceita;
	
	/** Método para retorno do valorReceita da receita.
	 * 
	 * @return Double - O valorReceita referente a receita.
	 * 
	 */
	public Double getValorReceita() {
		return valorReceita;
	}
	public void setValorReceita(Double valorReceita) {
		this.valorReceita = valorReceita;
	}
	
	/** Método para retorno da data de recebimento da receita.
	 * 
	 * @return date - A data em que foi feito o recebimento da referida receita.
	 * 
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Europe/Ireland")
	public Date getDataRecebimento() {
		return dataRecebimento;
	}	
	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	/** Método para retorno da data de recebimento esperado da receita.
	 * 
	 * @return date - A data de recebimento esperada para a referida receita (data de vencimento).
	 * 
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Europe/Ireland")
	public Date getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}	
		public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}
		
	/** Método para retorno da descrição da receita.
	 * 	
	 * @return Sring - Descrição da receita recebida na conta do usuário.
	 * 
	 */
	public String getDescricao() {
		return descricao;
	}	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/** Método para retorno da conta.
	 * 
	 * @return Conta - Conta na qual a receita está vinculada.
	 * 
	 */
	public Conta getConta() {
		return conta;
	}	
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	/** Método para retorno do tipo de receita.
	 * 
	 * @return TipoDespesa - Tipo da receita realizada (salário,, presente, prêmio ou outros).
	 * 
	 */
	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}	
	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Long getId() {
		return id;
	}
	
}