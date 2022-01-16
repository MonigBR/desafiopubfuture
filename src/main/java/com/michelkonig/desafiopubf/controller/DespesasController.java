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

import com.michelkonig.desafiopubf.enumeration.TipoDespesa;
import com.michelkonig.desafiopubf.model.Conta;
import com.michelkonig.desafiopubf.model.Despesas;
import com.michelkonig.desafiopubf.repository.ContaRepository;
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
	public DespesasController(DespesasRepository repository, ContaRepository contaRepository) {
		this.repository = repository;
		this.contaRepository = contaRepository;
	}

	DespesasRepository repository;
	ContaRepository contaRepository;
	
	
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
	
	@PutMapping("/despesas/{id}")
	public Despesas updateDespesas(@PathVariable Long id, @RequestBody Despesas despesasDetalhes) {
		Despesas despesas = repository.findById(id).get(); 
			
		despesas.setDataPagamento(despesasDetalhes.getDataPagamento());
		despesas.setDataPagamentoEsperado(despesasDetalhes.getDataPagamentoEsperado());
		despesas.setValorDespesa(despesasDetalhes.getValorDespesa());	
		despesas.setTipoDespesa(despesasDetalhes.getTipoDespesa());
		
		return repository.save(despesas);
	}
	
	@GetMapping("/despesas/buscarPorTipoDespesa")
	public List<Despesas> findDespesasByTipoDespesa(@RequestParam("tipoDespesa") TipoDespesa tipoDespesa){
		return this.repository.findByTipoDespesa(tipoDespesa);
	}
	
	@GetMapping("/despesas/buscarDataPagamentoPorPeriodo")
	public List<Despesas> findDespesasByPeriodoDataRecebimento(
			@RequestParam("dataInicial") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataFinal) {
		return this.repository.findByDataPagamentoBetween(dataInicial, dataFinal);
	}
	
	@GetMapping("/despesas/buscarDataPagamentoEsperadoPorPeriodo")
	public List<Despesas> findDespesasByPeriodoDataPagamentoEsperado(
			@RequestParam("dataInicial") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataInicial,
			@RequestParam("dataFinal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataFinal) {
		return this.repository.findByDataPagamentoEsperadoBetween(dataInicial, dataFinal);
	}
	
	@GetMapping("/despesas/buscarTotalDespesasDeUmaConta")
	public Double findByTotalDespesasDeUmaConta(@RequestParam("id_conta") Long id_Conta) {	
		Conta conta = this.contaRepository.findById(id_Conta).get();
		
		List<Despesas> listaDespesas = this.repository.findByConta(conta);
		
		Double totalDespesas = 0.0;
		
		for (Despesas despesas : listaDespesas) {
			totalDespesas= totalDespesas + despesas.getValorDespesa();
		}
		
		return totalDespesas;
	}
	
	}
	


