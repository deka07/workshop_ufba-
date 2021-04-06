import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Funcionario } from 'src/app/Modelo/Funcionario';
import { ServiceService } from '../../../app/Service/service.service';

@Component({
  selector: 'app-adicionar',
  templateUrl: './adicionar.component.html',
  styleUrls: ['./adicionar.component.css']
})
export class AdicionarComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService){}

  ngOnInit(): void {
  }

  Salvar(func:Funcionario){
    this.service.createFuncionario(func).subscribe(data=>{
      alert("Com Sucesso!");
      this.router.navigate(["listar"])
    });
  }
}
