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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.controller.dto.FuncionarioDto;
import com.example.workshop.controller.form.FuncionarioForm;
import com.example.workshop.data.CargoRepository;
import com.example.workshop.data.EnderecoRepository;
import com.example.workshop.data.FuncionarioRepository;
import com.example.workshop.model.Cargo;
import com.example.workshop.model.Endereco;
import com.example.workshop.model.Funcionario;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	
	@GetMapping
	public List<FuncionarioDto> listar(){
		return FuncionarioDto.converteList(this.funcionarioRepository.findAll());
	}
	
	@PostMapping
	@Transactional
	public FuncionarioDto salvar(@RequestBody FuncionarioForm funcionarioNew) {
		Funcionario funcionario = FuncionarioForm.converte(funcionarioNew, enderecoRepository, cargoRepository);
		this.funcionarioRepository.save(funcionario);
		return FuncionarioDto.converte(funcionario);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public FuncionarioDto editar(@PathVariable Long id, @RequestBody FuncionarioForm funcionarioEdit) {
		Funcionario funcionario = this.funcionarioRepository.findById(id).get();
		Cargo cargo = this.cargoRepository.findById(funcionarioEdit.getIdCargo()).get();
		Endereco endereco = this.enderecoRepository.findById(funcionarioEdit.getIdEndereco()).get();
		
		funcionario.setCargo(cargo);
		funcionario.setCpf(funcionarioEdit.getCpf_funcionario());
		funcionario.setEndereco(endereco);
		funcionario.setNome(funcionarioEdit.getNome_funcionario());
		return FuncionarioDto.converte(funcionario);
	}
	
	@GetMapping("/{id}")
	public FuncionarioDto buscar(@PathVariable Long id) {
		return FuncionarioDto.converte(this.funcionarioRepository.findById(id).get());
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		this.funcionarioRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	

}
