package com.example.workshop.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Contato;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.TipoContato;

public class ContatoDto {
	
	private Long id;
	private String nome_funcionario;
	private String cpf_funcionario;
	private String numero;
	private TipoContato tipo;
	
	
	public ContatoDto(Long id, Funcionario funcionario, String numero, TipoContato tipo) {
		this.id = id;
		this.nome_funcionario = funcionario.getNome();
		this.cpf_funcionario = funcionario.getCpf();
		this.numero = numero;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}
	
	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public String getCpf_funcionario() {
		return cpf_funcionario;
	}

	public String getNumero() {
		return numero;
	}
	
	public TipoContato getTipo() {
		return tipo;
	}
	
	public static List<ContatoDto> converteList(List<Contato> valores) {
		List<ContatoDto> dto = new ArrayList<ContatoDto>();
		valores.forEach(v->{
			dto.add(new ContatoDto(v.getId(), v.getFuncionario(), v.getNumero(), v.getTipo()));
		});
		return dto;
	}

	public static ContatoDto converte(Contato v) {
		return new ContatoDto(v.getId(), v.getFuncionario(), v.getNumero(), v.getTipo());
	}
	
	
	

}
