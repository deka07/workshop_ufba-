import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Funcionario } from '../Modelo/Funcionario';
import { Estado } from '../Modelo/Estado';
import { Cidade } from '../Modelo/Cidade';
import { Departamento } from '../Modelo/Departamento';
import { Cargo } from '../Modelo/Cargo';
import { Projeto } from '../Modelo/Projeto';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url = 'http://localhost:4200/api/'
  
  UrlFuncionarios='http://localhost:4200/api/funcionarios'
  
  UrlEstados = 'http://localhost:4200/api/estados'

  UrlCidadesEstado = 'http://localhost:4200/api/cidades/estado'

  UrlCidades = 'http://localhost:4200/api/cidades'

  UrlDepartamento = 'http://localhost:4200/api/departamentos'

  UrlCargos = 'http://localhost:4200/api/cargos/departamento'   
  
  UrlProjetos = 'http://localhost:4200/api/projetos'  

  UrlCargo = 'http://localhost:4200/api/cargos'

  getEstados(){    
    return this.http.get<Estado[]>(this.UrlEstados)
  }

  getCidadePorId(id:number){
    return this.http.get<Cidade>(this.UrlCidades+"/"+id)
  }

  getCargoPorId(id:number){
    return this.http.get<Cidade>(this.UrlCargo+"/"+id)
  }

  getCidadesPorEstadoId(id:number){
    return this.http.get<Cidade[]>(this.UrlCidadesEstado+"/"+id)
  }

  getProjetos(){
    return this.http.get<Projeto[]>(this.UrlProjetos)
  }

  getDepartamentos(){    
    return this.http.get<Departamento[]>(this.UrlDepartamento)
  }  

  getCargoPorDepartamentoId(id:number){
    return this.http.get<Cargo[]>(this.UrlCargos+"/"+id)
  }

  getFuncionario(){
    return this.http.get<Funcionario[]>(this.UrlFuncionarios)
  }

  createFuncionario(func:Funcionario){
    return this.http.post<Funcionario>(this.UrlFuncionarios,func)
  }

  getFuncionarioId(id:number){
    return this.http.get<Funcionario>(this.UrlFuncionarios+"/"+id)
  }

  updateFuncionario(func:Funcionario){
    return this.http.put<Funcionario>(this.UrlFuncionarios+"/"+func.id,func)
  }

  deleteFuncionario(func:Funcionario){    
    return this.http.delete<Funcionario>(this.UrlFuncionarios+"/"+func.id)
  }

}
