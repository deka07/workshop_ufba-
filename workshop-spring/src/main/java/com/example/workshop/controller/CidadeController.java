package com.example.workshop.controller;

import com.example.workshop.data.CidadeRepository;
import com.example.workshop.model.Cidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @GetMapping
    public List<Cidade>listar() {
        List<Cidade> cidades = this.cidadeRepository.findAll();
        return cidades;
    }
    
    @PostMapping
    public Cidade Salvar(@RequestBody Cidade novaCidade) {
        return this.cidadeRepository.save(novaCidade);
    }  
    
    @GetMapping("/{id}")
    public Cidade Buscar(@PathVariable Long id) {
        Cidade cidade = this.cidadeRepository.findById(id).get();
        return cidade;
    }
    
}
