package com.reservation;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm {

	 public static void main(String[] args) {
	        JFrame frame = new JFrame("Login");
	        JLabel l1 = new JLabel("Username:");
	        JLabel l2 = new JLabel("Password:");
	        JTextField t1 = new JTextField();
	        JPasswordField t2 = new JPasswordField();
	        JButton b1 = new JButton("Login");

	        l1.setBounds(30, 50, 100, 30);
	        t1.setBounds(140, 50, 150, 30);
	        l2.setBounds(30, 100, 100, 30);
	        t2.setBounds(140, 100, 150, 30);
	        b1.setBounds(140, 150, 100, 30);

	        frame.add(l1);
	        frame.add(t1);
	        frame.add(l2);
	        frame.add(t2);
	        frame.add(b1);

	        frame.setSize(400, 300);
	        frame.setLayout(null);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        b1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String username = t1.getText();
	                String password = String.valueOf(t2.getPassword());

	                try {
	                    Connection conn = DatabaseConnection.connect();
	                    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
	                    PreparedStatement stmt = conn.prepareStatement(query);
	                    stmt.setString(1, username);
	                    stmt.setString(2, password);

	                    ResultSet rs = stmt.executeQuery();
	                    if (rs.next()) {
	                        JOptionPane.showMessageDialog(frame, "Login Successful");
	                        frame.dispose();
	                        ReservationForm.showReservationForm(rs.getInt("user_id"));
	                    } else {
	                        JOptionPane.showMessageDialog(frame, "Invalid Credentials");
	                    }
	                } catch (Exception ex) {
	                    System.out.println("Error: " + ex.getMessage());
	                }
	            }
	        });
	    }
}
