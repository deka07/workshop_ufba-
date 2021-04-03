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

import com.example.workshop.data.DepartamentoRepository;

import com.example.workshop.form.DepartamentoFormEntrada;
import com.example.workshop.form.DepartamentoFormSaida;
import com.example.workshop.model.Departamento;


@RestController
@RequestMapping("departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@GetMapping
	public List<DepartamentoFormSaida>listar() {
		List<Departamento> departamentos = this.departamentoRepository.findAll();
		
		return DepartamentoFormSaida.converter(departamentos);
	}
	
	@PostMapping
	@Transactional
	public DepartamentoFormSaida Salvar(@RequestBody DepartamentoFormEntrada formEntrada) {
		Departamento departamento = formEntrada.criaDepartamento();
		this.departamentoRepository.save(departamento);
		return DepartamentoFormSaida.criaSaida(departamento);
		
		
	}
	
	@GetMapping("/{id}")
	public DepartamentoFormSaida Buscar(@PathVariable Long id) {
		Departamento departamento = this.departamentoRepository.findById(id).get();
		
		return DepartamentoFormSaida.criaSaida(departamento);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public DepartamentoFormSaida Atualizar(@PathVariable Long id, @RequestBody DepartamentoFormEntrada formEntrada) {
		Departamento departamento = this.departamentoRepository.findById(id).get();
		departamento.setDescricao(formEntrada.getDescricao());
		
		return DepartamentoFormSaida.criaSaida(departamento);
	}
	
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Long id) {
		this.departamentoRepository.deleteById(id);
	}

}

