package com.example.workshop.service;

import com.example.workshop.model.Empregado;
import java.util.List;

public interface IEmpregadoService {    
    List<Empregado> Listar(); 
    void Deletar(long id);
    Empregado Salvar(Empregado e);
    Empregado BuscarPorId(long id);   
    Empregado Editar(Empregado e, long id);
}
