package com.example.workshop.form;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.Projeto;

public class ProjetoFormSaida {
	
	private Long id;
	private String contratante;
	private String dataInicio;
	private String nome;
	
	public ProjetoFormSaida(Long id, String contratante, String dataInicio, String nome) {
		this.id = id;
		this.contratante = contratante;
		this.dataInicio = dataInicio;
		this.nome = nome;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public static List<ProjetoFormSaida> converter(List<Projeto> projetos) {
		List<ProjetoFormSaida> projetoFormSaida = new ArrayList<ProjetoFormSaida>();
		projetos.forEach(projeto ->{
			projetoFormSaida.add(new ProjetoFormSaida(projeto.getId(), projeto.getContratante(), projeto.getDataInicio(), projeto.getNome()));
		});
		
		return projetoFormSaida;
	}


	public static ProjetoFormSaida criarSaida(Projeto projeto) {
		return new ProjetoFormSaida(projeto.getId(), projeto.getContratante(), projeto.getDataInicio(), projeto.getNome());
	}

}
