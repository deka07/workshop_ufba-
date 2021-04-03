package com.example.workshop.form;

import com.example.workshop.model.Projeto;

public class ProjetoFormEntrada {
	
	private String contratante;
	private String dataInicio;
	private String nome;
	
	public String getContratante() {
		return contratante;
	}

	public void setContratante(String contratante) {
		this.contratante = contratante;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Projeto criaProjeto() {
		return new Projeto(this.nome, this.dataInicio, this.contratante);
	}

}
