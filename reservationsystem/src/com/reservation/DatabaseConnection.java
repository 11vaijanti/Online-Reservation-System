package com.reservation;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
public static void main(String []args) {
	public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/reservation_system";
            String user = "root"; // Replace with your DB username
            String password = "localhost:3306"; // Replace with your DB password
            conn = DriverManager.getConnection("\jdbc:mysql://localhost:3306/unisoft\","root", "localhost:3306");
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }
        return conn;
    }
}
