import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.sql.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Username;
	private JTextField textField_Name;
	private JTextField textField_Type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect=null;
	private JTextField textField_Password;
	/**
	 * Create the frame.
	 */
	public ForgotPassword() {
		 connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(585, 29, 179, 34);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						String query = "select * from ADMIN_LOGIN where USERNAME=? and NAME=? and ADMIN_TYPE=?";
						PreparedStatement pst = connect.prepareStatement(query);
						pst.setString(1,textField_Username.getText());
						pst.setString(2,textField_Name.getText());
						pst.setString(3,textField_Type.getText());
						ResultSet rs = pst.executeQuery();
						int count =0;
						while(rs.next()){
							count = count+1;
						}
						if(count == 1)
						{
							String pass = "select PASSWORD from ADMIN_LOGIN where USERNAME=? and NAME=? and ADMIN_TYPE=?";
							//String password;
							PreparedStatement psti = connect.prepareStatement(pass);
							psti.setString(1,textField_Username.getText());
							psti.setString(2,textField_Name.getText());
							psti.setString(3,textField_Type.getText());
							ResultSet rst = psti.executeQuery();
							textField_Password.setText(rst.getString("PASSWORD"));
						}
						else
						{
							textField_Password.setText("YOUR DETAILS ARE INCORRECT TRY AGAIN!!!!!!!!!!!!!!!!!!!!!!!!");
							//JOptionPane.showMessageDialog(null, "YOUR DETAILS ARE INCORRECT");
						}
				 } catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}	
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.setBounds(343, 238, 130, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterYourUsername = new JLabel("ENTER YOUR USERNAME");
		lblEnterYourUsername.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYourUsername.setBounds(343, 27, 211, 34);
		contentPane.add(lblEnterYourUsername);
		
		JLabel lblEnterYour = new JLabel("ENTER YOUR NAME");
		lblEnterYour.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYour.setBounds(343, 96, 166, 50);
		contentPane.add(lblEnterYour);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(585, 101, 179, 44);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Type = new JTextField();
		textField_Type.setBounds(585, 170, 180, 44);
		contentPane.add(textField_Type);
		textField_Type.setColumns(10);
		
		JLabel lblEnterYourType = new JLabel("ENTER YOUR TYPE");
		lblEnterYourType.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYourType.setBounds(343, 168, 188, 44);
		contentPane.add(lblEnterYourType);
		
		JLabel lblYourPasswordIs = new JLabel("YOUR PASSWORD IS SHOWN IN THIS TEXT BOX AFTER YOU FILL YOUR DETAILS AND PRESS ENTER");
		lblYourPasswordIs.setFont(new Font("Cambria", Font.BOLD, 16));
		lblYourPasswordIs.setBounds(34, 372, 731, 34);
		contentPane.add(lblYourPasswordIs);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(34, 417, 731, 34);
		contentPane.add(textField_Password);
		textField_Password.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    dispose();			
			}
		});
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_1.setBounds(585, 238, 147, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/qmark.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 794, 404);
		contentPane.add(label);
	}
}
