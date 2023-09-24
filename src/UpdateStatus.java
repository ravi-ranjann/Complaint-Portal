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





public class UpdateStatus extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStatus frame = new UpdateStatus();
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
	public UpdateStatus() {
		
		
		
		
		connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheComplaint = new JLabel("ENTER COMPLAINT ID");
		lblEnterTheComplaint.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterTheComplaint.setBounds(340, 41, 169, 40);
		contentPane.add(lblEnterTheComplaint);
		
		textField = new JTextField();
		textField.setBounds(558, 43, 185, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.PINK);
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from COMPLAINT where STATUS='0' and (COMP_TYPE='LIBRARY' OR COMP_TYPE='CLEANING' OR COMP_TYPE='CANTEEN' OR COMP_TYPE='MAINTENANCE' OR COMP_TYPE='ELECTRICAL') and COMP_ID='"+textField.getText()+"' ";
					PreparedStatement psti = connect.prepareStatement(query);
					ResultSet rst = psti.executeQuery();
						int count =0;
						while(rst.next()){
							count = count+1;
						}
						if(count > 0)
						{ 
							String quer = "Update COMPLAINT set STATUS='1' where COMP_ID='"+textField.getText()+"' ";
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
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 16));
		btnUpdate.setBounds(361, 139, 169, 40);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sub_Admin_Campus campus = new Sub_Admin_Campus();
				dispose();
				campus.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.setBounds(558, 139, 161, 40);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/qmark.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -40, 786, 466);
		contentPane.add(label);
	}
}
