package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Cargo;
import com.example.workshop.model.Endereco;
import com.example.workshop.model.Funcionario;

public class FuncionarioDto {
	
	private Long id;
	private String nome_funcionario;
	private String cpf_funcionario;
	private Cargo cargo;
	private Endereco endereco;
	

	public FuncionarioDto(Long id, String nome_funcionario, String cpf_funcionario, Cargo cargo, Endereco endereco) {
		this.id = id;
		this.nome_funcionario = nome_funcionario;
		this.cpf_funcionario = cpf_funcionario;
		this.cargo = cargo;
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}
	
	public String getCpf_funcionario() {
		return cpf_funcionario;
	}
	
	
	public Long getId() {
		return id;
	}

	public static List<FuncionarioDto> converteList(List<Funcionario> valores) {
		List<FuncionarioDto> dto = new ArrayList<FuncionarioDto>();
		valores.forEach(v->{
			dto.add(new FuncionarioDto(v.getId(),v.getNome(), v.getCpf(), v.getCargo(), v.getEndereco()));
		});
		return dto;
	}

	public static FuncionarioDto converte(Funcionario v) {
		return new FuncionarioDto(v.getId(), v.getNome(), v.getCpf(), v.getCargo(), v.getEndereco());
	}

	
	
	
}
