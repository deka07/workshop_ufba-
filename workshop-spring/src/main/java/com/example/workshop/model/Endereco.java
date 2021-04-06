package com.example.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*CLASSE CRIADA APENAS PARA TESTE, SUBSTITUIR PELA CLASSE CORRETA*/


@Entity
@Table(name= "enderecos")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	

}
