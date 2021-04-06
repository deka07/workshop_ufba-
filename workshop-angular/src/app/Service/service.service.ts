import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Funcionario } from '../Modelo/Funcionario';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/funcionarios'

  getFuncionario(){
    return this.http.get<Funcionario[]>(this.Url)
  }

  createFuncionario(func:Funcionario){
    return this.http.post<Funcionario>(this.Url,func)
  }


}
