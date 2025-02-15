package com.reservation;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ReservationForm {

	public static void showReservationForm(int userId) {
        JFrame frame = new JFrame("Reservation");
        JLabel l1 = new JLabel("Train Number:");
        JLabel l2 = new JLabel("Train Name:");
        JLabel l3 = new JLabel("Class:");
        JLabel l4 = new JLabel("Date of Journey:");
        JLabel l5 = new JLabel("From:");
        JLabel l6 = new JLabel("To:");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JComboBox<String> cb = new JComboBox<>(new String[] { "First Class", "Second Class", "Sleeper" });
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();

        JButton b1 = new JButton("Book");

        l1.setBounds(30, 50, 100, 30);
        t1.setBounds(140, 50, 150, 30);
        l2.setBounds(30, 100, 100, 30);
        t2.setBounds(140, 100, 150, 30);
        l3.setBounds(30, 150, 100, 30);
        cb.setBounds(140, 150, 150, 30);
        l4.setBounds(30, 200, 100, 30);
        t4.setBounds(140, 200, 150, 30);
        l5.setBounds(30, 250, 100, 30);
        t5.setBounds(140, 250, 150, 30);
        l6.setBounds(30, 300, 100, 30);
        t6.setBounds(140, 300, 150, 30);
        b1.setBounds(140, 350, 100, 30);

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(cb);
        frame.add(l4);
        frame.add(t4);
        frame.add(l5);
        frame.add(t5);
        frame.add(l6);
        frame.add(t6);
        frame.add(b1);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DatabaseConnection.connect();
                    String query = "INSERT INTO reservations (user_id, train_number, train_name, class_type, journey_date, origin, destination) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setInt(1, userId);
                    stmt.setInt(2, Integer.parseInt(t1.getText()));
                    stmt.setString(3, t2.getText());
                    stmt.setString(4, cb.getSelectedItem().toString());
                    stmt.setString(5, t4.getText());
                    stmt.setString(6, t5.getText());
                    stmt.setString(7, t6.getText());

                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Reservation Successful");
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });
    }
}
