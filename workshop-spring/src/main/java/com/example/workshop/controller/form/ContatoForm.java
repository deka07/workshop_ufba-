package com.example.workshop.controller.form;

import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.model.Contato;
import com.example.workshop.model.Funcionario;
import com.example.workshop.model.TipoContato;

public class ContatoForm {
	
	private Long id_funcionario;
	private String numero;
	private char tipo;
	
	public Long getId_funcionario() {
		return id_funcionario;
	}
	
	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public static TipoContato converteTipo(char valor) {
		if(valor == 'c' || valor == 'C')
			return TipoContato.CELULAR;
		if(valor == 't' || valor == 'T')
			return TipoContato.TELEFONE;
		return TipoContato.NAO_ESPECIFICADO;
	}
	
	public static Contato converte(ContatoForm valorNew, FuncionarioRepository funcionarioRep) {
		Funcionario funcionario = funcionarioRep.findById(valorNew.getId_funcionario()).get();
		return new Contato(funcionario, valorNew.getNumero(), ContatoForm.converteTipo(valorNew.getTipo()));
	}
	
	
	

}
