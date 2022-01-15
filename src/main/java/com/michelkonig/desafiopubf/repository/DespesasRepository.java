package com.michelkonig.desafiopubf.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelkonig.desafiopubf.enumeration.TipoDespesa;
import com.michelkonig.desafiopubf.model.Conta;
import com.michelkonig.desafiopubf.model.Despesas;

@Repository
@Transactional

/** Classe DespesasRepository.
 * 
 * @author Michel Konig
 *
 */
public interface DespesasRepository extends JpaRepository<Despesas, Long>{
	
	List<Despesas> findByTipoDespesa(TipoDespesa tipoDespesa);
	
	List<Despesas> findByDataPagamentoBetween(Date dataInicial, Date dataFinal);
	
	List<Despesas> findByDataPagamentoEsperadoBetween(Date dataInicial, Date dataFinal);
	
	List<Despesas> findByConta(Conta conta);
	

}
