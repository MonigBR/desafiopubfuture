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
	public List<ContaModel> getAllContaModel(){
		return (List<ContaModel>) repository.findAll();
	}
	
	@GetMapping("/contamodel/{id}")
	public ContaModel getContaModelById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/contamodel")
	public ContaModel saveContaModel(@RequestBody ContaModel contamodel) {
		return repository.save(contamodel);
	}
	
		@DeleteMapping("/contamodel/{id}")
	public void deleteContaModel(@PathVariable Long id){
		repository.deleteById(id);
	}
	
	

}
