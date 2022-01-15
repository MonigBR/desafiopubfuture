package com.michelkonig.desafiopubf.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelkonig.desafiopubf.enumeration.TipoReceita;
import com.michelkonig.desafiopubf.model.Conta;
import com.michelkonig.desafiopubf.model.Receitas;

@Repository
@Transactional

/** Classe ReceitasRepository.
 * 
 * @author Michel Konig
 *
 */
public interface ReceitasRepository extends JpaRepository<Receitas, Long>{
	
	List<Receitas> findByTipoReceita(TipoReceita tipoReceita);
	
	List<Receitas> findByDataRecebimentoBetween(Date dataInicial, Date dataFinal);
	
	List<Receitas> findByDataRecebimentoEsperadoBetween(Date dataInicial, Date dataFinal);
	
	List<Receitas> findByConta(Conta conta);
	
}
