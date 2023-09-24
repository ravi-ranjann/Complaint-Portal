import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Status extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Status frame = new Status();
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
	public Status() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourComplaint = new JLabel("ENTER YOUR COMPLAINT");
		lblEnterYourComplaint.setFont(new Font("Cambria", Font.BOLD, 16));
		lblEnterYourComplaint.setBounds(50, 69, 254, 38);
		contentPane.add(lblEnterYourComplaint);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(315, 69, 254, 30);
		contentPane.add(textArea);
		
		JButton btnView = new JButton("VIEW");
		btnView.setFont(new Font("Cambria", Font.BOLD, 16));
		btnView.setBounds(623, 69, 118, 38);
		contentPane.add(btnView);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack.setBounds(40, 11, 111, 38);
		contentPane.add(btnBack);
	}
}
