package com.example.workshop.controller;

import com.example.workshop.model.Empregado;
import com.example.workshop.service.IEmpregadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpregadoController {
    @Autowired
    private IEmpregadoService empService;

    @GetMapping("/empregados")
    @ResponseBody
    public List<Empregado> Listar() {
        List<Empregado> empregados = empService.Listar();
        return empregados;
    }
    
    @PostMapping("/empregados")
    public Empregado Salvar(@RequestBody Empregado novoEmpregado) {
        return empService.Salvar(novoEmpregado);
    }  
  
    @GetMapping("/empregados/{id}")
    Empregado Buscar(@PathVariable Long id) {
      return empService.BuscarPorId(id);
    }

    @PutMapping("/empregados/{id}")
    Empregado Editar(@RequestBody Empregado editEmpregado, @PathVariable Long id) {    
        return empService.Editar(editEmpregado, id);
    }

    @DeleteMapping("/empregados/{id}")
    void Deletar(@PathVariable Long id) {
      empService.Deletar(id);
    }         
}
