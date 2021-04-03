package com.example.workshop.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.data.CargoRepository;
import com.example.workshop.form.CargoFormSaida;
import com.example.workshop.form.CargoFormEntrada;
import com.example.workshop.model.Cargo;

@RestController
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<CargoFormSaida>listar() {
		List<Cargo> cargos = this.cargoRepository.findAll();
		
		return CargoFormSaida.converter(cargos);
	}
	
	@PostMapping
	@Transactional
	public CargoFormSaida Salvar(@RequestBody CargoFormEntrada formEntrada) {
		Cargo cargo = formEntrada.criarCargo();
		this.cargoRepository.save(cargo);
		return CargoFormSaida.criarSaida(cargo);
	}
	
	@GetMapping("/{id}")
	public CargoFormSaida Buscar(@PathVariable Long id) {
		Cargo cargo = this.cargoRepository.findById(id).get();
		
		return CargoFormSaida.criarSaida(cargo);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public CargoFormSaida Atualizar(@RequestBody CargoFormEntrada formEntrada, @PathVariable Long id) {
		Cargo cargo = this.cargoRepository.findById(id).get();
		cargo.setDescricao(formEntrada.getDescricao());
		return CargoFormSaida.criarSaida(cargo);
	}
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Long id) {
		this.cargoRepository.deleteById(id);
	}

}
