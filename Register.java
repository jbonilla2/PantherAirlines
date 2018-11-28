package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Register {

	JFrame frame;
	/**
	 * @wbp.nonvisual location=61,9
	 */
	private final JLabel lblRegistration = new JLabel("Registration");

	/**
	 * Launch the application.
	 */
	public static void Screen(ArrayList<Customer> CusInfo, ArrayList<Admin> AdminInfo,  int count2, int count3) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register(CusInfo, AdminInfo, count2, count3);
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
	public Register(ArrayList<Customer> CusInfo, ArrayList<Admin> AdminInfo,  int count2, int count3) {
		initialize(CusInfo, AdminInfo, count2, count3);
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Customer> CusInfo, ArrayList<Admin> AdminInfo, int count2, int count3) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAreYouCustomer = new JButton("Are you Customer?");
		btnAreYouCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Reg_Cus RS1 = new Reg_Cus( count2, CusInfo, count3, AdminInfo);
				RS1.Screen( count2, CusInfo, count3, AdminInfo);
			}
		});
		btnAreYouCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAreYouCustomer.setBounds(70, 76, 190, 42);
		frame.getContentPane().add(btnAreYouCustomer);
		
		JButton btnAreYouAdmin = new JButton("Are you Admin?");
		btnAreYouAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reg_Ad RA1 = new Reg_Ad( count2, CusInfo, count3, AdminInfo);
				RA1.Screen( count2, CusInfo, count3, AdminInfo);
			}
		});
		btnAreYouAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAreYouAdmin.setBounds(70, 149, 190, 42);
		frame.getContentPane().add(btnAreYouAdmin);
		
		JButton btnNewButton = new JButton("Back ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = count2-1;
				int count1= count3-1;
				frame.dispose();
				Main window = new Main(count, CusInfo, count1, AdminInfo);
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(298, 194, 108, 40);
		frame.getContentPane().add(btnNewButton);
	}

}
