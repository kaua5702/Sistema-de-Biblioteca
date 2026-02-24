package com.kauabiscotto.bibliotecproject;

public class Aluno extends Pessoa {

    private int livrosEmprestados;

    public Aluno(String nome, int idade) {
        super(nome, idade);
        this.livrosEmprestados = 0;

    }
    @Override
    public void exibirPerfil() {
        System.out.println("Aluno: " + getNome() + ", Idade: " + getIdade());
    }

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void adiconarLivroEmprestado() {
        livrosEmprestados++;
    }

    public void devolverLivro() {
        livrosEmprestados--;
    }
}
