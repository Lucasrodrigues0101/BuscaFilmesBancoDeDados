package br.com.FilmesBanco.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager
                    .getConnection("**********************","*********","*********");
            System.out.println("Conectado com sucesso !");
            connection.close();
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Não foi possível realizar essa ação");
        }
    }
}
