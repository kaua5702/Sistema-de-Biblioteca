package com.kauabiscotto.bibliotecproject;


public abstract class Pessoa {

    private String nome;
    private int idade;
    private int id;
    private String tipo;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
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

    public String getTipo() {
        return tipo;
    }

    public abstract void exibirPerfil();
}
