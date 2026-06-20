package org.CaixaRapido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CaixaRapidoDAO {

    private final Connection connection;

    private final String URL = "jdbc:postgresql:5432/supermerk2";
    private final String USER = "ta_pegandofogo";
    private final String PASSWORD = "3142"; 

    private long id = 0;
    private String name = "";
    private String description = "";
    private float price = 0;

    public CaixaRapidoDAO() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);            
        } catch (SQLException error) {
            throw new RuntimeException("Failed to connect to database", error);
        }
    }

    public void create(long id, String name, String description, float price) {
        try {
            var statement = connection.createStatement(
                "INSERT INTO product (id, name, description, price) " +
                "VALUES (?, ?, ?, ?)" 
            );
        }
    }
}
