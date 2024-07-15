package com.example.table.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            String url = "jdbc:mysql://127.0.0.1/company";
            String usename = "root";
            String password = "Mayada152001@40";

            try {
                connection = DriverManager.getConnection(url, usename, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        return connection;

    }


}
