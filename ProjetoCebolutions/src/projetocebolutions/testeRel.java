/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class testeRel {

    static Scanner sc = new Scanner(System.in);
    static Connection conn;
    static Statement stmt;
    static CallableStatement cs = null;

    public static void main(String[] args) {
        iniciarConexao();
        relatorio();
        encerraConexao();
    }
     public static void relatorio(){
        try {

            stmt = conn.createStatement();
            ResultSet perg = stmt.executeQuery("SELECT nomeAluno, descricao, descricaoSatisfacao FROM "
                    + "tblrelacaosatisfacaoperguntas\n" +
                    "JOIN tblSatisfacao\n" +
                    "ON satisfacaoId = idsatisfacao\n" +
                    "JOIN tblPerguntas\n" +
                    "ON idPergunta = perguntaId\n" +
                    "JOIN tblAluno\n" +
                    "ON idAluno = alunoId\n" +
                    "order by nomeAluno");

            while (perg.next()) {
                String nome = perg.getString("nomeAluno");
                String pergunta = perg.getString("descricao");
                String resposta = perg.getString("descricaoSatisfacao");
                System.out.println(nome+" | " +pergunta+ " | "+ resposta);
            }

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iniciarConexao() {
        Conexao conexao = new Conexao();
        try {
            conn = conexao.getConexao();
            stmt = conn.createStatement();
            System.out.println("Conexão Realizada com sucesso");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void encerraConexao() {
        Conexao conexao = new Conexao();
        try {
            conn.close();
            stmt.close();
            System.out.println("Goodbye");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
