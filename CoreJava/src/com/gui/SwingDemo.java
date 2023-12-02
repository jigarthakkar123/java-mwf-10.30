package com.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SwingDemo implements ActionListener {

	JFrame f;
	JLabel l1, l2, l3, l4, l5;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2, b3, b4, b5;
	JTable jt1;
	public SwingDemo() {
		f = new JFrame("My Swing Example");
		f.setVisible(true);
		f.setSize(700, 490);
		//f.setResizable(false);
		// f.setLayout(new FlowLayout());
		// f.setLayout(new GridLayout(7, 2));
		f.setLayout(null);

		/*
		 * l1 = new JLabel("ID"); l2 = new JLabel("FIRST NAME"); l3 = new
		 * JLabel("LAST NAME"); l4 = new JLabel("EMAIL"); l5 = new JLabel("MOBILE");
		 * 
		 * t1 = new JTextField(20); t2 = new JTextField(20); t3 = new JTextField(20); t4
		 * = new JTextField(20); t5 = new JTextField(20);
		 * 
		 * b1 = new JButton("INSERT"); b2 = new JButton("SEARCH"); b3 = new
		 * JButton("UPDATE"); b4 = new JButton("DELETE"); b5 = new JButton("CLEAR");
		 * 
		 * f.add(l1); f.add(t1); f.add(l2); f.add(t2); f.add(l3); f.add(t3); f.add(l4);
		 * f.add(t4); f.add(l5); f.add(t5); f.add(b1); f.add(b2); f.add(b3); f.add(b4);
		 * f.add(b5);
		 * 
		 * l1.setBounds(50, 50, 100, 20); l2.setBounds(50, 100, 100, 20);
		 * l3.setBounds(50, 150, 100, 20); l4.setBounds(50, 200, 100, 20);
		 * l5.setBounds(50, 250, 100, 20);
		 * 
		 * t1.setBounds(150, 50, 150, 20); t2.setBounds(150, 100, 150, 20);
		 * t3.setBounds(150, 150, 150, 20); t4.setBounds(150, 200, 150, 20);
		 * t5.setBounds(150, 250, 150, 20);
		 * 
		 * b1.setBounds(50, 300, 120, 20); b2.setBounds(180, 300, 120, 20);
		 * b3.setBounds(50, 350, 120, 20); b4.setBounds(180, 350, 120, 20);
		 * b5.setBounds(90, 400, 190, 20);
		 * 
		 * b1.addActionListener(this); b2.addActionListener(this);
		 * b3.addActionListener(this); b4.addActionListener(this);
		 * b5.addActionListener(this);
		 */

		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };
		JTable jt = new JTable(data, column);
		jt.setBounds(30,40,200,300);
		JScrollPane sp = new JScrollPane(jt);
		f.add(sp);
	}

	public static void main(String[] args) {
		new SwingDemo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres",
						"tops");
				String sql = "insert into emp(id,fname,lname,email,mobile) values(?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setLong(1, Long.parseLong(t1.getText()));
				pst.setString(2, t2.getText());
				pst.setString(3, t3.getText());
				pst.setString(4, t4.getText());
				pst.setLong(5, Long.parseLong(t5.getText()));
				pst.executeUpdate();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				JOptionPane.showMessageDialog(f, "Data Inserted Successfully");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == b2) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres",
						"tops");
				String sql = "select * from emp where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(t1.getText()));
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					t2.setText(rs.getString("fname"));
					t3.setText(rs.getString("lname"));
					t4.setText(rs.getString("email"));
					t5.setText(rs.getString("mobile"));
					/*
					 * System.out.println(rs.getString("fname"));
					 * System.out.println(rs.getString("lname"));
					 * System.out.println(rs.getString("email"));
					 * System.out.println(rs.getString("mobile"));
					 */
				}

				else {
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					JOptionPane.showMessageDialog(f, "Id Not Found");
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == b3) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres",
						"tops");
				String sql = "update emp set mobile=? where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);

				pst.setInt(2, Integer.parseInt(t1.getText()));
				pst.setLong(1, Long.parseLong(t5.getText()));
				pst.executeUpdate();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				JOptionPane.showMessageDialog(f, "Data Updated Successfully");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == b4) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres",
						"tops");
				String sql = "delete from emp where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(t1.getText()));
				pst.executeUpdate();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				JOptionPane.showMessageDialog(f, "Data Deleted Successfully");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == b5) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		}
	}
}
