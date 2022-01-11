package com.michelkonig.desafiopubf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.michelkonig.desafiopubf.model.Receitas;
import com.michelkonig.desafiopubf.repository.ReceitasRepository;

@RestController
public class ReceitasController {
	
	public ReceitasController(ReceitasRepository repository) {
		this.repository = repository;
	}

	ReceitasRepository repository;
	
	@GetMapping("/receitas")
	public List<Receitas> getAllReceitas(){
		return (List<Receitas>) repository.findAll();
	}
	
	@GetMapping("/receitas/{id}")
	public Receitas getReceitasById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@DeleteMapping("/receitas/{id}")
	public void deleteReceitas(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	

}
