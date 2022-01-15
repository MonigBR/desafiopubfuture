package com.michelkonig.desafiopubf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.michelkonig.desafiopubf.enumeration.TipoReceita;
import com.michelkonig.desafiopubf.model.Receitas;
import com.michelkonig.desafiopubf.repository.ReceitasRepository;

/** Classe ReceitasController, onde serão contidos os parâmetros e métodos para o mesmo.
 * 
 * @author Michel Konig
 *
 */
@RestController
public class ReceitasController {
	
/** Parâmetros que compõem a Classe ContaController:
 * 	
 * @param repository ReceitasRepository - Repositório de receitas.
 * 
 */
	public ReceitasController(ReceitasRepository repository) {
		this.repository = repository;
	}

	ReceitasRepository repository;

		
/**
 * 	
 * @return
 * 
 */
	@GetMapping("/receitas")
	public List<Receitas> getAllReceitas(){
		return (List<Receitas>) repository.findAll();
	}
	
/**
 * 	
 * @param id
 * @return
 * 
 */
	@GetMapping("/receitas/{id}")
	public Receitas getReceitasById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/receitas/{id}")
	public void deleteReceitas(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	@GetMapping("/receitas/buscarPorTipoReceita")
	public List<Receitas> findReceitaByTipoReceita(@RequestParam("tipoReceita") TipoReceita tipoReceita){
		return this.repository.findByTipoReceita(tipoReceita);
		
	}
	
	@GetMapping("/receitas/buscarPorPeriodoData")
	public List<Receitas> findReceitaByPeriodoData(@RequestParam("dataRecebimento") Date dataRecebimento){
		return this.repository.findByPeriodoData(dataRecebimento);
	}
	
}
