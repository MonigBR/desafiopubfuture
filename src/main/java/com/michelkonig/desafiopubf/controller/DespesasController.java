package com.michelkonig.desafiopubf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.michelkonig.desafiopubf.model.Despesas;
import com.michelkonig.desafiopubf.repository.DespesasRepository;

/** Classe DespesasController, onde serão contidos os parâmetros e métodos para o mesmo.
 * 
 * @author Michel Konig
 *
 */
@RestController
public class DespesasController {
	
/** Parâmetros que compõem a Classe ContaController:
 * 	
 * @param repository DespesasRepository - Repositório de despesas.
 * 
 */
	public DespesasController(DespesasRepository repository) {
		this.repository = repository;
	}

	DespesasRepository repository;
	
/**
 * 	
 * @return
 * 
 */
	@GetMapping("/despesas")
	public List<Despesas> getAllDespesas(){
		return (List<Despesas>) repository.findAll();
	}
	
/**
 * 	
 * @param id
 * @return
 * 
 */
	@GetMapping("/despesas/{id}")
	public Despesas getDespesasById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/despesas/{id}")
	public void deleteDespesas(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	}
	


