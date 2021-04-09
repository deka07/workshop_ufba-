import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Funcionario } from '../Modelo/Funcionario';
import { Estado } from '../Modelo/Estado';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  //Url='https://localhost:8080/funcionarios'
  Url='http://localhost:4200/api/funcionarios'
  
  UrlEstados = 'http://localhost:4200/api/estados'

  getEstados(){    
    return this.http.get<Estado[]>(this.UrlEstados)
  }

  getFuncionario(){
    return this.http.get<Funcionario[]>(this.Url)
  }

  createFuncionario(func:Funcionario){
    return this.http.post<Funcionario>(this.Url,func)
  }

  getFuncionarioId(id:number){
    return this.http.get<Funcionario>(this.Url+"/"+id)
  }

  updateFuncionario(func:Funcionario){
    return this.http.put<Funcionario>(this.Url+"/"+func.id,func)
  }

  deleteFuncionario(func:Funcionario){    
    return this.http.delete<Funcionario>(this.Url+"/"+func.id)
  }

}
