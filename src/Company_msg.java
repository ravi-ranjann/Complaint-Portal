import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;

public class Company_msg extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea; 
	private JLabel lblNewLabel_3;
	public int i=0;
	public int j=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Company_msg frame = new Company_msg();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection connection=null;
	public JTextField textField_1;
	public JLabel label;
	private JSeparator separator;
	public Company_msg() {
		connection=sqlconnection.dbConnector();
		setTitle("MESSAGE BOX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SUBJECT");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 176, 118, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MESSAGE BODY");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 236, 118, 38);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria", Font.BOLD, 16));
		textField.setBounds(148, 176, 373, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.BOLD, 16));
		textArea.setBounds(152, 236, 369, 145);
		contentPane.add(textArea);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_3.setBounds(426, 28, 127, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(j==1)
					{
					String qury="insert into message(usertype,subject,message,username) values ('ADMIN',?,?,?)";
					PreparedStatement pst=connection.prepareStatement(qury);
					
					
					pst.setString(1,textField.getText());
					pst.setString(2,textArea.getText());
					pst.setString(3,textField_1.getText());
					pst.execute();
					
					lblNewLabel_3.setText("YOUR MESSAGE HAS BEEN SENT !!!! ");
					pst.close();
					}
					if(j==2)
					{
					String qury="insert into message(usertype,subject,message,username) values ('Sub_Admin_Campus',?,?,?)";
					PreparedStatement pst=connection.prepareStatement(qury);
					
					
					pst.setString(1,textField.getText());
					pst.setString(2,textArea.getText());
					pst.setString(3,textField_1.getText());
					pst.execute();
					
					lblNewLabel_3.setText("YOUR MESSAGE HAS BEEN SENT !!!! ");
					pst.close();
					}
					if(j==3)
					{
					String qury="insert into message(usertype,subject,message,username) values ('Sub_Admin_Hostel',?,?,?)";
					PreparedStatement pst=connection.prepareStatement(qury);
					
					
					pst.setString(1,textField.getText());
					pst.setString(2,textArea.getText());
					pst.setString(3,textField_1.getText());
					pst.execute();
					
					lblNewLabel_3.setText("YOUR MESSAGE HAS BEEN SENT !!!! ");
					pst.close();
					}
					if(j==4)
					{
					String qury="insert into message(usertype,subject,message,username) values ('Sub_Admin_Others',?,?,?)";
					PreparedStatement pst=connection.prepareStatement(qury);
					
					
					pst.setString(1,textField.getText());
					pst.setString(2,textArea.getText());
					pst.setString(3,textField_1.getText());
					pst.execute();
					
					lblNewLabel_3.setText("YOUR MESSAGE HAS BEEN SENT !!!! ");
					pst.close();
					}
					
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 14));
		btnNewButton.setBounds(24, 399, 108, 36);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Cambria", Font.BOLD, 16));
		textField_1.setBounds(152, 28, 205, 38);
		contentPane.add(textField_1);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_2.setBounds(24, 22, 108, 38);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(j==2 || j==3 || j==4)
				{
					Admin admin = new Admin();
					dispose();
					admin.label_1.setText(textField_1.getText());
					admin.setVisible(true);
				}
				if(i==2)
				{
					Sub_Admin_Campus admin = new Sub_Admin_Campus();
					dispose();
					admin.label.setText(textField_1.getText());
					admin.setVisible(true);
				}
				if(i==3)
				{
					Sub_Admin_Hostel admin = new Sub_Admin_Hostel();
					dispose();
					admin.label.setText(textField_1.getText());
					admin.setVisible(true);
				}
				if(i==4)
				{
					Sub_Admin_Others admin = new Sub_Admin_Others();
					dispose();
					admin.label.setText(textField_1.getText());
					admin.setVisible(true);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 14));
		btnNewButton_1.setBounds(180, 399, 113, 36);
		contentPane.add(btnNewButton_1);
		
		label = new JLabel("");
		label.setBounds(572, 146, 81, 38);
		contentPane.add(label);
		
		separator = new JSeparator();
		separator.setBounds(24, 80, 764, 22);
		contentPane.add(separator);
		
		
	}
}
