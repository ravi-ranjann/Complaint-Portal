import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Admin extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect=null;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public Admin() {
		  connect = sqlconnection.dbConnector();
		setFont(new Font("Cambria", Font.BOLD, 16));
		setTitle("ADMIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("VEIW TABLE ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from COMPLAINT";
					PreparedStatement pst = connect.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton.setBounds(50, 11, 161, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE STATUS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Update update = new Admin_Update();
				dispose();
				update.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_1.setBounds(283, 11, 230, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RESPONSE TABLE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from COMPLAINT where STATUS=1";
					PreparedStatement pst = connect.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}	
			}
		});
		btnNewButton_2.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_2.setBounds(568, 11, 185, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SEND MESSAGE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Msg_to_subadmin abc = new Msg_to_subadmin();
				dispose();
				abc.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_3.setBounds(568, 77, 185, 34);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DELETE COMPLAINTS");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete delete = new Delete();
				dispose();
				delete.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNewButton_4.setBounds(283, 77, 230, 34);
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 743, 237);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -46, 784, 507);
		contentPane.add(label);
	}
}
