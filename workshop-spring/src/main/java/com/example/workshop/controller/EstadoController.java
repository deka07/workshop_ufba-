package com.example.workshop.controller;

import com.example.workshop.data.EstadoRepository;
import com.example.workshop.form.CargoFormSaida;
import com.example.workshop.model.Cargo;
import com.example.workshop.model.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @GetMapping
    public List<Estado>listar() {
        List<Estado> estados = this.estadoRepository.findAll();
        return estados;
    }
    
    @PostMapping
    public Estado Salvar(@RequestBody Estado novoEstado) {
        return this.estadoRepository.save(novoEstado);
    }  
    
    @GetMapping("/{id}")
    public Estado Buscar(@PathVariable Long id) {
            Estado estado = this.estadoRepository.findById(id).get();
            return estado;
    }
    
}
