package com.michelkonig.desafiopubf.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michelkonig.desafiopubf.model.Despesas;

@Repository
@Transactional

/** Classe DespesasRepository.
 * 
 * @author Michel Konig
 *
 */
public interface DespesasRepository extends JpaRepository<Despesas, Long>{
	


}
