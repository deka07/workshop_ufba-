package com.example.workshop.form;

import com.example.workshop.model.Cargo;

public class CargoFormEntrada {
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cargo criarCargo() {
		return new Cargo(this.descricao);
	}
}
