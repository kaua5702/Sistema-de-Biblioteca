package com.kauabiscotto.bibliotecproject;

public class Livro {

    private String titulo;
    private String autor;
    private int ano;
    private boolean emprestado = false;

    public Livro(String titulo, String autor, int ano) {

        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;

    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        emprestado = true;
    }

    public void devolver() {
        emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

}