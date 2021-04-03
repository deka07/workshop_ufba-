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

import com.example.workshop.data.CargoRepository;
import com.example.workshop.data.DepartamentoRepository;
import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.form.FuncionarioFormEntrada;
import com.example.workshop.form.FuncionarioFormSaida;
import com.example.workshop.model.Cargo;
import com.example.workshop.model.Departamento;
import com.example.workshop.model.Funcionario;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping
	public List<FuncionarioFormSaida> Listar() {
		List<Funcionario> funcionarios = this.funcionarioRepository.findAll();
		
		return FuncionarioFormSaida.converter(funcionarios);
	}
	
	@PostMapping
	@Transactional
	public FuncionarioFormSaida salvar(@RequestBody FuncionarioFormEntrada formEntrada){
		Funcionario funcionario = formEntrada.criaFuncionario(this.cargoRepository, this.departamentoRepository);
		this.funcionarioRepository.save(funcionario);
		
		return FuncionarioFormSaida.criarSaida(funcionario);
	}
	
	
	@GetMapping("/{id}")
	public FuncionarioFormSaida buscar(@PathVariable Long id) {
		Funcionario funcionario = this.funcionarioRepository.findById(id).get();
		
		return FuncionarioFormSaida.criarSaida(funcionario);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public FuncionarioFormSaida atualizar(@PathVariable Long id, @RequestBody FuncionarioFormEntrada formEntrada) {
		Funcionario funcionario = this.funcionarioRepository.findById(id).get();
		Cargo cargo = this.cargoRepository.findByDescricao(formEntrada.getCargo());
		Departamento departamento = this.departamentoRepository.findByDescricao(formEntrada.getDepartamento());
		
		funcionario.setCargo(cargo);
		funcionario.setDepartamento(departamento);
		funcionario.setCpf(formEntrada.getCpf());
		funcionario.setNome(formEntrada.getNome());
		
		return FuncionarioFormSaida.criarSaida(funcionario);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.funcionarioRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	

}
