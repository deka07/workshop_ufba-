package com.example.workshop.form;

import com.example.workshop.model.Departamento;

public class DepartamentoFormEntrada {
	
	private String descricao;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Departamento criaDepartamento() {
		return new Departamento(this.descricao);
	}
	
	
	
	

}
