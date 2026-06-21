package org.CaixaRapido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CaixaRapidoDAO {

    private final Connection connection;

    private final String URL = "jdbc:postgresql:5432/supermerk2";
    private final String USER = "ta_pegandofogo";
    private final String PASSWORD = "3142"; 

    private long id = 0; // barcode
    private String name = "";
    private String description = "";
    private float price = 0;
    private long quantity = 0;

    public CaixaRapidoDAO() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);            
        } catch (SQLException error) {
            throw new RuntimeException("Failed to connect to database", error);
        }
    }

    public void create(long id, String name, String description, float price, long quantity) {
        try {

            var statement = connection.prepareStatement(
                "INSERT INTO product (id, name, description, price, quantity) " +
                "VALUES (?, ?, ?, ?, ?)" 
            );

            statement.setLong(1, id);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setFloat(4, price);
            statement.setLong(5, quantity);

            boolean success = statement.execute();

            if (!success) {
                System.out.println("Failure: 0 rows updated");
            }

        } catch(SQLException e) {
            System.err.println(e);
        }
    }

    public void insert(long id, long quantity) {
        try {
            
            var statement = connection.prepareStatement(
                "INSERT INTO product (id, quantity) " +
                "VALUES (?, ?)" 
            );

            statement.setLong(1, id);            
            statement.setLong(2, quantity);

            boolean success = statement.execute();

            if (!success) {
                System.out.println("Failure: 0 rows updated");
            }

        } catch(SQLException e) {
            System.err.println(e);
        }
    }
}
