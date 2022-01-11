package com.michelkonig.desafiopubf.model;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/despesas")
public class DespesasController {
	
	public DespesasController(DespesasRepository repository) {
		this.repository = repository;
	}

	DespesasRepository repository;
	
	@GetMapping("/despesas")
	public List<Despesas> getAllDespesas(){
		return (List<Despesas>) repository.findAll();
	}
	
	@GetMapping("/despesas/{id}")
	public Despesas getDespesasById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/despesas/{id}")
	public void deleteDespesas(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	

}
