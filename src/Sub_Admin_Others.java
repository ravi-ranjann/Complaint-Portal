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

public class Sub_Admin_Others extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sub_Admin_Others frame = new Sub_Admin_Others();
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
	public Sub_Admin_Others() {
		connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnV = new JButton("VIEW");
		btnV.setBackground(Color.PINK);
		btnV.setForeground(new Color(0, 0, 0));
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from COMPLAINT where (COMP_TYPE='COOPERATIVE' OR COMP_TYPE='HEALTH CENTRE' OR COMP_TYPE='GYM KHANA' OR COMP_TYPE='SWIMMING POOL' OR COMP_TYPE='SPORTS SECTION' OR COMP_TYPE='OTHERS'";
					PreparedStatement pst = connect.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	 
			}
		});
		btnV.setFont(new Font("Cambria", Font.BOLD, 16));
		btnV.setForeground(new Color(0, 0, 0));
		btnV.setBounds(41, 11, 210, 35);
		contentPane.add(btnV);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sub_Admin_Other_Update stat = new Sub_Admin_Other_Update();
				dispose();
				stat.setVisible(true);
			}
		});
		btnNewButton.setBounds(279, 11, 210, 35);
		contentPane.add(btnNewButton);
		
		JButton btnMessageFromAdmin = new JButton("MESSAGE FROM ADMIN");
		btnMessageFromAdmin.setBackground(Color.PINK);
		btnMessageFromAdmin.setForeground(new Color(0, 0, 0));
		btnMessageFromAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from MSG_TO_SUBADMIN where SUBADMIN='OTHER-SUBADMIN";
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
		btnMessageFromAdmin.setBounds(530, 11, 210, 35);
		contentPane.add(btnMessageFromAdmin);
		
		JButton btnLogOut = new JButton("LOGOUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		btnLogOut.setBackground(Color.PINK);
		btnLogOut.setForeground(new Color(0, 0, 0));
		btnLogOut.setFont(new Font("Cambria", Font.BOLD, 16));
		btnLogOut.setBounds(548, 399, 210, 35);
		contentPane.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 153, 717, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(-12, -42, 797, 504);
		contentPane.add(label);
	}
}
