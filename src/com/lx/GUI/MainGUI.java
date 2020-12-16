package com.lx.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("GrandLuck University ");
		frame.setResizable(false);
		frame.setBounds(300, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		frame.setVisible(false);
//		new AdminQuestions(frame,0);
//		new Admin(frame,null);
//		new AdminUsers(frame);
		new login_pg(frame);
//		new Customer_account_pg(frame);
//		new AdminSummaryQuestionList(frame);
//		new AdminQuestionsList2(frame);
//		new C_Dashboard(frame, null);
	}
}
