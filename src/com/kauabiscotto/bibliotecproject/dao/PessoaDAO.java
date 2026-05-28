package com.kauabiscotto.bibliotecproject.dao;

import com.kauabiscotto.bibliotecproject.Aluno;
import com.kauabiscotto.bibliotecproject.Pessoa;
import com.kauabiscotto.bibliotecproject.Professor;
import com.kauabiscotto.bibliotecproject.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    //insert, select

    public void adicionar(Pessoa pessoa) throws Exception {

        String sql = "INSERT INTO pessoas(nome, idade, tipo, disciplina) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());

            if (pessoa instanceof Professor professor) {
                pstmt.setString(3, "PROFESSOR");
                pstmt.setString(4, professor.getDisciplina());
            } else {
                pstmt.setString(3, "ALUNO");
                pstmt.setNull(4, Types.VARCHAR);
            }

            pstmt.execute();
            System.out.println("Registro adicionado com sucesso!");

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

    public List<Pessoa> selecionarTudo() {

        String sql = "SELECT * FROM pessoas";

        List<Pessoa> pessoas = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                String tipo = rset.getString("tipo");
                Pessoa pessoa;

                if (tipo.equals("PROFESSOR")) {
                    pessoa = new Professor(
                            rset.getInt("id"),
                            rset.getString("nome"),
                            rset.getInt("idade"),
                            rset.getString("disciplina")
                    );
                } else  {
                    pessoa = new Aluno(
                            rset.getInt("id"),
                            rset.getString("nome"),
                            rset.getInt("idade")
                    );
                }

                pessoas.add(pessoa);
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
        return pessoas;
    }
}
