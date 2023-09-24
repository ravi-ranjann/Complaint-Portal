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


public class Sub_Admin_Hostel extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sub_Admin_Hostel frame = new Sub_Admin_Hostel();
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
	public Sub_Admin_Hostel() {
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
					String query = "select * from COMPLAINT where COMP_TYPE='hostel'";
					PreparedStatement pst = connect.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		btnViewTable.setFont(new Font("Cambria", Font.BOLD, 16));
		btnViewTable.setBounds(50, 11, 210, 34);
		contentPane.add(btnViewTable);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sub_Admin_Hostel_Update stat = new Sub_Admin_Hostel_Update();
				dispose();
				stat.setVisible(true);
			}
		});
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 16));
		btnUpdate.setBounds(292, 11, 210, 34);
		contentPane.add(btnUpdate);
		
		JButton btnMessageFromAdmin = new JButton("MESSAGE FROM ADMIN");
		btnMessageFromAdmin.setBackground(Color.PINK);
		btnMessageFromAdmin.setForeground(new Color(0, 0, 0));
		btnMessageFromAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from MSG_TO_SUBADMIN where SUBADMIN='HOSTEL-SUBADMIN";
					PreparedStatement pst = connect.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		btnMessageFromAdmin.setFont(new Font("Cambria", Font.BOLD, 16));
		btnMessageFromAdmin.setBounds(545, 11, 210, 34);
		contentPane.add(btnMessageFromAdmin);
		
		JButton btnLogOut = new JButton("EXIT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnLogOut.setBackground(Color.PINK);
		btnLogOut.setForeground(new Color(0, 0, 0));
		btnLogOut.setFont(new Font("Cambria", Font.BOLD, 16));
		btnLogOut.setBounds(489, 397, 217, 34);
		contentPane.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 137, 729, 232);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -41, 784, 502);
		contentPane.add(label);
	}

}
