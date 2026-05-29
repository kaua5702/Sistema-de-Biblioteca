# 📚 BibliotecaApp

Um sistema de gerenciamento de biblioteca desenvolvido em **Java**, com suporte a cadastro de pessoas (alunos e professores), livros, empréstimos e devoluções, integrado a um banco de dados **MySQL**.

Este projeto foi criado para fins de aprendizado de **Programação Orientada a Objetos** e evoluído com integração a banco de dados relacional utilizando **JDBC**.

---

## 🚀 Funcionalidades

- Cadastrar alunos (nome e idade).
- Cadastrar livros (título, autor e ano).
- Emprestar livros para pessoas cadastradas.
- Devolver livros emprestados.
- Listar livros disponíveis na biblioteca.
- Persistência de dados em banco de dados MySQL.
- Registro de histórico de empréstimos e devoluções com data.
- Mensagens claras de feedback para cada operação.

---

## 🛠️ Tecnologias utilizadas

- **Java 25** (OpenJDK)
- **MySQL** para persistência de dados
- **JDBC** para comunicação com o banco de dados
- **Maven** para gerenciamento de dependências
- **mysql-connector-j 8.3.0** como driver de conexão
- **Scanner** para interação com o usuário via console

---

## 🗄️ Estrutura do banco de dados

```sql
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

CREATE TABLE pessoas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT,
    tipo VARCHAR(20) NOT NULL,
    disciplina VARCHAR(100)
);

CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    ano INT,
    emprestado BOOLEAN DEFAULT FALSE
);

CREATE TABLE emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pessoa_id INT,
    livro_id INT,
    data_emprestimo DATE,
    data_devolucao DATE,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id),
    FOREIGN KEY (livro_id) REFERENCES livros(id)
);
```

---

## 🗂️ Estrutura do projeto

```
src/
└── com/kauabiscotto/bibliotecproject/
    ├── BibliotecaApp.java       ← Ponto de entrada
    ├── Biblioteca.java          ← Lógica principal
    ├── Livro.java               ← Entidade Livro
    ├── Pessoa.java              ← Entidade abstrata Pessoa
    ├── Aluno.java               ← Herda de Pessoa
    ├── Professor.java           ← Herda de Pessoa
    ├── factory/
    │   └── ConnectionFactory.java  ← Conexão com o banco
    └── dao/
        ├── LivroDAO.java           ← CRUD de livros
        ├── PessoaDAO.java          ← CRUD de pessoas
        └── EmprestimoDAO.java      ← Registro de empréstimos
```

---

## ⚙️ Como executar

1. Clone o repositório
2. Crie o banco de dados usando o script SQL acima no **MySQL Workbench** ou terminal
3. Configure as credenciais do banco em `ConnectionFactory.java`:
```java
private static final String username = "seu_usuario";
private static final String password = "sua_senha";
private static final String url = "jdbc:mysql://localhost:3306/biblioteca";
```
4. Importe o projeto no **IntelliJ IDEA** como projeto Maven
5. Execute a classe `BibliotecaApp`

---

## 📖 Exemplo de uso

Menu interativo:
```
===== MENU BIBLIOTECA =====
1 - Cadastrar Aluno
2 - Cadastrar Livro
3 - Emprestar Livro
4 - Devolver Livro
5 - Listar Livros Disponíveis
0 - Sair
Escolha uma opção:
```

Fluxo:
- Cadastrar aluno → `Registro adicionado com sucesso!`
- Cadastrar livro → `📚 Livro cadastrado com sucesso!`
- Emprestar livro → `Livro emprestado com sucesso!`
- Devolver livro → `Livro devolvido com sucesso!`
- Listar livros → mostra todos os disponíveis no momento.
