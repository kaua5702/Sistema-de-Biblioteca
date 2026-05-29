package com.kauabiscotto.bibliotecproject.dao;

import com.kauabiscotto.bibliotecproject.Livro;
import com.kauabiscotto.bibliotecproject.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    //Insert, Select e Update

    public void inserir(Livro livro) throws Exception{

        String sql = "INSERT INTO livros(titulo, autor, ano, emprestado) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getAno());
            pstmt.setBoolean(4, livro.isEmprestado());

            pstmt.execute();
            System.out.println("Livro inserido com sucesso!");

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

    public void atualizar(Livro livro) throws Exception{

        String sql = "UPDATE livros set titulo = ?, autor = ?, ano = ?, emprestado = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getAno());
            pstmt.setBoolean(4, livro.isEmprestado());
            pstmt.setInt(5, livro.getId());

            pstmt.execute();
            System.out.println("Livro atualizado com sucesso!");

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

    public Livro buscarPorTitulo(String titulo) {

        String sql = "SELECT * FROM livros WHERE titulo = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, titulo);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                Livro livro = new Livro(
                        rset.getInt("id"),
                        rset.getString("titulo"),
                        rset.getString("autor"),
                        rset.getInt("ano")
                );
                if (rset.getBoolean("emprestado")) {
                    livro.emprestar();
                }
                return livro;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rset != null) rset.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Livro> listarTodos() {

        String sql = "SELECT * FROM livros WHERE emprestado = false";

        List<Livro> livros = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Livro livro = new Livro(
                        rset.getInt("id"),
                        rset.getString("titulo"),
                        rset.getString("autor"),
                        rset.getInt("ano")
                );
                if (rset.getBoolean("emprestado")) {
                    livros.add(livro);
                }
                livros.add(livro);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {

                if (rset != null) {
                    rset.close();
                }

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
        return livros;
    }

}
