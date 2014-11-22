/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocebolutions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Relatorios {

    private Scanner sc = new Scanner(System.in);
    private Connection conn;
    private Statement stmt;
    private CallableStatement cs = null;
    private int[][] total = new int[10][6];
    private String[] perg = new String[10];
    private String[][] nomePergResp = new String[1000][3];
    private int matriz = 0;

    public Relatorios() {

        iniciarConexao();
        selectGeral();
        selectPergResp();
        encerraConexao();
    
    }
    public void relatorioPorPerg(){
        GrauSatisfacao sat = new GrauSatisfacao();
        sat.iniciarConexao();
        sat.satisfacao();
        sat.encerraConexao();
        String respo[] = sat.getSatisfacao();
        Perguntas per = new Perguntas();
        per.iniciarConexao();
        per.perguntas();
        perg = per.getPerguntas();
        per.encerraConexao();
        for (int j = 0; j < 10; j++) {
            total[j][0] = j + 1;
        }

        for (int j = 0; j < 10; j++) {
            System.out.println(perg[j]);
            for (int k = 0; k < 5; k++) {
                System.out.println(respo[k] + " -> " + total[j][k + 1]);
            }
            System.out.println(" ");
        }
    }
    public void relatorioGeral(){
        for (int i = 0; i < matriz; i++) {

            if (nomePergResp[i] != null) {
                System.out.println("Aluno: " + nomePergResp[i][0]);
                System.out.println("Pergunta: " + nomePergResp[i][1]);
                System.out.println("Resposta: " + nomePergResp[i][2]);
            }
            System.out.println("");

        }
    }
    public void relatorioIndicadores(){
         float[] totalporPeso = new float[1000];
        int contador = 0;
        for (int j = 0; j < total.length; j++) {
            switch (j) {
                case 0:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 20f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 15f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 1:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 7.5f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 2:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 7.5f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 3:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 7.5f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 4:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 7.5f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 5:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 3.75f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 1.25f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0);
                        contador++;
                    }
                    break;
                case 6:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 7.5f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 7:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 3.75f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 1.25f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 8:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 7.5f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
                case 9:
                    if (total[j][1] != 0) {
                        totalporPeso[contador] = (total[j][1] * 10f);
                        contador++;
                        break;
                    } else if (total[j][2] != 0) {
                        totalporPeso[contador] = (total[j][1] * 7.5f);
                        contador++;
                        break;
                    } else if (total[j][3] != 0) {
                        totalporPeso[contador] = (total[j][1] * 5f);
                        contador++;
                        break;
                    } else if (total[j][4] != 0) {
                        totalporPeso[contador] = (total[j][1] * 2.5f);
                        contador++;
                        break;
                    } else if (total[j][5] != 0) {
                        totalporPeso[contador] = (total[j][1] * 0f);
                        contador++;
                    }
                    break;
            }
        }
        int total = 0;
        for (int i = 0; i < totalporPeso.length; i++) {
            total += totalporPeso[i];
        }
        
        System.out.println("Indice de satisfação: " + (total / (matriz / 10)));
        
        if((total / (matriz / 10)) >= 80) {
            System.out.println("Indice de satisfação bom!\n A maioria dos alunos estão satisfeitos,"
                    + "porém ainda há certos pontos para ser melhorado.");
        } else if((total / (matriz / 10)) >= 40 && (total / (matriz / 10)) < 80) {
            System.out.println("Indice de satisfação regular!\n Apenas uma parte dos alunos estão satisfeitos."
                    + "Procure soluções para melhorar o indice de satisfação.");
        } else if((total / (matriz / 10)) < 40) {
            System.out.println("Indice de satisfação ruim!\n A maior parte dos alunos não estão satisfeitos,"
                    + "procure saber o que há de errado para ser melhorado.");
        }

    }
    public void selectGeral() {
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
                populaMatrizAlunoPergResp(nome, pergunta, resposta);
            }

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populaVetor(int perg, int resp, int satis) {
        total[perg][resp] = satis;
    }

    public void populaMatrizAlunoPergResp(String aluno, String pergunta, String resposta) {
        nomePergResp[matriz][0] = aluno;
        nomePergResp[matriz][1] = pergunta;
        nomePergResp[matriz][2] = resposta;
        matriz++;
    }

    
    public void selectPergResp() {
        try {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 5; k++) {

                    stmt = conn.createStatement();
                    ResultSet perg = stmt.executeQuery("select count(1) total \n"
                            + "from tblRelacaoSatisfacaoPerguntas as rel\n"
                            + " where \n"
                            + "rel.satisfacaoId = " + k + " and rel.perguntaId = " + j);

                    while (perg.next()) {
                        int tot = perg.getInt("total");
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

    public void iniciarConexao() {
        Conexao conexao = new Conexao();
        try {
            conn = conexao.getConexao();
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void encerraConexao() {
        Conexao conexao = new Conexao();
        try {
            conn.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
