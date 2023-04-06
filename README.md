# Todo List 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jefferson-son/toDoList-JDBC/blob/main/LICENSE) 

# Sobre o projeto

TodoList é um projeto de back-end contruído com os conhecimentos adiquirios em JAVA, OO, UML, SQL(MySQL) e acesso ao banco de dados com JDBC.
Ainda está com interação em linha de comando através do console, mas com o passar do tempo e com a evolução do meu aprendizado, será adicionado
o front-end para uma melhor interação com o usuário.

A aplicação consiste possui as seguintes características:
  - Tela de cadastro de usuário;
  - Tela de autenticação de usuário;
  - Tela para CRUD de tarefas:
      - Inserir tarefa;
      - Atualizar tarefa;
      - Deletar tarefa;
      - Listar tarefas pelos filtros: todas, por ID, TODO, DOING e DONE.
   
## Modelo conceitual
![uml-todoList](https://user-images.githubusercontent.com/76973226/230245068-550667d9-0338-4ebc-9003-1538e4a30a64.jpeg)

# Tecnologias utilizadas
## Back end
- Java
- JDBC
- MySQL

# Como executar o projeto
Pré-requisitos: 
- Java 11;
- Editor de código.

```bash
# clonar repositório
git clone https://github.com/jefferson-son/toDoList-JDBC
```
#Baixar MySQL
- Instalar o MySQL server e Workbench 8.0;
- Baixar banco de dados teste e executar como script no MySQL Workbench:
 [Workbench](https://drive.google.com/file/d/1cSGtbwj-gfCfrOAPZaByhtd6BhiFE-Ol/view?usp=sharing)

#Entrar na pasta do projeto
- Abrí-lo com editor de preferência;
- Acessar arquivo db.properties na raiz do projeto;
- Alterar configurações de user="" e password="" para o usuário root do MySQL;
- Executar a aplicação.

# Autor

Jefferson Ferreira da Silva

https://www.linkedin.com/in/jeffersonferreira-dev/
