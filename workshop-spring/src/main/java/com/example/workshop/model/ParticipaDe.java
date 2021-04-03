package com.example.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="participa_de")
public class ParticipaDe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name = "id_projeto")
	private Projeto projeto;
	
	public ParticipaDe() {}
	
	public ParticipaDe(Funcionario funcionario, Projeto projeto) {
		this.funcionario = funcionario;
		this.projeto = projeto;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public Long getId() {
		return id;
	}
	
	
}
