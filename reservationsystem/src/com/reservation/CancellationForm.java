package com.reservation;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class CancellationForm {

	public static void showCancellationForm() {
        JFrame frame = new JFrame("Cancellation");
        JLabel l1 = new JLabel("PNR Number:");
        JTextField t1 = new JTextField();
        JButton b1 = new JButton("Cancel");

        l1.setBounds(30, 50, 100, 30);
        t1.setBounds(140, 50, 150, 30);
        b1.setBounds(140, 100, 100, 30);

        frame.add(l1);
        frame.add(t1);
        frame.add(b1);

        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = DatabaseConnection.connect();
                    String query = "DELETE FROM reservations WHERE reservation_id = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setInt(1, Integer.parseInt(t1.getText()));

                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Cancellation Successful");
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });
    }
}
