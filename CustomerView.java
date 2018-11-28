package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class CustomerView {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Screen(int ID, ArrayList<Customer> CusInfo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView window = new CustomerView(ID, CusInfo);
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
	public CustomerView(int ID, ArrayList<Customer> CusInfo) {
		initialize(ID, CusInfo);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int ID, ArrayList<Customer> CusInfo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearchFlight = new JLabel("View My Status");
		lblSearchFlight.setBounds(40, 34, 93, 30);
		frame.getContentPane().add(lblSearchFlight);
		
		JTextPane txtpnAaa_1 = new JTextPane();

		txtpnAaa_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtpnAaa_1.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(txtpnAaa_1);
		
		
		JButton btnFlightList = new JButton("View");
		btnFlightList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnAaa_1.setText(CusInfo.get(ID).toString());
				txtpnAaa_1.setBounds(275, 34, 136, 129);
				frame.getContentPane().add(txtpnAaa_1);

			}
		});
		btnFlightList.setBounds(143, 38, 89, 23);
		frame.getContentPane().add(btnFlightList);
		
		JLabel lblAddFlight = new JLabel("Add Flight");
		lblAddFlight.setBounds(40, 75, 93, 30);
		frame.getContentPane().add(lblAddFlight);
		
		JButton button = new JButton("View");
		button.setBounds(143, 79, 89, 23);
		frame.getContentPane().add(button);
		
		JLabel lblCancelFlight = new JLabel("Cancel Flight");
		lblCancelFlight.setBounds(40, 116, 93, 30);
		frame.getContentPane().add(lblCancelFlight);
		
		JButton button_1 = new JButton("View");
		button_1.setBounds(143, 120, 89, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CustomerAirline window = new CustomerAirline(CusInfo);
				window.frame.setVisible(true);
			}
		});
		btnBack.setBounds(28, 192, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main window = new Main();
				window.frame.setVisible(true);
			}
		});
		btnBackToMain.setBounds(293, 190, 131, 26);
		frame.getContentPane().add(btnBackToMain);

		
	}
}
