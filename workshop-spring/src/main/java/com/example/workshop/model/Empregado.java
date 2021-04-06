package com.example.workshop.model;

import javax.persistence.*;        

@Entity
@Table(name="empregados")
public class Empregado {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 150)
    private String nome;
    
    Empregado() {}
    Empregado(String nome) {
        this.nome = nome;        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}
