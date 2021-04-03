package com.example.workshop.form;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Departamento;

public class DepartamentoFormSaida {
	
	private Long id;
	private String descricao;
	
	public DepartamentoFormSaida(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public static List<DepartamentoFormSaida> converter(List<Departamento> departamentos) {
		List<DepartamentoFormSaida> formSaida = new ArrayList<DepartamentoFormSaida>();
		departamentos.forEach(departamento ->{
			formSaida.add(new DepartamentoFormSaida(departamento.getId(), departamento.getDescricao()));
		});
		
		return formSaida;
	}


	public static DepartamentoFormSaida criaSaida(Departamento departamento) {
		return new DepartamentoFormSaida(departamento.getId(), departamento.getDescricao());
	}
	
	

}
