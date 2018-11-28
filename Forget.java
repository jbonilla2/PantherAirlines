package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Forget {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void Screen(ArrayList<Customer> CusInfo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forget window = new Forget(CusInfo);
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
	public Forget(ArrayList<Customer> cusInfo) {
		initialize(cusInfo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Customer> CusInfo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTypeYourUsername = new JLabel("Type Your Username");
		lblTypeYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTypeYourUsername.setBounds(44, 34, 176, 31);
		frame.getContentPane().add(lblTypeYourUsername);
		
		textField = new JTextField();
		textField.setBounds(44, 76, 176, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTypeAnswerFor = new JLabel("Type Answer for Security Question");
		lblTypeAnswerFor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTypeAnswerFor.setBounds(44, 116, 259, 31);
		frame.getContentPane().add(lblTypeAnswerFor);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(44, 158, 176, 31);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String ID = textField.getText();
				String SQ = textField_1.getText();
				int count = 0;
				for(int i = 0; i < CusInfo.size(); i++) {
					count++;
					if(CusInfo.get(i).getUsername().equals(ID) &&CusInfo.get(i).getSecurityQ().equals(SQ)) {
							JOptionPane.showMessageDialog(frame, "\nCorrect \nHere is Password: "+CusInfo.get(i).getPassword());	
							frame.dispose();
							CustomerAirline window = new CustomerAirline(CusInfo);
							window.frame.setVisible(true);
				break;
				}if(count == CusInfo.size()) {
					JOptionPane.showMessageDialog(frame, "Wrong");	
				}
				}
			}
				
			
		});
		btnNewButton.setBounds(255, 207, 122, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back to Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main window = new Main();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(270, 11, 154, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerAirline window = new CustomerAirline(CusInfo);
				window.frame.setVisible(true);
			}
		});
		btnBack.setBounds(40, 217, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
