import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NewCampusComplaint extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCampusComplaint frame = new NewCampusComplaint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the frame.
	 */
	Connection connect = null;
	public NewCampusComplaint() {
		connect= sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewCampusComplaints = new JLabel("NEW CAMPUS COMPLAINTS");
		lblNewCampusComplaints.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewCampusComplaints.setBounds(273, 10, 245, 50);
		contentPane.add(lblNewCampusComplaints);
		
		JLabel lblNewLabel = new JLabel("CATEGORIES");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel.setBounds(382, 71, 117, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_1.setBounds(382, 123, 136, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DATE");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_2.setBounds(382, 163, 79, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CONTACT NUMBER");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_3.setBounds(382, 215, 200, 50);
		contentPane.add(lblNewLabel_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"LIBRARY", "LABORATORY", "CAMPUS CLEANING", "CANTEEN", "CAMPUS MAINTENANCE", "CAMPUS ELECTRICAL","OTHER IN CAMPUS"}));
		comboBox.setBounds(575, 75, 200, 20);
		contentPane.add(comboBox);
				
		JLabel lblNewLabel_4 = new JLabel("EMAIL-ID");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_4.setBounds(382, 262, 200, 50);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(575, 125, 200, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		textField_1 = new JTextField();
		textField_1.setBounds(575, 228, 200, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(575, 275, 200, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDetails = new JLabel("DETAILS");
		lblDetails.setFont(new Font("Cambria", Font.BOLD, 16));
		lblDetails.setBounds(382, 323, 200, 50);
		contentPane.add(lblDetails);
		
		textField_3 = new JTextField();
		textField_3.setBounds(575, 307, 200, 86);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(575, 179, 200, 20);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(new Color(0, 0, 0));


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try{
					
					String query="insert into COMPLAINT (COMP_ID,COMP_DATE,COMP_DETAIL,STATUS,COMP_TYPE,USER_ID,CONTACT,EMAIL) values (?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connect.prepareStatement(query);	
					pst.setString(4, "0");
					pst.setString(6, textField.getText());
					pst.setString(3, textField_1.getText());
					pst.setString(7, textField_2.getText());
					pst.setString(8, textField_3.getText());
					pst.setString(2, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					pst.setString(5,(String)comboBox.getSelectedItem());
					pst.execute();
					pst.close();
					String query1="select max(COMP_ID) from COMPLAINT ";
					pst = connect.prepareStatement(query1);
					ResultSet re = pst.executeQuery();
					JOptionPane.showMessageDialog(null, "YOUR COMPLAINT ID IS " + re.getString(1));
					pst.execute();
					pst.close();
					
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
				
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.setBounds(404, 403, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User user= new User();
				dispose();
				user.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_1.setBounds(575, 404, 98, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/qmark.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(10, 10, 788, 532);
		contentPane.add(label);
		
	
		
	
		
		
		
	}
}
