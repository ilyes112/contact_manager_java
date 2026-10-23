package com.example.contactmanager.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/contact_managerDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");;

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}