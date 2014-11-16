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
import java.sql.Statement;

/**
 *
 * @author pc
 */
public class testeRel {

    static Scanner sc = new Scanner(System.in);
    static Connection conn;
    static Statement stmt;
    static CallableStatement cs = null;
    static String[][] total = new String[10][6];

    public static void main(String[] args) {

        iniciarConexao();
        relatorio();
        encerraConexao();
        System.out.println("--------------------------------------------");
        GrauSatisfacao sat = new GrauSatisfacao();
        sat.iniciarConexao();
        sat.satisfacao();
        sat.encerraConexao();
        String respo[] = sat.getSatisfacao();
        Perguntas per = new Perguntas();
        per.iniciarConexao();
        per.perguntas();
        per.encerraConexao();
        for (int j = 0; j < 10; j++) {
            total[j][0] = per.getPergunta(j);
            System.out.println(per.getPergunta(j));
        }
        iniciarConexao();
        relatorio2();
        encerraConexao();

        for (int j = 0; j < 10; j++) {
            System.out.println(total[j][0]);
            for (int k = 0; k < 5; k++) {
                System.out.println(respo[k] + " -> " + total[j][k + 1]);
            }
            System.out.println(" ");
        }

    }
    
    

    public static void relatorio() {
        try {

            stmt = conn.createStatement();
            ResultSet perg = stmt.executeQuery("SELECT nomeAluno, descricao, descricaoSatisfacao FROM "
                    + "tblrelacaosatisfacaoperguntas\n"
                    + "JOIN tblSatisfacao\n"
                    + "ON satisfacaoId = idsatisfacao\n"
                    + "JOIN tblPerguntas\n"
                    + "ON idPergunta = perguntaId\n"
                    + "JOIN tblAluno\n"
                    + "ON idAluno = alunoId\n"
                    + "order by nomeAluno");

            while (perg.next()) {
                String nome = perg.getString("nomeAluno");
                String pergunta = perg.getString("descricao");
                String resposta = perg.getString("descricaoSatisfacao");
                System.out.println(nome + " | " + pergunta + " | " + resposta);
            }

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void populaVetor(int perg, int resp, String satis) {
        total[perg][resp] = satis;
    }

    public static void relatorio2() {
        try {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 5; k++) {

                    stmt = conn.createStatement();
                    ResultSet perg = stmt.executeQuery("select count(1) total \n"
                            + "from tblRelacaoSatisfacaoPerguntas as rel\n"
                            + " where \n"
                            + "rel.satisfacaoId = " + k + " and rel.perguntaId = " + j);

                    while (perg.next()) {
                        String tot = perg.getString("total");
                        populaVetor(j - 1, k, tot);
                    }
                }

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
