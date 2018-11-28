package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class Main {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<Customer> CusInfo = new ArrayList<Customer>();
		Customer c1 = new Customer();
		CusInfo.add(c1);
		ArrayList<Admin> AdminInfo = new ArrayList<Admin>();
		Admin A1 = new Admin();
		AdminInfo.add(A1);
		Flight f1 = new Flight();
		int count2 = 0;
		int count3 = 1000;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBounds(188, 34, 113, 14);
		frame.getContentPane().add(lblMainMenu);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerAirline window = new CustomerAirline(CusInfo);
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(53, 105, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAirline window = new AdminAirline(AdminInfo);
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(53, 190, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Are You Customer?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(53, 69, 139, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAreYouAdmin = new JLabel("Are You Admin?");
		lblAreYouAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAreYouAdmin.setBounds(53, 154, 139, 25);
		frame.getContentPane().add(lblAreYouAdmin);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setBounds(288, 76, 136, 25);
		frame.getContentPane().add(lblDontHaveAn);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Register window = new Register(CusInfo, AdminInfo, count2 +1, count3+1);
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(282, 112, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int e1 = 0; e1 < CusInfo.size(); e1++) {
					JOptionPane.showMessageDialog(frame,"For every single person in the array: " + CusInfo.get(e1).toString());
			      }
			}
		});
		btnView.setBounds(166, 105, 89, 23);
		frame.getContentPane().add(btnView);
		
		JButton btnView_1 = new JButton("View");
		btnView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int e1 = 0; e1 < AdminInfo.size(); e1++) {
					JOptionPane.showMessageDialog(frame,"For every single person in the array: " + AdminInfo.get(e1).toString());
			      }
			}
		});
		btnView_1.setBounds(166, 190, 89, 23);
		frame.getContentPane().add(btnView_1);
	}
	public Main(int a, ArrayList<Customer> CusInfo, int b, ArrayList<Admin> AdminInfo) {
		initialize(a, CusInfo, b, AdminInfo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int a, ArrayList<Customer> CusInfo, int b, ArrayList<Admin> AdminInfo) {

		Flight f1 = new Flight();
		int count2 = a;
		int count3 = b;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBounds(188, 34, 46, 14);
		frame.getContentPane().add(lblMainMenu);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerAirline window = new CustomerAirline(CusInfo);
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(53, 105, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(53, 190, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Are You Customer?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(53, 69, 139, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAreYouAdmin = new JLabel("Are You Admin?");
		lblAreYouAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAreYouAdmin.setBounds(53, 154, 139, 25);
		frame.getContentPane().add(lblAreYouAdmin);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setBounds(288, 76, 113, 25);
		frame.getContentPane().add(lblDontHaveAn);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Register window = new Register(CusInfo, AdminInfo, count2 +1, count3+1);
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(282, 112, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int e1 = 0; e1 < CusInfo.size(); e1++) {
					JOptionPane.showMessageDialog(frame,"For every single person in the array: " + CusInfo.get(e1).toString());
			      }
			}
		});
		btnView.setBounds(166, 105, 89, 23);
		frame.getContentPane().add(btnView);
		
		JButton btnView_1 = new JButton("View");
		btnView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int e1 = 0; e1 < AdminInfo.size(); e1++) {
					JOptionPane.showMessageDialog(frame,"For every single person in the array: " + AdminInfo.get(e1).toString());
			      }
			}
		});
		btnView_1.setBounds(166, 190, 89, 23);
		frame.getContentPane().add(btnView_1);
	}
}
