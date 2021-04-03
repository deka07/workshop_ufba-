package com.example.workshop.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	public Cargo findByDescricao(String cargo);

}
