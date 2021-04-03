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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.data.ProjetoRepository;
import com.example.workshop.form.ProjetoFormEntrada;
import com.example.workshop.form.ProjetoFormSaida;
import com.example.workshop.model.Projeto;

@RestController
@RequestMapping("projetos")
public class ProjetoController {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping
	public List<ProjetoFormSaida> listar() {
		List<Projeto> progetos = this.projetoRepository.findAll();
		
		return ProjetoFormSaida.converter(progetos);
	}
	
	@PostMapping
	@Transactional
	public ProjetoFormSaida salvar(@RequestBody ProjetoFormEntrada formEntrada) {
		Projeto projeto = formEntrada.criaProjeto();
		this.projetoRepository.save(projeto);
		
		return ProjetoFormSaida.criarSaida(projeto); 
	}
	
	@GetMapping("/{id}")
	public ProjetoFormSaida Buscar(@PathVariable Long id) {
		Projeto projeto = this.projetoRepository.findById(id).get();
		return ProjetoFormSaida.criarSaida(projeto);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ProjetoFormSaida atualizar(@RequestBody ProjetoFormEntrada formEntrada, @PathVariable Long id) {
		Projeto projeto = this.projetoRepository.findById(id).get();
		projeto.setContratante(formEntrada.getContratante());
		projeto.setDataInicio(formEntrada.getDataInicio());
		projeto.setNome(formEntrada.getNome());
		
		return ProjetoFormSaida.criarSaida(projeto);
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Long id) {
		this.projetoRepository.deleteById(id);
	}
	
	
	
}
