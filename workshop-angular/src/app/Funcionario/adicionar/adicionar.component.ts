import { getTranslationDeclStmts } from '@angular/compiler/src/render3/view/template';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estado } from 'src/app/Modelo/Estado';
import { Funcionario } from 'src/app/Modelo/Funcionario';
import { ServiceService } from '../../../app/Service/service.service';

@Component({
  selector: 'app-adicionar',
  templateUrl: './adicionar.component.html',
  styleUrls: ['./adicionar.component.css']
})
export class AdicionarComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService){}
  
  estados: Estado[] = [];
  funcionarios: Funcionario[] = [];

  ngOnInit(): void {
    this.service.getEstados().subscribe(d => {this.estados = d;})  
    this.service.getFuncionario().subscribe(d => {this.funcionarios = d;})    
  }
   
  Departaments: Array<any> = [
		{ name: 'A', cargos: ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn']},
		{ name: 'B', cargos: ['Barcelona']},
		{ name: 'C', cargos: ['Downers Grove']},
		{ name: 'D', cargos: ['Puebla']},
		{ name: 'E', cargos: ['Delhi', 'Kolkata', 'Mumbai', 'Bangalore']},
	];
  cargos: Array<any> = []; 

  changeDepartament(state: any) { 
    console.log(this.estados);		
		this.cargos = this.Departaments.find((stat: any) => stat.name == state.target.value).cargos; 
	}  

  // City Names
  Types: any = ['Celular', 'Telefone', 'E-mail']

  changeWebsite(e:any) {
    console.log(e.target.value);
  }


  States: Array<any> = [
		{ name: 'A', cities: ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn']},
		{ name: 'B', cities: ['Barcelona']},
		{ name: 'C', cities: ['Downers Grove']},
		{ name: 'D', cities: ['Puebla']},
		{ name: 'E', cities: ['Delhi', 'Kolkata', 'Mumbai', 'Bangalore']},
	];
  cities: Array<any> = []; 

  changeState(state: any) { 		
		this.cities = this.States.find((stat: any) => stat.name == state.target.value).cities; 
	}  


  Salvar(func:Funcionario){
    this.service.createFuncionario(func).subscribe(data=>{
      alert("Com Sucesso!");
      this.router.navigate(["listar"])
    });
  }
}
