package com.kauabiscotto.bibliotecproject.dao;

import com.kauabiscotto.bibliotecproject.Livro;
import com.kauabiscotto.bibliotecproject.Pessoa;
import com.kauabiscotto.bibliotecproject.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmprestimoDAO {

    //inserir e atualizar

    public void registrarEmprestimo(Pessoa pessoa, Livro livro) {

        String sql = "INSERT INTO emprestimos(pessoa_id, livro_id, data_emprestimo) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, pessoa.getId());
            pstmt.setInt(2, livro.getId());
            pstmt.setDate(3, Date.valueOf(LocalDate.now()));

            pstmt.execute();
            System.out.println("Emprestimo registrado com sucesso");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void registrarDevolucao(Livro livro) {

        String sql = "UPDATE emprestimos SET data_devolucao = ? WHERE livro_id = ? and data_devolucao IS NULL";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, Date.valueOf(LocalDate.now()));
            pstmt.setInt(2, livro.getId());

            pstmt.execute();
            System.out.println("Devoulucao registrada com sucesso");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
