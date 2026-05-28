package com.kauabiscotto.bibliotecproject;


public abstract class Pessoa {

    private String nome;
    private int idade;
    private int id;
    private int tipo;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(int id, String nome, int idade,  int tipo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getTipo() {
        return tipo;
    }

    public abstract void exibirPerfil();
}
