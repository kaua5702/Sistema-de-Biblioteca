package com.kauabiscotto.bibliotecproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();

    public void adiconarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println("Usuário unserido com sucesso!");
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(Pessoa pessoa, Livro livro) {
        if (livro.isEmprestado() == false) {
            livro.emprestar();
            System.out.println("Livro emprestado com sucesso!");

        } else {
            System.out.println("O livro não está disponível");
        }
    }

    public void devolverLivro(Pessoa pessoa, Livro livro) {
        if (livro.isEmprestado() == true) {
            livro.devolver();
            System.out.println("Livro devolvido com sucesso!");

        } else {
            System.out.println("Este livro não foi emprestado!");
        }

    }

    public void listarLivros() {
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (!livro.isEmprestado()) {
                System.out.println("Título: " + livro.getTitulo() +
                        ", Autor: " + livro.getAutor() +
                        ", Ano: " + livro.getAno());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }
        return null;
    }

    public Pessoa buscarPessoaPorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }


}
