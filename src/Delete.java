import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import java.awt.Color;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
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
	public Delete() {
		  connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from COMPLAINT where COMP_ID='"+textField.getText()+"'";
					PreparedStatement pst = connect.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null,"COMPLAINT IS DELETED");
						
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		btnDelete.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDelete.setBounds(257, 314, 209, 41);
		contentPane.add(btnDelete);
		
		JLabel lblEnterComplaintId = new JLabel("ENTER COMPLAINT ID");
		lblEnterComplaintId.setForeground(new Color(139, 0, 139));
		lblEnterComplaintId.setFont(new Font("Cambria", Font.BOLD, 20));
		lblEnterComplaintId.setBounds(93, 129, 236, 46);
		contentPane.add(lblEnterComplaintId);
		
		textField = new JTextField();
		textField.setBounds(348, 135, 261, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin admin = new Admin();
				dispose();
				admin.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack.setBounds(602, 11, 158, 33);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, -48, 775, 485);
		contentPane.add(lblNewLabel);
	}
}
