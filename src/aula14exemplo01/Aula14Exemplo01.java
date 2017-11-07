/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula14exemplo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 11944413600
 */
public class Aula14Exemplo01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            System.out.println("Driver carregado com sucesso");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aula14Exemplo01.class.getName()).log(Level.SEVERE,"Driver não encontrado",ex);
            Logger.getLogger(Aula14Exemplo01.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        
        String driverURL = "jdbc:derby://localhost:1527/2017DCC171";
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(driverURL,"usuario","senha");
            System.out.println("Conexão aberta com sucesso.");
        } catch (SQLException ex) {
            System.out.println("Error ao abrir a conexão");
            Logger.getLogger(Aula14Exemplo01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Statement operacao;
        try {
            operacao = conexao.createStatement();
//            operacao.executeUpdate("CREATE TABLE produto("
//                    +"nome VARCHAR(80),"
//                    + "qtd INTEGER,"
//                    + "atualizado TIMESTAMP"+ ")");
            Random rnd = new Random();
            String nome = "Mercadoria "+rnd.nextInt(100);
            Integer qtd = 10+rnd.nextInt(20);
            operacao.executeUpdate("INSERT INTO produto VALUES('"
                    +nome+ "',"
                    +qtd+ ", CURRENT_TIMESTAMP)"
            );
        } catch (SQLException ex) {
            Logger.getLogger(Aula14Exemplo01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
