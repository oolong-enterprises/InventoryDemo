package com.oolong.java3mtp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
* Sets the Database connection for entire program
* The connection can be statically accessed throughout the program from getConnection()
 */
public class DbConnector {

    //DB credentials
    private static final String ADDRESS = "jdbc:mysql://localhost:3306/java3mtp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password";

    private static Connection connection;

    public DbConnector() {
        connectDatabase();
    }

    public static Connection getConnection() {
        //reconnects to DB if it loses connection for some reason
        if (connection == null) {
            connectDatabase();
            System.out.println("Connection established");
        }
        return connection;
    }

    private static void connectDatabase() {
        //if DB connection fails will not crash GUI
        try {
            connection = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to DB " + e.getMessage());//log in console
        }
    }
}
