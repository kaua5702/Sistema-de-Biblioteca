package com.kauabiscotto.bibliotecproject;

import com.kauabiscotto.bibliotecproject.dao.EmprestimoDAO;
import com.kauabiscotto.bibliotecproject.dao.LivroDAO;
import com.kauabiscotto.bibliotecproject.dao.PessoaDAO;

import java.util.List;

public class Biblioteca {

    private LivroDAO livroDAO = new LivroDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

    public void adiconarPessoa(Pessoa pessoa) throws Exception {
        pessoaDAO.adicionar(pessoa);
    }

    public void adicionarLivro(Livro livro) throws Exception {
        livroDAO.inserir(livro);
    }

    public void emprestarLivro(Pessoa pessoa, Livro livro) throws Exception {
        if (!livro.isEmprestado()) {
            livro.emprestar();
            livroDAO.atualizar(livro);
            emprestimoDAO.registrarEmprestimo(pessoa, livro);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("O livro não está disponível.");
        }
    }

    public void devolverLivro(Pessoa pessoa, Livro livro) throws Exception {
        if (livro.isEmprestado()) {
            livro.devolver();
            livroDAO.atualizar(livro);
            emprestimoDAO.registrarDevolucao(livro);
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Este livro não foi emprestado!");
        }
    }

    public void listarLivros() throws Exception {
        List<Livro> livros = livroDAO.listarTodos();
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

    public Livro buscarLivroPorTitulo(String titulo) throws Exception {
        List<Livro> livros = livroDAO.listarTodos();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Pessoa buscarPessoaPorNome(String nome) throws Exception {
        List<Pessoa> pessoas = pessoaDAO.selecionarTudo();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }
}