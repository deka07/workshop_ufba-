# workshop_ufba

## URLs


> ### GET - Lista todos os cargos
> ~~~
> http://localhost:8080/cargos
> ~~~

> ### POST - Cria um cargo
> ~~~
> http://localhost:8080/cargos
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "descricao": "vendedor"
>  }
> ~~~

> ### GET - Retorna apenas o cargo especificado
> ~~~
> http://localhost:8080/cargos/1
> ~~~

> ### PUT - Atualiza o cargo especificado
> ~~~
> http://localhost:8080/cargos/1
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "descricao": "vendedor"
> }
> ~~~

> ### DELETE - Deleta o cargo espeficicado
> ~~~
> http://localhost:8080/cargos/1
> ~~~

> ### GET - Lista todos os departamentos
> ~~~
> http://localhost:8080/departamentos
> ~~~

> ### GET - Retorna apenas o departamento especificado
> ~~~
> http://localhost:8080/departamentos/2
> ~~~

> ### POST - Cria um departamento
> ~~~
> http://localhost:8080/departamentos/2
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "descricao": "Administrativo"
> }
> ~~~

> ### DELETE - Deleta o departamento espeficicado
> ~~~
> http://localhost:8080/departamentos/2
> ~~~

> ### PUT - Atualiza o departamento especificado
> ~~~
> http://localhost:8080/departamentos/2
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "descricao": "Administrativo"
> }
> ~~~

> ### GET - Lista todos os Projeto
> ~~~
> http://localhost:8080/projetos
> ~~~

> ### POST - Cria um projeto
> ~~~
> http://localhost:8080/projetos
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "contratante": "Exata assessoria",
>    "nome": "controle de tarefas",
>    "dataInicio": "03-04-2021"
> }
> ~~~

> ### GET - Retorna apenas o projeto especificado
> ~~~
> http://localhost:8080/projetos/1
> ~~~

> ### PUT - Atualiza o projeto especificado
> ~~~
> http://localhost:8080/projetos/1
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "contratante": "Exata Contabilidade",
>    "nome": "controle de tarefas",
>    "dataInicio": "03-04-2021"
> }
> ~~~

> ### DELETE - Deleta o projeto espeficicado
> ~~~
> http://localhost:8080/projetos/1
> ~~~

> ### GET - Lista todos os funcionarios
> ~~~
> http://localhost:8080/funcionarios
> ~~~

> ### GET - Retorna apenas o funcionario especificado
> ~~~
> http://localhost:8080/funcionarios/1
> ~~~

> ### POST - Cria um novo funcionario
> ~~~
> http://localhost:8080/funcionarios
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "cpf": "77777777777",
>    "nome": "Vania costa grossa",
>    "cargo": "vendedor",
>    "departamento": "Fiscal"
> }
> ~~~

> ### PUT - Atualiza o funcionario especificado
> ~~~
> http://localhost:8080/funcionarios/1
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "cpf": "77777774444",
>    "nome": "Vania costa grossa",
>    "cargo": "vendedor",
>    "departamento": "Administrativo"
> }
> ~~~

> ### DELETE - Deleta o funcionario espeficicado
> ~~~
> http://localhost:8080/funcionarios/1
> ~~~

> ### GET - Lista todos os itens da relação funcionario/projeto
> ~~~
> http://localhost:8080/participa-de
> ~~~

> ### POST - Adiciona um funcionario a um projeto
> ~~~
> http://localhost:8080/participa-de
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "cpfFuncioanario": "11111111111",
>    "nomeProjeto": "controle de tarefas"
> }
> ~~~

> ### GET - Retorna apenas uma relação funcionario/projeto especifica
> ~~~
> http://localhost:8080/participa-de/1
> ~~~

> ### PUT - Atualiza uma relações especifica
> ~~~
> http://localhost:8080/participa-de/1
> ~~~
> #### Corpo da requisição
> ~~~
> {
>    "cpfFuncioanario": "22222222222",
>    "nomeProjeto": "nome teste"
> }
> ~~~

> ### DELETE - Deleta uma relação especifica
> ~~~
> http://localhost:8080/participa-de/1
> ~~~


## Modelo relacional do Banco de Dados
![modelo workshop](https://user-images.githubusercontent.com/58126683/113465830-67175480-940d-11eb-8a1c-ee1de48e0675.png)

## Representação do Banco de dados
![modelo workshop2](https://user-images.githubusercontent.com/58126683/113465838-726a8000-940d-11eb-9071-35b4f2b7bf3c.png)




