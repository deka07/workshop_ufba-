package com.example.workshop.form;

import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.data.ProjetoRepository;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.ParticipaDe;
import com.example.workshop.model.Projeto;

public class ParticipaDeFormEntrada {
	
	private String cpfFuncioanario;
	private String nomeProjeto;
	
	public String getCpfFuncioanario() {
		return cpfFuncioanario;
	}
	
	public void setCpfFuncioanario(String cpfFuncioanario) {
		this.cpfFuncioanario = cpfFuncioanario;
	}
	
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	
	public ParticipaDe criaParticipaDe(FuncionarioRepository f, ProjetoRepository p) {
		Funcionario funcionario = f.findBycpf(this.getCpfFuncioanario());
		Projeto projeto = p.findBynome(this.getNomeProjeto());
		
		return new ParticipaDe(funcionario, projeto);
	}

}
