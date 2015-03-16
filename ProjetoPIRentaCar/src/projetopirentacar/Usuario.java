/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopirentacar;

/**
 *
 * @author pc
 */
public class Usuario {
    private String nome;
    private String rg;
    private String cpf;
    private String login;
    private String senha;
    private String cargo;
    private String filial;
    
    public void cadastrarCliente(){
        
    }
    public void cadastrarVenda(){
        
    }
    public void receberPagamento(){
        
    }
    public void receberRelatorioFilial(){
        if(cargo.equalsIgnoreCase("atendente")){
            System.out.println("Acesso Restrito");
        }
    }
}
