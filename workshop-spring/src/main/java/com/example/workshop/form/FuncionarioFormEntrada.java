package com.example.workshop.form;

import com.example.workshop.data.CargoRepository;
import com.example.workshop.data.DepartamentoRepository;
import com.example.workshop.model.Cargo;
import com.example.workshop.model.Departamento;
import com.example.workshop.model.Funcionario;

public class FuncionarioFormEntrada {
	
	private String cpf;
	private String nome;
	private String cargo;
	private String departamento;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public Funcionario criaFuncionario(CargoRepository cargoRepository, DepartamentoRepository departamentoRepository) {
		Cargo cargo = cargoRepository.findByDescricao(this.cargo);
		Departamento departamento = departamentoRepository.findByDescricao(this.departamento);
		return new Funcionario(this.nome, this.cpf, departamento, cargo);
	}

}
