package com.kauabiscotto.bibliotecproject;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao;
        do {
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Livros Disponíveis");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    Aluno aluno = new Aluno(nome, idade);
                    biblioteca.adiconarPessoa(aluno);
                    break;

                case 2:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano do livro: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    Livro livro = new Livro(titulo, autor, ano);
                    biblioteca.adicionarLivro(livro);
                    System.out.println("📚 Livro cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o nome da pessoa: ");
                    String nomePessoaEmprestimo = scanner.nextLine();
                    Pessoa pessoaEmprestimo = biblioteca.buscarPessoaPorNome(nomePessoaEmprestimo);

                    if (pessoaEmprestimo == null) {
                        System.out.println("⚠️ Pessoa não encontrada.");
                        break;
                    }

                    System.out.print("Digite o título do livro a emprestar: ");
                    String tituloEmprestar = scanner.nextLine();
                    Livro livroEmprestar = biblioteca.buscarLivroPorTitulo(tituloEmprestar);

                    if (livroEmprestar != null) {
                        biblioteca.emprestarLivro(pessoaEmprestimo, livroEmprestar);
                    } else {
                        System.out.println("⚠️ Livro não encontrado.");
                    }
                    break;


                case 4:
                    System.out.print("Digite o nome da pessoa: ");
                    String nomePessoaDevolucao = scanner.nextLine();
                    Pessoa pessoaDevolucao = biblioteca.buscarPessoaPorNome(nomePessoaDevolucao);

                    if (pessoaDevolucao == null) {
                        System.out.println("⚠️ Pessoa não encontrada.");
                        break;
                    }

                    System.out.print("Digite o título do livro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    Livro livroDevolver = biblioteca.buscarLivroPorTitulo(tituloDevolver);

                    if (livroDevolver != null) {
                        biblioteca.devolverLivro(pessoaDevolucao, livroDevolver);
                    } else {
                        System.out.println("⚠️ Livro não encontrado.");
                    }
                    break;



                case 5:
                    biblioteca.listarLivros();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("⚠️ Opção inválida!");
            }



        } while (opcao != 0);
        scanner.close();
    }
}
