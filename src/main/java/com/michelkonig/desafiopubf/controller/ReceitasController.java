package com.michelkonig.desafiopubf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.michelkonig.desafiopubf.enumeration.TipoReceita;
import com.michelkonig.desafiopubf.model.Conta;
import com.michelkonig.desafiopubf.model.Receitas;
import com.michelkonig.desafiopubf.repository.ContaRepository;
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
	public ReceitasController(ReceitasRepository repository, ContaRepository contaRepository) {
		this.repository = repository;
		this.contaRepository = contaRepository;
	}

	ReceitasRepository repository;
	ContaRepository contaRepository;

		
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
	
	@PutMapping("/receitas/{id}")
	public Receitas updaterReceitas(@PathVariable Long id, @RequestBody Receitas receitasDetalhes) {
		Receitas receitas = repository.findById(id).get(); 
			
		receitas.setDataRecebimento(receitasDetalhes.getDataRecebimento());
		receitas.setDataRecebimentoEsperado(receitasDetalhes.getDataRecebimentoEsperado());
		receitas.setValorReceita(receitasDetalhes.getValorReceita());
		receitas.setDescricao(receitasDetalhes.getDescricao());
		receitas.setTipoReceita(receitasDetalhes.getTipoReceita());	

		return repository.save(receitas);
	}
	
	@GetMapping("/receitas/buscarPorTipoReceita")
	public List<Receitas> findReceitaByTipoReceita(@RequestParam("tipoReceita") TipoReceita tipoReceita){
		return this.repository.findByTipoReceita(tipoReceita);
	}
	
	@GetMapping("/receitas/buscarDataRecebimentoPorPeriodo")
	public List<Receitas> findReceitaByPeriodoDataRecebimento(
			@RequestParam("dataInicial") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataFinal) {
		return this.repository.findByDataRecebimentoBetween(dataInicial, dataFinal);
	}
	
	@GetMapping("/receitas/buscarDataRecebimentoEsperadoPorPeriodo")
	public List<Receitas> findReceitaByPeriodoDataRecebimentoEsperado(
			@RequestParam("dataInicial") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataFinal) {
		return this.repository.findByDataRecebimentoEsperadoBetween(dataInicial, dataFinal);
	}

	@GetMapping("/receitas/buscarTotalReceitasDeUmaConta")
	public Double findByTotalReceitasDeUmaConta(@RequestParam("id_conta") Long id_Conta) {	
		Conta conta = this.contaRepository.findById(id_Conta).get();
		
		List<Receitas> listaReceitas = this.repository.findByConta(conta);
		
		Double totalReceitas = 0.0;
		
		for (Receitas receitas : listaReceitas) {
			totalReceitas = totalReceitas + receitas.getValorReceita();
		}
		
		return totalReceitas;
	}
	
	
			
}
