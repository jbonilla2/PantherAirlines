package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reg_Ad {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblPassword;
	private JTextField textField_6;
	private JLabel lblSocialSecurity;
	private JTextField textField_7;
	private JLabel lblState;
	private JTextField textField_8;
	private JLabel lblAnswerForSecurity;
	private JTextField textField_9;
	private JButton btnNewButton;
	private JLabel lblSecurityCodeFor;
	private JTextField textField_10;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void Screen(int count,ArrayList<Customer> CusInfo, int count1,  ArrayList<Admin> AdminInfo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg_Ad window = new Reg_Ad(count,CusInfo,count1, AdminInfo);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reg_Ad(int count,ArrayList<Customer> CusInfo, int count1,  ArrayList<Admin> AdminInfo) {
		initialize(count,CusInfo,count1, AdminInfo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int count,ArrayList<Customer> CusInfo, int count1,  ArrayList<Admin> AdminInfo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(41, 32, 85, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(41, 49, 98, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(41, 90, 85, 18);
		frame.getContentPane().add(lblAddress);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(41, 107, 98, 27);
		frame.getContentPane().add(textField_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(41, 155, 85, 18);
		frame.getContentPane().add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(41, 230, 158, 27);
		frame.getContentPane().add(textField_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(41, 213, 85, 18);
		frame.getContentPane().add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(41, 172, 98, 27);
		frame.getContentPane().add(textField_3);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(174, 32, 85, 18);
		frame.getContentPane().add(lblLastName);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(307, 107, 98, 27);
		frame.getContentPane().add(textField_4);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblZip.setBounds(307, 90, 85, 18);
		frame.getContentPane().add(lblZip);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(174, 49, 98, 27);
		frame.getContentPane().add(textField_5);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(174, 155, 85, 18);
		frame.getContentPane().add(lblPassword);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(209, 230, 158, 27);
		frame.getContentPane().add(textField_6);
		
		lblSocialSecurity = new JLabel("Social Security");
		lblSocialSecurity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSocialSecurity.setBounds(209, 213, 98, 18);
		frame.getContentPane().add(lblSocialSecurity);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(174, 172, 98, 27);
		frame.getContentPane().add(textField_7);
		
		lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblState.setBounds(174, 90, 85, 18);
		frame.getContentPane().add(lblState);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(174, 107, 98, 27);
		frame.getContentPane().add(textField_8);
		
		lblAnswerForSecurity = new JLabel("Answer for Security Question");
		lblAnswerForSecurity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswerForSecurity.setBounds(41, 280, 218, 18);
		frame.getContentPane().add(lblAnswerForSecurity);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(41, 297, 207, 27);
		frame.getContentPane().add(textField_9);
		
		
		lblSecurityCodeFor = new JLabel("Security Code for Admin");
		lblSecurityCodeFor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecurityCodeFor.setBounds(41, 336, 218, 18);
		frame.getContentPane().add(lblSecurityCodeFor);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(41, 353, 207, 27);
		frame.getContentPane().add(textField_10);
		
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String First = textField.getText();
			String Last = textField_5.getText();	
			String Username = textField_3.getText();
			String Password = textField_7.getText();
			String Address = textField_1.getText();
			String Zip = textField_4.getText();
			String State = textField_8.getText();
			String Ssn = textField_6.getText();
			String Email = textField_2.getText();
			String SecurityQ = textField_9.getText();
			String AdminSC = textField_10.getText();
			boolean check =  true;
			for(int i = 0; i < AdminInfo.size(); i++) {
				if(AdminInfo.get(i).getUsername().contains(Username) || !AdminInfo.get(i).getAdminSecretCode().contains(AdminSC)) {
						check = false;							
					}
			}
			if(check == true) {
						JOptionPane.showMessageDialog(frame, "Correct");	
						Admin A1 = new Admin(count, First, Last, Address, Zip, State, Username, Password, Email, Ssn, SecurityQ);
						AdminInfo.add(A1);
						frame.dispose();
						Main window = new Main(count, CusInfo, count1, AdminInfo);
						window.frame.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(frame, "Wrong");
					}
				for(int e1 = 0; e1 < AdminInfo.size(); e1++) {
				JOptionPane.showMessageDialog(frame,"For every single person in the array: " + AdminInfo.get(e1).toString());
		      }
			}
		});
		btnNewButton.setBounds(264, 392, 119, 37);
		frame.getContentPane().add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main window = new Main(count-1, CusInfo, count1 -1,AdminInfo);
				window.frame.setVisible(true);	
			}
		});
		btnBack.setBounds(37, 399, 89, 23);
		frame.getContentPane().add(btnBack);
		
		
	}

}
