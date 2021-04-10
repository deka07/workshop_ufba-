import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Funcionario } from 'src/app/Modelo/Funcionario';
import { ServiceService }from '../../Service/service.service'

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  funcionarios: Funcionario[] = [];
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    this.service.getFuncionario().subscribe(d => {this.funcionarios = d;})
  }

  Editar(funcionario:Funcionario):void{
    localStorage.setItem("id",funcionario.id.toString());
    this.router.navigate(["edit"]);
  }

  Deletar(funcionario:Funcionario){
    this.service.deleteFuncionario(funcionario)
    .subscribe(d => {
      this.funcionarios = this.funcionarios.filter(p=>p!==funcionario);
      alert("Funcionário Deletado")
    })
  }

}
