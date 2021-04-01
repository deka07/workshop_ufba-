package com.example.workshop.service;

import com.example.workshop.model.Empregado;
import com.example.workshop.data.EmpregadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpregadoService implements IEmpregadoService{
    
    @Autowired
    private EmpregadoRepository EmpRepository;

    @Override
    public List<Empregado> Listar() {
        return (List<Empregado>) EmpRepository.findAll();        
    }
    
    @Override
    public void Deletar(long id){
        EmpRepository.deleteById(id);
    }
        
    @Override
    public Empregado Salvar(Empregado e){
        return EmpRepository.save(e);
    }
    
    @Override
    public Empregado BuscarPorId(long id){
        return EmpRepository.findById(id).get();
    }
    
    public Empregado Editar(Empregado e, long id){
        Empregado editEmp = EmpRepository.findById(id).get();
        editEmp.setNome(e.getNome());
        return EmpRepository.save(editEmp);
    }
    
}
