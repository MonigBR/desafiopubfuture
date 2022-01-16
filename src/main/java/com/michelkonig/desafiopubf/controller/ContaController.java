package com.michelkonig.desafiopubf.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michelkonig.desafiopubf.model.Conta;
import com.michelkonig.desafiopubf.model.Despesas;
import com.michelkonig.desafiopubf.model.Receitas;
import com.michelkonig.desafiopubf.repository.ContaRepository;
import com.michelkonig.desafiopubf.repository.DespesasRepository;
import com.michelkonig.desafiopubf.repository.ReceitasRepository;

/** Classe Controller da entidade Conta.
 * 
 * @author Michel Konig
 *
 */
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
	public void deleteConta(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/conta/{id}")
	public Conta updateConta(@PathVariable Long id, @RequestBody Conta contaDetalhes) {
		Conta conta = repository.findById(id).get(); 
		
		conta.setSaldo(contaDetalhes.getSaldo());
		conta.setInstituicaoFinanceira(contaDetalhes.getInstituicaoFinanceira());
		conta.setTipoConta(contaDetalhes.getTipoConta());
		conta.setValorDespesas(contaDetalhes.getValorDespesas());
		conta.setValorReceitas(contaDetalhes.getValorReceitas());
		
		return repository.save(conta);
	}
	
	/** Método para adição de uma despesa em uma conta
	 * 
	 * @param id - id da conta
	 * @param despesas - objeto Despesas
	 * @return despesa adicionada
	 */
	@PostMapping("/conta/{id}/despesas")
	public Despesas addDespesas(@PathVariable Long id, @RequestBody Despesas despesas) {
		Conta conta = repository.findById(id).get();
		despesas.setConta(conta);
		return despesasRepository.save(despesas);
	}
	
	/** Método para adição de uma receita em uma conta
	 * 
	 * @param id - id da conta
	 * @param receitas - objeto Receitas
	 * @return receita adicionada
	 */
	@PostMapping("/conta/{id}/receitas")
	public Receitas addReceitas(@PathVariable Long id, @RequestBody Receitas receitas) {
		Conta conta = repository.findById(id).get();
		receitas.setConta(conta);
		return receitasRepository.save(receitas);
	}
	
	/** Método para a buscar o saldo total de uma conta
	 * 
	 * @param id_Conta - id da conta
	 * @return saldo total de uma conta
	 */
	@GetMapping("/conta/buscarTotalSaldoDeUmaConta")
	public Double findByTotalSaldoDeUmaConta(@RequestParam("id_conta") Long id_Conta) {	
		Conta conta = this.repository.findById(id_Conta).get();
		
		List<Receitas> listaReceitas = this.receitasRepository.findByConta(conta);
		List<Despesas> listaDespesas = this.despesasRepository.findByConta(conta);
		
		Double totalDespesas = 0.0;
		Double totalReceitas = 0.0;
		
		for (Receitas receitas : listaReceitas) {
			totalReceitas = totalReceitas + receitas.getValorReceita();
		}
		
		for (Despesas despesas : listaDespesas) {
			totalDespesas= totalDespesas + despesas.getValorDespesa();
		}
		
		Double totalSaldo = conta.getSaldo() + totalReceitas - totalDespesas;
		
		return totalSaldo;
		
		}
	
}
