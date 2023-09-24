import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Sub_Admin_Campus extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sub_Admin_Campus frame = new Sub_Admin_Campus();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect=null;
	/**
	 * Create the frame.
	 */
	public Sub_Admin_Campus() {
		
		setTitle("SUB ADMIN OF CAMPUS");
		connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewTable = new JButton("VIEW TABLE");
		btnViewTable.setBackground(Color.PINK);
		btnViewTable.setForeground(new Color(0, 0, 0));
		btnViewTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from COMPLAINT where (COMP_TYPE='LIBRARY' OR COMP_TYPE='CAMPUS CLEANING' OR COMP_TYPE='CANTEEN' OR COMP_TYPE='CAMPUS MAINTENANCE' OR COMP_TYPE='CAMPUS ELECTRICAL OR COMP_TYPE='OTHER IN CAMPUS'')";
					PreparedStatement pst = connect.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		btnViewTable.setBounds(280, 94, 210, 33);
		btnViewTable.setFont(new Font("Cambria", Font.BOLD, 16));
		contentPane.add(btnViewTable);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateStatus stat = new UpdateStatus();
				dispose();
				stat.setVisible(true);
			}
		});
		btnUpdate.setBounds(280, 30, 210, 33);
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 16));
		contentPane.add(btnUpdate);
		
		JButton btnMessageFromAdmin = new JButton("MESSAGE FROM ADMIN");
		btnMessageFromAdmin.setBackground(Color.PINK);
		btnMessageFromAdmin.setForeground(new Color(0, 0, 0));
		btnMessageFromAdmin.setBounds(552, 31, 210, 32);
		btnMessageFromAdmin.setFont(new Font("Cambria", Font.BOLD, 16));
		btnMessageFromAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from MSG_TO_SUBADMIN where SUBADMIN='CAMPUS-SUBADMIN'";
					PreparedStatement pst = connect.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		contentPane.add(btnMessageFromAdmin);
		
		JButton btnLogOut = new JButton("LOGOUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			dispose();
			
			}
		});
		btnLogOut.setBackground(Color.PINK);
		btnLogOut.setForeground(new Color(0, 0, 0));
		btnLogOut.setBounds(552, 94, 210, 33);
		btnLogOut.setFont(new Font("Cambria", Font.BOLD, 16));
		contentPane.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 752, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(20, -69, 774, 519);
		contentPane.add(label);
	}
}
