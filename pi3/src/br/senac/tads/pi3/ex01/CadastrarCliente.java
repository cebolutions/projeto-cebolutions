/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ex01;

import br.senac.tads.pi3.comum.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Projeto Integrador III
 * TADS - 3 sem
 * Aula
 * Objetivo desta classe:
 * Abrir o BD e inserir novo cliente baseado nos dados do usuário e fechar BD
 * 
 * Objetivo do Exercício
 * Inclusão na tabela TB_PESSOAS. Basear o código a ser desenvolvido no exemplo 
 * de consulta desenvolvido em sala e no código apresentado no inicio da aula do 
 * dia 26/02, e usar o projeto ConexaoBD disponibilizado no Blackboard.
 * 
 * @author Ygor Yuri P Pessoa
 * @version 1.0
 * @since 01/03/2015
 */
public class CadastrarCliente {

    /**
     * Método para inclusão de dados no BD utilizando PreparedStatement
     */
    public void inserirClienteBD() {
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("AGENDADB");
        Connection conn = null;
        PreparedStatement pstmt = null;

        Scanner in = new Scanner(System.in);

        System.out.println("Informe os dados.");
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("Data Nascimento(aaaa-mm-dd): ");
        String dtNasc = in.nextLine();
        System.out.print("Telefone: ");
        String telefone = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        
        try {
            conn = conexao.obterConexao();
            String comandoSQL = "INSERT INTO TB_PESSOAS"
                    + "(NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL) "
                    + "VALUES (?,?,?,?)";

            pstmt = conn.prepareStatement(comandoSQL);

            pstmt.setString(1, nome);
            pstmt.setString(2, dtNasc);
            pstmt.setString(3, telefone);
            pstmt.setString(4, email);

            pstmt.execute();

            System.out.println("Cadastro inserido com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
