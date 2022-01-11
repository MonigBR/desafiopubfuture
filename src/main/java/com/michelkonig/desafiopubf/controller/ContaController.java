package com.michelkonig.desafiopubf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.michelkonig.desafiopubf.model.Conta;
import com.michelkonig.desafiopubf.model.Despesas;
import com.michelkonig.desafiopubf.model.Receitas;
import com.michelkonig.desafiopubf.repository.ContaRepository;
import com.michelkonig.desafiopubf.repository.DespesasRepository;
import com.michelkonig.desafiopubf.repository.ReceitasRepository;

@RestController
public class ContaController {
	
	public ContaController(ContaRepository repository, DespesasRepository despesasRepository, ReceitasRepository receitasRepository) {

		this.repository = repository;
		this.despesasRepository = despesasRepository;
		this.receitasRepository = receitasRepository;
	}

	ContaRepository repository;
	DespesasRepository despesasRepository;
	ReceitasRepository receitasRepository;

	
	@GetMapping("/conta")
	public List<Conta> getAllConta(){
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
	
	@PostMapping("/conta/{id}/despesas")
	public Despesas addDespesas(@PathVariable Long id, @RequestBody Despesas despesas) {
		Conta conta = repository.findById(id).get();
		despesas.setConta(conta);
		return despesasRepository.save(despesas);
	}
	
	@PostMapping("/conta/{id}/receitas")
	public Receitas addReceitas(@PathVariable Long id, @RequestBody Receitas receitas) {
		Conta conta = repository.findById(id).get();
		receitas.setConta(conta);
		return receitasRepository.save(receitas);
	}
}
