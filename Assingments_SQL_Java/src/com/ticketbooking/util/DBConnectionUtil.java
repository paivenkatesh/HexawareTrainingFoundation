package com.ticketbooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/ticket_booking_system";
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "Venkatesh#12";  // Replace with your MySQL password

    // Method to establish connection
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
            throw new SQLException("Unable to establish connection", e);
        }
        return conn;
    }
}
