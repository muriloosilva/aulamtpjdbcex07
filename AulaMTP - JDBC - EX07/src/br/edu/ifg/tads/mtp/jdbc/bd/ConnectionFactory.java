package br.edu.ifg.tads.mtp.jdbc.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
            		"jdbc:postgresql://localhost:5432/bdteste", "postgres", "123");
        } catch (Exception e) {
            throw new RuntimeException("falha ao tentar acessar o BD. Verifique sua conexão");
        }
    }
}
