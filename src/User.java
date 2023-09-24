import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class User extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 532);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewComplaint = new JButton("NEW COMPLAINT");
		
		btnNewComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				New_complaint newcomplaint=new New_complaint();
				dispose();
				newcomplaint.setVisible(true);
			}
		});
		btnNewComplaint.setBounds(294, 21, 200, 35);
		Image img5 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnNewComplaint.setBackground(Color.PINK);
		contentPane.setLayout(null);
		btnNewComplaint.setIcon(new ImageIcon(img5));
		btnNewComplaint.setFont(new Font("Cambria", Font.BOLD, 16));
		contentPane.add(btnNewComplaint);
		
		JButton btnViewStatus = new JButton("VIEW STATUS");
		
		btnViewStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Complaint_status cstatus=new Complaint_status();
				dispose();
				cstatus.setVisible(true);
			}
		});
		btnViewStatus.setBounds(558, 21, 200, 35);
		Image img6 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnViewStatus.setBackground(Color.PINK);
		btnViewStatus.setIcon(new ImageIcon(img6));
		btnViewStatus.setFont(new Font("Cambria", Font.BOLD, 16));
		contentPane.add(btnViewStatus);
		
		JButton btnFeedback = new JButton("FEEDBACK");
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Feedback abc = new Feedback();
				dispose();
				abc.setVisible(true);
			}
			
			
		});
		btnFeedback.setBounds(294, 118, 200, 35);
		Image img7 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnFeedback.setBackground(Color.PINK);
		btnFeedback.setIcon(new ImageIcon(img7));
		btnFeedback.setFont(new Font("Cambria", Font.BOLD, 16));
		contentPane.add(btnFeedback);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 11, 802, 482);
		Image img4 = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img4));
			
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				dispose();
			
			}
			
			
		});
		Image img8 = new ImageIcon(this.getClass().getResource("/loginicon.png")).getImage();
		btnLogout.setIcon(new ImageIcon(img8));
		btnLogout.setBackground(Color.PINK);
		btnLogout.setFont(new Font("Cambria", Font.BOLD, 16));
		btnLogout.setBounds(558, 118, 197, 35);
		contentPane.add(btnLogout);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, -43, 802, 567);
		contentPane.add(label);
		
		
	}
}
