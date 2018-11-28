package project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;

import project.Person;
import project.Register;
import project.Customer;
import project.Admin;
import project.Flight;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;


public class CustomerAirline {

	JFrame frame;
	private JTextField textField;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private int count2 = 0;
	private int count3 = 1000;

	/**
	 * Launch the application.
	 */
	public static void Screen( ArrayList<Customer> CusInfo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAirline window = new CustomerAirline(CusInfo);
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
	public CustomerAirline(ArrayList<Customer> cusInfo) {
		initialize(cusInfo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Customer> CusInfo) {
		
		int LogInID = -1;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 204, 204));
		frame.setBackground(new Color(0, 102, 255));
		frame.setBounds(100, 100, 481, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(143, 144, 112, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBackground(Color.BLUE);
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserName.setBounds(71, 139, 129, 33);
		frame.getContentPane().add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(71, 186, 119, 26);
		frame.getContentPane().add(lblPassword);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				int LogInID = -1;
				int count1 = 0;

				String ID = textField.getText();
				String Pas = passwordField.getText();
				for(int i = 0; i < CusInfo.size(); i++) {
					if(CusInfo.get(i).getUsername().equals(ID) &&CusInfo.get(i).getPassword().equals(Pas)) {
							LogInID = i;
				JOptionPane.showMessageDialog(frame, "Correct");	
				frame.dispose();
				CustomerView window = new CustomerView(LogInID, CusInfo);
				window.frame.setVisible(true);
				break;
				}else {
					JOptionPane.showMessageDialog(frame, "Wrong");	
				}
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignIn.setBounds(288, 181, 80, 38);
		frame.getContentPane().add(btnSignIn);
		
		JLabel lblAirline = new JLabel("Welcome to Airline");
		lblAirline.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAirline.setBounds(26, 11, 173, 33);
		frame.getContentPane().add(lblAirline);
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 188, 112, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Forge Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Forget r1 = new Forget(CusInfo);
				r1.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(148, 267, 149, 24);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomer.setBounds(148, 72, 96, 45);
		frame.getContentPane().add(lblCustomer);
		
		JButton btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main window = new Main();
				window.frame.setVisible(true);
			}
			
		});
		btnBackToMain.setBounds(298, 20, 135, 33);
		frame.getContentPane().add(btnBackToMain);
	}
}
