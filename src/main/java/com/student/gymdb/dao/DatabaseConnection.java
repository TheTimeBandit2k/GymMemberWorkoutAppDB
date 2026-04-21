package com.student.gymdb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Database connection variables
    // Adjust as needed if running on your own machine
    private static final String URL = "jdbc:mysql://localhost:3306/GymMemberDB";
    private static final String USER = "root";
    private static final String PASSWD = "JewelGote@2021";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWD);
    }
}
