package com.example.workshop.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.data.ParticipaDeRepository;
import com.example.workshop.data.ProjetoRepository;
import com.example.workshop.form.ParticipaDeFormEntrada;
import com.example.workshop.form.ParticipaDeFormSaida;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.ParticipaDe;
import com.example.workshop.model.Projeto;

@RestController
@RequestMapping("/participa-de")
public class ParticipaDeController {
	
	@Autowired
	private ParticipaDeRepository participaDeRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private ProjetoRepository projetorepository;
	
	@GetMapping
	public List<ParticipaDeFormSaida> listar(){
		List<ParticipaDe> participaDe = this.participaDeRepository.findAll();
		
		return ParticipaDeFormSaida.converter(participaDe);
	}
	
	@PostMapping
	@Transactional
	public ParticipaDeFormSaida salvar(@RequestBody ParticipaDeFormEntrada formEntrada) {
		ParticipaDe participaDe = formEntrada.criaParticipaDe(this.funcionarioRepository, this.projetorepository);	
		this.participaDeRepository.save(participaDe);
		
		return ParticipaDeFormSaida.criaSaida(participaDe);
	}
	
	@GetMapping("/{id}")
	public ParticipaDeFormSaida buscar(@PathVariable Long id) {
		ParticipaDe participaDe = this.participaDeRepository.findById(id).get();
		
		return ParticipaDeFormSaida.criaSaida(participaDe);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ParticipaDeFormSaida atualizar(@PathVariable Long id, @RequestBody ParticipaDeFormEntrada formEntrada) {
		ParticipaDe participaDe = this.participaDeRepository.findById(id).get();
		Funcionario funcionario = this.funcionarioRepository.findBycpf(formEntrada.getCpfFuncioanario());
		Projeto projeto = this.projetorepository.findBynome(formEntrada.getNomeProjeto());
		
		participaDe.setFuncionario(funcionario);
		participaDe.setProjeto(projeto);
		
		return ParticipaDeFormSaida.criaSaida(participaDe);
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable long id) {
		this.participaDeRepository.deleteById(id);
	}
	
	
	
	

}
