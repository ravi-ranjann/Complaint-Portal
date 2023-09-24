import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.sql.*;
import java.lang.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Msg_to_subadmin extends JFrame {

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
					Msg_to_subadmin frame = new Msg_to_subadmin();
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
	public Msg_to_subadmin() {
					
		setTitle("MESSAGE TO SUB-ADMIN");
		connect = sqlconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComplaintId = new JLabel("COMPLAINT ID");
		lblComplaintId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComplaintId.setBounds(267, 25, 133, 42);
		contentPane.add(lblComplaintId);
		
		JLabel lblMessage = new JLabel("MESSAGE");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(267, 154, 161, 35);
		contentPane.add(lblMessage);
		
		textField = new JTextField();
		textField.setBounds(457, 22, 200, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(457, 140, 200, 78);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HOSTEL SUB-ADMIN", "CAMPUS SUB-ADMIN", "OTHER SUB-ADMIN"}));
		comboBox.setBounds(457, 79, 200, 50);
		contentPane.add(comboBox);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(279, 300, 149, 35);
		Image img3 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img3));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query="insert into MSG_TO_SUBADMIN (COMP_ID,SUBADMIN,MESSAGE) values (?,?,?)";
					PreparedStatement pst=connect.prepareStatement(query);	
					pst.setString(1, textField.getText());
					pst.setString(3, textField_1.getText());
					pst.setString(2,(String)comboBox.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "YOUR MESSAGE IS SEND");
				
					pst.close();
				
			} catch(Exception e1)
			{
				e1.printStackTrace();
			}
		
		}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(279, 336, 149, 50);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(473, 308, 126, 50);
		Image img = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin abc = new Admin();
				dispose();
				abc.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(473, 336, 119, 48);
		contentPane.add(btnBack);
		
		JLabel lblSubAdmin = new JLabel("SUB ADMIN");
		lblSubAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubAdmin.setBounds(267, 78, 133, 50);
		contentPane.add(lblSubAdmin);
		
		JLabel label = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img5));
		label.setBounds(0, -63, 784, 524);
		contentPane.add(label);
		Image img1 = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		
		
	}
}
