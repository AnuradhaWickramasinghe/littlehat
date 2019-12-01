package com.mit.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    public Connection connectDB() {


        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

           // Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

           // connection = DriverManager.getConnection("jdbc:mysql:thin:@3.224.174.65:3306:sgxp2db", "temptest6", "temptest6");
            connection = DriverManager.getConnection("jdbc:mysql://3.224.174.65:3306/sgxp2db", "temptest6", "temptest6");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

}