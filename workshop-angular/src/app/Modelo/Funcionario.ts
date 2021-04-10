import { Cargo } from "./Cargo";
import { Contato } from "./Contato";
import { Endereco } from "./Endereco";
import { Projeto } from "./Projeto";
import { ProjetoMap } from "./ProjetoMap";

export class Funcionario{
    id!: number;
    nome_funcionario!: String;
    cpf_funcionario!: String;
    idCargo!: number;
    endereco!: Endereco;
    contatos!: Contato[];
    projetos!: number[];

    constructor(nome_funcionario: string, cpf_funcionario: string, idCargo: number, endereco:Endereco, contatos: Contato[], projetos: number[]) {
        this.nome_funcionario = nome_funcionario;
        this.cpf_funcionario = cpf_funcionario;
        this.idCargo = idCargo;
        this.endereco = endereco;
        this.contatos = contatos;
        this.projetos = projetos;
    }
}