import { Component, OnInit } from '@angular/core';
import { SelectControlValueAccessor } from '@angular/forms';
import { Router } from '@angular/router';
import { Estado } from 'src/app/Modelo/Estado';
import { Funcionario } from 'src/app/Modelo/Funcionario';
import { Cidade } from 'src/app/Modelo/Cidade';
import { Departamento } from 'src/app/Modelo/Departamento';
import { Cargo } from 'src/app/Modelo/Cargo';
import { Contato } from 'src/app/Modelo/Contato';
import { Projeto } from 'src/app/Modelo/Projeto';
import { ServiceService } from '../../../app/Service/service.service';
import { Endereco } from 'src/app/Modelo/Endereco';
import { unescapeIdentifier } from '@angular/compiler';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService){}

  estados: Estado[] = [];
  cidades: Cidade[] = [];  
  departamentos: Departamento[] = [];  
  cargos: Cargo[] = [];
  contatos: Contato[] = [];
  projetos: Projeto[] = [];
  funcionario: any;

  Types: any = [
    {tipo: 'C', descricao: 'Celular'},
    {tipo: 'T', descricao: 'Telefone'},
    {tipo: 'E', descricao: 'E-mail'}
  ];

  ngOnInit(): void {
    this.Editar();
  }

  changeDepartament(departamento: any) {          				
    this.service.getCargoPorDepartamentoId(departamento.target.value).subscribe(d => {this.cargos = d;})
	}   
  
  addContact(){        
    this.contatos.push({      
      tipo:       
      (<HTMLInputElement>document.getElementById("TipoContato")).value == 'C' ? 'Celular' :
      (<HTMLInputElement>document.getElementById("TipoContato")).value == 'E' ? 'E-mail' : 'Telefone',
      campo: (<HTMLInputElement>document.getElementById("CampoContato")).value});        
  }

  changeState(estado: any) {     
    this.service.getCidadesPorEstadoId(estado.target.value).subscribe(d => {this.cidades = d;})
	}  

  CheckElement(projeto: Projeto) {      
    var objIndex = this.projetos.findIndex((obj => obj.id == projeto.id));    
    this.projetos[objIndex].selecionado = true;
	}   

  DeletarContato(contato: any){
    this.contatos = this.contatos.filter(obj => obj.campo !== contato.campo && obj.tipo !== contato.tipo);
  }


  async getAsyncData() {
    var lId = localStorage.getItem("id")!; 
    this.funcionario = await this.service.getFuncionarioId(+lId).toPromise();
    this.estados = await this.service.getEstados().toPromise();
    this.departamentos = await this.service.getDepartamentos().toPromise();
    this.projetos = await this.service.getProjetos().toPromise();
  }

  async Editar(){
    await this.getAsyncData()    
    this.setValues();
  }

  setValues(){
    console.log(this.funcionario);
    (<HTMLInputElement>document.getElementById("NomeFuncionario")).value = this.funcionario.nome_funcionario;
    (<HTMLInputElement>document.getElementById("CPFFuncionario")).value = this.funcionario.cpf_funcionario;
    (<HTMLInputElement>document.getElementById("DepartamentoFuncionario")).value = this.funcionario.cargo.departamento.id
    (<HTMLInputElement>document.getElementById("CargoFuncionario")).value = this.funcionario.cargo.id
  };

  Salvar(){
  }

}
