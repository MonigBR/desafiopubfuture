package com.michelkonig.desafiopubf.model;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceitasController {
	
	public ReceitasController(ReceitasRepository repository) {
		super();
		this.repository = repository;
	}

	ReceitasRepository repository;
	
	@GetMapping("receitas")
	public List<Receitas> getAllReceitas(){
		return (List<Receitas>) repository.findAll();
	}
	
	@GetMapping("/receitas/{id}")
	public Receitas getReceitasById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/receitas")
	public Receitas saveReceitas(@RequestBody Receitas receitas) {
		return repository.save(receitas);
	}
	
		@DeleteMapping("/receitas/{id}")
	public void deleteReceitas(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	

}