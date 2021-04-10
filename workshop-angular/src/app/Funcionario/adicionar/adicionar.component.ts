import { getTranslationDeclStmts } from '@angular/compiler/src/render3/view/template';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estado } from 'src/app/Modelo/Estado';
import { Funcionario } from 'src/app/Modelo/Funcionario';
import { Cidade } from 'src/app/Modelo/Cidade';
import { Departamento } from 'src/app/Modelo/Departamento';
import { Cargo } from 'src/app/Modelo/Cargo';
import { Contato } from 'src/app/Modelo/Contato';
import { ServiceService } from '../../../app/Service/service.service';

@Component({
  selector: 'app-adicionar',
  templateUrl: './adicionar.component.html',
  styleUrls: ['./adicionar.component.css']
})
export class AdicionarComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService){}
  
  estados: Estado[] = [];
  cidades: Cidade[] = [];  
  departamentos: Departamento[] = [];  
  cargos: Cargo[] = [];
  contatos: Contato[] = [];

  Types: any = [
    {tipo: 'C', descricao: 'Celular'},
    {tipo: 'T', descricao: 'Telefone'},
    {tipo: 'E', descricao: 'E-mail'}
  ]

  ngOnInit(): void {
    this.service.getEstados().subscribe(d => {this.estados = d;})       
    this.service.getDepartamentos().subscribe(d => {this.departamentos = d;})  
  }
   
  changeDepartament(departamento: any) {          				
    this.service.getCargoPorDepartamentoId(departamento.target.value).subscribe(d => {this.cargos = d;})
	}   

  addContact(){
    console.log((<HTMLInputElement>document.getElementById("inlineFormInputGroupUsername")).value);
  }

  changeState(estado: any) {     
    this.service.getCidadesPorEstadoId(estado.target.value).subscribe(d => {this.cidades = d;})
	}  

  Salvar(func:Funcionario){
    this.service.createFuncionario(func).subscribe(data=>{
      alert("Com Sucesso!");
      this.router.navigate(["listar"])
    });
  }
}
