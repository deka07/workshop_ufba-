package com.example.workshop.data;

import com.example.workshop.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
       public Cidade findByDescricao(String estado);
}
