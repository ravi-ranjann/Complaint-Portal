 import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class New_complaint extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_complaint frame = new New_complaint();
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
	public New_complaint() {
		setTitle("NEW_COMPLAINT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("HOSTEL");
		rdbtnNewRadioButton.setForeground(new Color(139, 0, 139));
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(264, 53, 119, 29);
		rdbtnNewRadioButton.setFont(new Font("Cambria", Font.BOLD, 16));
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("CAMPUS(CANTEEN,BUILDINGS,CLASSROOMS ETC)");
		rdbtnNewRadioButton_1.setForeground(new Color(139, 0, 139));
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setBounds(264, 112, 391, 29);
		rdbtnNewRadioButton_1.setFont(new Font("Cambria", Font.BOLD, 16));
		
		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("OTHERS(HEALTH CENTER,COPERATIVE,SPORTS ETC)");
		rdbtnNewRadioButton_2.setForeground(new Color(139, 0, 139));
		rdbtnNewRadioButton_2.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_2.setBounds(264, 159, 425, 29);
		rdbtnNewRadioButton_2.setFont(new Font("Cambria", Font.BOLD, 16));
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton.addActionListener(null);
		rdbtnNewRadioButton_1.addActionListener(null);
		rdbtnNewRadioButton_2.addActionListener(null);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(393, 357, 147, 42);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectionString="";
				if(rdbtnNewRadioButton.isSelected())
					selectionString+="HOSTEL";					
				if(rdbtnNewRadioButton_1.isSelected())
					selectionString+="CAMPUS";
				if(rdbtnNewRadioButton_2.isSelected())
					selectionString+="OTHERS";
				
				if(selectionString.equals("HOSTEL"))
				{
					NewHostelComplaint hostel=new NewHostelComplaint();
					dispose();
					hostel.setVisible(true);
				}
				if(selectionString.equals("CAMPUS"))
				{
					NewCampusComplaint hostel=new NewCampusComplaint();
					dispose();
					hostel.setVisible(true);
				}
				if(selectionString.equals("OTHERS"))
				{
					NewOtherComplaint hostel=new NewOtherComplaint();
					dispose();
					hostel.setVisible(true);
				}
				//JOptionPane.showMessageDialog(null,selectionString);
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("CHOOSE THE AREA IN WHICH THE COMPLAINT IS TO BE DONE");
		lblNewLabel.setBounds(0, -43, 801, 505);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 18));
		contentPane.setLayout(null);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_2);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User ac = new User();
				dispose();
				ac.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Calibri", Font.BOLD, 19));
		btnBack.setBounds(351, 370, 125, 42);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/loginbackground.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 801, 492);
		contentPane.add(label);
	}
}
