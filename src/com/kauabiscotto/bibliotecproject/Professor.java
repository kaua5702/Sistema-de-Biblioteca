package com.kauabiscotto.bibliotecproject;

public class Professor extends Pessoa {

    private String disciplina;
    private int livrosEmprestados;

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
        this.livrosEmprestados = 0;
    }

    @Override
    public void exibirPerfil() {
        System.out.println("Professor: " + getNome() + ", Idade: " + getIdade() + ", Disciplina: " + disciplina);
    }

    // 🔹 Métodos auxiliares
    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void adicionarLivroEmprestado() {
        livrosEmprestados++;
    }

    public void devolverLivro() {
        livrosEmprestados--;
    }

}
