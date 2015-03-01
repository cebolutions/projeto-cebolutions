

package br.senac.tads.pi3.ex01;

import java.sql.Connection;
import br.senac.tads.pi3.comum.ConexaoBDJavaDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Projeto Integrador III
 * TADS - 3 sem
 * Aula
 * Objetivo desta classe:
 * Iniciar o programa e chamar as outras classes do projeto
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
public class Exercicio01 {

    public static void main(String[] args) {
        System.out.println("Tabela Clientes");
        ImprimirDadosBD print = new ImprimirDadosBD();
        print.imprimirDadosBD();
        System.out.println("NOVO CADASTRO");
        CadastrarCliente novo = new CadastrarCliente();
        novo.inserirClienteBD();
        System.out.println("Item cadastro...");
        print.imprimirDadosBD();
        

    }
    
}
