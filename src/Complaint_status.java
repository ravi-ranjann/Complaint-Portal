import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;
import java.awt.Color;
public class Complaint_status extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complaint_status frame = new Complaint_status();
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
	private JButton btnNewButton_1;
	private JLabel label;
	public Complaint_status() {
		connect=sqlconnection.dbConnector();
		setFont(new Font("Cambria", Font.BOLD, 16));
		setTitle("Complaint_status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheComplaintid = new JLabel("ENTER THE COMPLAINT_ID");
		lblEnterTheComplaintid.setForeground(Color.CYAN);
		lblEnterTheComplaintid.setFont(new Font("Cambria", Font.BOLD, 20));
		lblEnterTheComplaintid.setBounds(93, 140, 260, 40);
		contentPane.add(lblEnterTheComplaintid);
		
		textField = new JTextField();
		textField.setBounds(383, 149, 186, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("VIEW STATUS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
						String query = "select * from COMPLAINT where COMP_ID=?";
						PreparedStatement pst = connect.prepareStatement(query);
						pst.setString(1,textField.getText());
						ResultSet rs = pst.executeQuery();
						int counti =0;
						while(rs.next()){
							counti = counti+1;
						}
						if(counti == 1)
						{
							String pass = "select STATUS from COMPLAINT where COMP_ID=?";
							String status;
							PreparedStatement psti = connect.prepareStatement(pass);
							psti.setString(1,textField.getText());
							ResultSet rst = psti.executeQuery();
							status=(String)rst.getString("STATUS");
							int count =0;
							while(rst.next()){
								count = count+1;
							}
							if(count==1)
							{
							if(status.equals("0"))
							JOptionPane.showMessageDialog(null, "PENDING");
							else if(status.equals("1"))
							JOptionPane.showMessageDialog(null, "SUB_ADMIN REPORTED");
							else if(status.equals("2"))
							JOptionPane.showMessageDialog(null, "COMPLAINT IS CLOSED");
							}
						}
							else
							JOptionPane.showMessageDialog(null, "YOUR DETAILS ARE INCORRECT");
					} catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}	
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.setBounds(133, 330, 139, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=new User();
				dispose();
				user.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_1.setBounds(433, 330, 113, 40);
		contentPane.add(btnNewButton_1);
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		
		label.setBounds(0, -33, 775, 484);
		contentPane.add(label);
	}
}
