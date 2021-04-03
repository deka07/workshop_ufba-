package com.example.workshop.form;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Cargo;
import com.example.workshop.model.Departamento;
import com.example.workshop.model.Funcionario;

public class FuncionarioFormSaida {
	
	private Long id;
	private String cpf;
	private String nome;
	private Cargo cargo;
	private Departamento departamento;
	
	public FuncionarioFormSaida(Long id, String cpf, String nome, Cargo cargo, Departamento departamento) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.cargo = cargo;
		this.departamento = departamento;
	}
	
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Long getId() {
		return id;
	}

	public static List<FuncionarioFormSaida> converter(List<Funcionario> funcionarios) {
		List<FuncionarioFormSaida> funcionarioFormSaida = new ArrayList<FuncionarioFormSaida>();
		funcionarios.forEach(f->{
			funcionarioFormSaida.add(new FuncionarioFormSaida(f.getId(), f.getCpf(), f.getNome(), f.getCargo(), f.getDepartamento()));
		});
		
		return funcionarioFormSaida;
	}

	public static FuncionarioFormSaida criarSaida(Funcionario f) {
		return new FuncionarioFormSaida(f.getId(), f.getCpf(), f.getNome(), f.getCargo(), f.getDepartamento());
	}

}
