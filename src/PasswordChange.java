import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class PasswordChange extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldp;
	public JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public int i=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChange frame = new PasswordChange();
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
	public PasswordChange() {
		  connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourUsername = new JLabel("ENTER YOUR LOGIN TYPE");
		lblEnterYourUsername.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYourUsername.setBounds(50, 116, 250, 35);
		contentPane.add(lblEnterYourUsername);
		
		JLabel lblEnterYourUser = new JLabel("YOUR USER ID");
		lblEnterYourUser.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYourUser.setBounds(50, 30, 213, 42);
		contentPane.add(lblEnterYourUser);
		
		JLabel lblEnterYourPassword = new JLabel("ENTER YOUR OLD PASSWORD");
		lblEnterYourPassword.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYourPassword.setBounds(50, 171, 250, 42);
		contentPane.add(lblEnterYourPassword);
		
		JLabel lblEnterYourLogin = new JLabel("ENTER YOUR NEW PASSWORD");
		lblEnterYourLogin.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYourLogin.setBounds(50, 232, 250, 42);
		contentPane.add(lblEnterYourLogin);
		
		JButton btnChangePassword = new JButton("CHANGE PASSWORD");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						String query = "select pwd from Login where utype=? and uname=? and pwd=?";
						PreparedStatement pst = connect.prepareStatement(query);
						pst.setString(1,textFieldp.getText());
						pst.setString(2,textField_1.getText());
						pst.setString(3,passwordField.getText());
						ResultSet rs = pst.executeQuery();	
						int count = 0;
						while(rs.next()){
							count = count+1;
						}
						if(count > 0)
							{
							int actionn = JOptionPane.showConfirmDialog(null,"DO YOU REALLY WANT TO CHANGE?","CHANGE", JOptionPane.YES_NO_OPTION);
							if(actionn==0)
							{
								String quer = "Update Login set pwd='"+passwordField_1.getText()+"' where uname = '"+textField_1.getText()+"'  ";
								PreparedStatement psti = connect.prepareStatement(quer);
								psti.execute();
								JOptionPane.showMessageDialog(null, "UPDATION IS DONE");
							}
							}
						else
						{
							JOptionPane.showMessageDialog(null,"YOUR DETAILS ARE INCORRECT TRY AGAIN!!!!!!!!!!!!!!!!!!!!!!!!");
						}
							
				 } catch(Exception e3){
						JOptionPane.showMessageDialog(null, e3);
					}	
			}
		});
		btnChangePassword.setFont(new Font("Cambria", Font.BOLD, 16));
		btnChangePassword.setBounds(50, 308, 206, 35);
		contentPane.add(btnChangePassword);
		
		JButton btnBack = new JButton("LOG OUT");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispose();
					Login.main(null);
			}
		});
		btnBack.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack.setBounds(49, 366, 156, 35);
		contentPane.add(btnBack);
		
		textFieldp = new JTextField();
		textFieldp.setBounds(350, 118, 178, 35);
		contentPane.add(textFieldp);
		textFieldp.setColumns(10);
		//textFieldp.setEnabled(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(350, 36, 178, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(350, 174, 178, 35);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(350, 232, 178, 36);
		contentPane.add(passwordField_1);
		
		
		JButton btnBack_1 = new JButton("BACK");
		btnBack_1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i==1)
				{
				Admin admin = new Admin();
				dispose();
				admin.label_1.setText(textField_1.getText());
				admin.setVisible(true);
				}
				if(i==2)
				{
				Sub_Admin_Campus rec = new Sub_Admin_Campus();
				dispose();
				rec.label.setText(textField_1.getText());
				rec.setVisible(true);
				}
				if(i==3)
				{
				Sub_Admin_Hostel rec = new Sub_Admin_Hostel();
				dispose();
				rec.label.setText(textField_1.getText());
				rec.setVisible(true);
				}
				if(i==4)
				{
				Sub_Admin_Others rec = new Sub_Admin_Others();
				dispose();
				rec.label.setText(textField_1.getText());
				rec.setVisible(true);
				}
				if(i==5)
				{
					User sp = new User();
					dispose();
					sp.label.setText(textField_1.getText());
					sp.setVisible(true);
				}
			}
		});
		btnBack_1.setBounds(257, 366, 156, 35);
		contentPane.add(btnBack_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 85, 770, 13);
		contentPane.add(separator);
	}
}
