import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import net.proteanit.sql.*;

import java.awt.event.*;


public class NewOtherComplaint extends JFrame {

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
					NewOtherComplaint frame = new NewOtherComplaint();
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
	Connection connect=null;
	public NewOtherComplaint() {
		connect= sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOtherComplaints = new JLabel("OTHER COMPLAINTS");
		lblOtherComplaints.setFont(new Font("Cambria", Font.BOLD, 20));
		lblOtherComplaints.setBounds(306, 11, 200, 50);
		contentPane.add(lblOtherComplaints);
		
		JLabel lblCategories = new JLabel("CATEGORIES");
		lblCategories.setFont(new Font("Cambria", Font.BOLD, 16));
		lblCategories.setBounds(342, 72, 114, 39);
		contentPane.add(lblCategories);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"COOPERATIVE", "HEALTH CENTRE", "GYM KHANA", "SWIMMING POOL", "SPORTS SECTION","OTHERS"}));
		comboBox.setBounds(564, 81, 200, 20);
		contentPane.add(comboBox);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(564, 177, 201, 20);
		contentPane.add(dateChooser);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Cambria", Font.BOLD, 16));
		lblName.setBounds(342, 117, 125, 39);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("DATE");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel.setBounds(342, 159, 132, 50);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(564, 123, 200, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CONTACT NUMBER");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel_1.setBounds(342, 214, 153, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmailid = new JLabel("EMAIL-ID");
		lblEmailid.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEmailid.setBounds(342, 270, 153, 39);
		contentPane.add(lblEmailid);
		
		JLabel lblDetails = new JLabel("DETAILS");
		lblDetails.setFont(new Font("Cambria", Font.BOLD, 16));
		lblDetails.setBounds(342, 341, 142, 39);
		contentPane.add(lblDetails);
		
		textField_1 = new JTextField();
		textField_1.setBounds(564, 226, 200, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(564, 276, 200, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(564, 325, 200, 74);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
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
		btnNewButton.setBounds(418, 415, 125, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User user= new User();
				dispose();
				user.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_1.setBounds(629, 415, 114, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/qmark.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -35, 786, 495);
		contentPane.add(label);
		
		
	}
}
