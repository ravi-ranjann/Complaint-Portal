import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.toedter.calendar.JDateChooser;


public class NewHostelComplaint extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewHostelComplaint frame = new NewHostelComplaint();
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
	
	public NewHostelComplaint() {
		connect= sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Hostel Complaint");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel.setBounds(245, 11, 241, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblCategories = new JLabel("CATEGORIES");
		lblCategories.setFont(new Font("Cambria", Font.BOLD, 16));
		lblCategories.setBounds(342, 72, 128, 50);
		contentPane.add(lblCategories);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HOSTEL CLEANING", "HOSTEL ELECTRICAL", "HOSTEL MAINTAINANCE", "HOSTEL SECURITY","OTHER IN HOSTEL"}));
		comboBox.setBounds(541, 84, 233, 28);
		contentPane.add(comboBox);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Cambria", Font.BOLD, 16));
		lblName.setBounds(342, 119, 76, 50);
		contentPane.add(lblName);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Cambria", Font.BOLD, 16));
		lblDate.setBounds(342, 171, 113, 50);
		contentPane.add(lblDate);
		
		JLabel lblContactNumber = new JLabel("CONTACT NUMBER");
		lblContactNumber.setFont(new Font("Cambria", Font.BOLD, 16));
		lblContactNumber.setBounds(342, 222, 142, 50);
		contentPane.add(lblContactNumber);
		
		JLabel lblEmailid = new JLabel("EMAIL-ID");
		lblEmailid.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEmailid.setBounds(342, 270, 90, 50);
		contentPane.add(lblEmailid);
		
	    textField = new JTextField();
		textField.setBounds(541, 132, 233, 28);
		contentPane.add(textField);
		textField.setColumns(10);
						
		textField_1 = new JTextField();
		textField_1.setBounds(541, 235, 233, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(541, 283, 233, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDetails = new JLabel("COMPLAINT DETAILS");
		lblDetails.setFont(new Font("Cambria", Font.BOLD, 16));
		lblDetails.setBounds(342, 322, 162, 50);
		contentPane.add(lblDetails);
		
		textField_3 = new JTextField();
		textField_3.setBounds(541, 322, 233, 78);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(541, 185, 233, 20);
		contentPane.add(dateChooser);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(Color.PINK);
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.addActionListener(new ActionListener() {
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
		btnSubmit.setFont(new Font("Cambria", Font.BOLD, 16));
		btnSubmit.setBounds(357, 411, 120, 28);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			User user=new User();
			dispose();
			user.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.setBounds(541, 411, 120, 28);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/qmark.jpg")).getImage();
		label.setIcon(new	ImageIcon(img));
		label.setBounds(0, -24, 784, 487);
		contentPane.add(label);
		
		
		
		
	}
}
