import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Login {

	private JFrame frame;
	private JTextField textField_Username;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel label_1;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect=null;
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	  connect = sqlconnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 817, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(Color.PINK);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
					String query = "select * from ADMIN_LOGIN where USERNAME=? and PASSWORD=? and ADMIN_TYPE=?";
					String type;
					PreparedStatement pst = connect.prepareStatement(query);
					pst.setString(1,textField_Username.getText());
					pst.setString(2,passwordField.getText());
					pst.setString(3,(String)comboBox.getSelectedItem());
					type=(String)comboBox.getSelectedItem();
					ResultSet rs = pst.executeQuery();
					int count =0;
					while(rs.next()){
						count = count+1;
					}
					if(count == 1)
					{
						//JOptionPane.showMessageDialog(null,"username and password is correct");
						if(type=="ADMIN")
						{
						Admin admin = new Admin();
						frame.dispose();
						admin.setVisible(true);
						}
						if(type=="SUB_ADMIN_HOSTEL")
						{
							Sub_Admin_Hostel admin = new Sub_Admin_Hostel();
							frame.dispose();
							admin.setVisible(true);
						}
						if(type=="SUB_ADMIN_CAMPUS")
						{
							Sub_Admin_Campus admin = new Sub_Admin_Campus();
							frame.dispose();
							admin.setVisible(true);							
						}
						if(type=="SUB_ADMIN_OTHERS")
						{
							Sub_Admin_Others admin = new Sub_Admin_Others();
							frame.dispose();
							admin.setVisible(true);
						}
						if(type=="COMPLAINER")
						{
							User complainer = new User();
							frame.dispose();
							complainer.setVisible(true);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"username and password is incorrect");
					}
					rs.close();
					pst.close();
				 } catch(Exception e12){
					JOptionPane.showMessageDialog(null, e12);
				}	
				
			}
		});
		btnLogin.setBounds(551, 185, 175, 46);
		Image img2 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		frame.getContentPane().setLayout(null);
		btnLogin.setIcon(new ImageIcon(img2));
		btnLogin.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(btnLogin);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(551, 30, 218, 36);
		frame.getContentPane().add(textField_Username);
		textField_Username.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME/USERID");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setBounds(384, 29, 147, 36);
		lblUsername.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(551, 77, 218, 36);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(384, 76, 151, 37);
		lblPassword.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(lblPassword);
		
		JButton btnForgot = new JButton("CLICK HERE");
		btnForgot.setBackground(Color.PINK);
		btnForgot.setBounds(551, 358, 175, 46);
		Image img3 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnForgot.setIcon(new ImageIcon(img3));
		btnForgot.setFont(new Font("Cambria", Font.BOLD, 16));
		btnForgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ForgotPassword forgot = new ForgotPassword();
				frame.dispose();
				forgot.setVisible(true);
			}
		});
		frame.getContentPane().add(btnForgot);
		
		JLabel lblForgot = new JLabel("FORGOT PASSWORD??");
		lblForgot.setBounds(384, 358, 165, 46);
		lblForgot.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(lblForgot);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setFont(new Font("Cambria", Font.BOLD, 16));
		comboBox.setBounds(551, 134, 191, 36);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("ADMIN");
		comboBox.addItem("SUB_ADMIN_HOSTEL");
		comboBox.addItem("SUB_ADMIN_CAMPUS");
		comboBox.addItem("SUB_ADMIN_OTHERS");
		comboBox.addItem("COMPLAINER");
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 791, 481);
		frame.getContentPane().add(lblNewLabel);
	}
}
