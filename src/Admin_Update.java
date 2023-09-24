import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Admin_Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Update frame = new Admin_Update();
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
	public Admin_Update() {
		connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterComplaintId = new JLabel("ENTER COMPLAINT ID TO BE UPDATED");
		lblEnterComplaintId.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterComplaintId.setBounds(231, 25, 299, 44);
		contentPane.add(lblEnterComplaintId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
			char c = evt.getKeyChar();
			if(!(Character.isDigit(c)))
			{
				evt.consume(); 
			}
			}
		});
		textField.setBounds(557, 25, 207, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(283, 137, 175, 46);
		Image img3 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img3));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from COMPLAINT_TABLE where STATUS='1' and COMP_ID='"+textField.getText()+"' ";
					PreparedStatement psti = connect.prepareStatement(query);
					ResultSet rst = psti.executeQuery();
						int count =0;
						while(rst.next()){
							count = count+1;
						}
						if(count > 0)
						{ 
							String quer = "Update COMPLAINT_TABLE set STATUS='2' where COMP_ID='"+textField.getText()+"' ";
							PreparedStatement pst = connect.prepareStatement(quer);
							pst.execute();
							JOptionPane.showMessageDialog(null, "UPDATION IS DONE");
							pst.close();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"NOTHING TO UPDATE");
						}
					} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.setBounds(194, 152, 145, 44);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(Color.PINK);
		btnBack.setBounds(507, 139, 175, 46);
		Image img4 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img4));
		btnBack.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin admin = new Admin();
				dispose();
				admin.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack.setBounds(468, 152, 145, 44);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -23, 786, 480);
		contentPane.add(label);
	}
}
