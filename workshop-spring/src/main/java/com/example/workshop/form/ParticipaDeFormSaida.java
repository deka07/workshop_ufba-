package com.example.workshop.form;

import java.util.ArrayList;
import java.util.List;

import com.example.workshop.model.ParticipaDe;

public class ParticipaDeFormSaida {
	
	private Long id;
	private String funcionarioCPF;
	private String funcionarioNome;
	private String projetoNome;
	

	public ParticipaDeFormSaida(Long id, String funcionarioCPF, String funcionarioNome, String projetoNome) {
		this.id = id;
		this.funcionarioCPF = funcionarioCPF;
		this.funcionarioNome = funcionarioNome;
		this.projetoNome = projetoNome;
	}


	public String getFuncionarioCPF() {
		return funcionarioCPF;
	}

	public void setFuncionarioCPF(String funcionarioCPF) {
		this.funcionarioCPF = funcionarioCPF;
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	public String getProjetoNome() {
		return projetoNome;
	}

	public void setProjetoNome(String projetoNome) {
		this.projetoNome = projetoNome;
	}

	public Long getId() {
		return id;
	}
	
	public static List<ParticipaDeFormSaida> converter(List<ParticipaDe> listaParticipaDe) {
		List<ParticipaDeFormSaida> participaDe = new ArrayList<ParticipaDeFormSaida>();
		listaParticipaDe.forEach(p ->{
			participaDe.add(new ParticipaDeFormSaida(p.getId(), p.getFuncionario().getCpf(), p.getFuncionario().getNome(), p.getProjeto().getNome()));
		});
		
		return participaDe;
	}
	
	public static ParticipaDeFormSaida criaSaida(ParticipaDe p) {
		return new ParticipaDeFormSaida(p.getId(), p.getFuncionario().getCpf(), p.getFuncionario().getNome(), p.getProjeto().getNome());
	}

}
