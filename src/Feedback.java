import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Feedback extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
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
	public Feedback() {
		
		connect= sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComplaintId = new JLabel("COMPLAINT ID");
		lblComplaintId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComplaintId.setBounds(333, 114, 133, 30);
		contentPane.add(lblComplaintId);
		
		JLabel lblFeedback = new JLabel("FEEDBACK");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFeedback.setBounds(333, 194, 136, 30);
		contentPane.add(lblFeedback);
		
		textField = new JTextField();
		textField.setBounds(539, 107, 209, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(539, 180, 209, 89);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
				String query="insert into FEEDBACK COMP_ID,FEEDBACK) values (?,?)";
				PreparedStatement pst=connect.prepareStatement(query);	
				pst.setString(1, textField.getText());
				pst.setString(2, textField_1.getText());
				pst.execute();
				pst.close();
				
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(370, 314, 117, 37);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			
				New_complaint abc = new New_complaint();
				dispose();
				abc.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(539, 314, 122, 37);
		contentPane.add(btnBack);
	}

}
