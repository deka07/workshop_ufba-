package com.example.workshop.data;

import com.example.workshop.model.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{
       
}
