package com.michelkonig.desafiopubf.model;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {
	
	public ContaController(ContaRepository repository) {
		super();
		this.repository = repository;
	}

	ContaRepository repository;
	
	@GetMapping("/contamodel")
	public List<Conta> getAllContaModel(){
		return (List<Conta>) repository.findAll();
	}
	
	@GetMapping("/conta/{id}")
	public Conta getContaById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/conta")
	public Conta saveConta(@RequestBody Conta conta) {
		return repository.save(conta);
	}
	
		@DeleteMapping("/conta/{id}")
	public void deleteConta(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	

}
