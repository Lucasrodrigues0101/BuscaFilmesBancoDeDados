package br.com.FilmesBanco.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("************"); // registra o driver
        java.sql.Connection conn = DriverManager.getConnection("***********",
                "*******","*******");
        return conn;
    }
}
