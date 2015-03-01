/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ex01;
import br.senac.tads.pi3.comum.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Projeto Integrador III
 * TADS - 3 sem
 * Aula
 * Objetivo desta classe:
 * Abrir o BD e obter os dados dos clientes e fechar BD
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
public class ImprimirDadosBD {
     /**
     * Metodo para Imprimir dados do BD baseado no comando Select
     */
    public void imprimirDadosBD() {
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("AGENDADB");
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = conexao.obterConexao();
            String comandoSQL = "SELECT ID_PESSOA, NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL FROM TB_PESSOAS";

            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(comandoSQL);

            while (resultados.next()) {
                long id = resultados.getLong("ID_PESSOA");
                String nm = resultados.getString("NM_PESSOA");
                Date dtNasc = resultados.getDate("DT_NASCIMENTO");
                String tel = resultados.getString("VL_TELEFONE");
                String email = resultados.getString("VL_EMAIL");

                System.out.println(id + ", " + nm + ", " + dtNasc + ", " + tel + ", " + email);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Exercicio01.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
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
