package com.michelkonig.desafiopubf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michelkonig.desafiopubf.model.Conta;

/** Classe ContaRepository.
 * 
 * @author Michel Konig
 *
 */
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
