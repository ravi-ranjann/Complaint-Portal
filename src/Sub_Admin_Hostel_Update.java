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

import java.awt.BorderLayout;
import java.awt.EventQueue;

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


public class Sub_Admin_Hostel_Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sub_Admin_Hostel_Update frame = new Sub_Admin_Hostel_Update();
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
	public Sub_Admin_Hostel_Update() {
		connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterComplaintId = new JLabel("ENTER COMPLAINT ID TO UPDATE");
		lblEnterComplaintId.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterComplaintId.setBounds(254, 44, 273, 46);
		contentPane.add(lblEnterComplaintId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE) )
				{
				evt.consume();
				}
				}
		});
		textField.setBounds(546, 44, 229, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from COMPLAINT_TABLE where STATUS='0' and COMP_TYPE='hostel' and COMP_ID='"+textField.getText()+"' ";
					PreparedStatement psti = connect.prepareStatement(query);
					ResultSet rst = psti.executeQuery();
						int count =0;
						while(rst.next()){
							count = count+1;
						}
						if(count > 0)
						{ 
							String quer = "Update COMPLAINT_TABLE set STATUS='1' where COMP_ID='"+textField.getText()+"' ";
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
		btnNewButton.setBounds(306, 132, 174, 46);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(Color.PINK);
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sub_Admin_Hostel hostel = new Sub_Admin_Hostel();
				dispose();
				hostel.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack.setBounds(546, 131, 157, 48);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -38, 785, 499);
		contentPane.add(label);
	}
}
