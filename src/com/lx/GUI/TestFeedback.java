package com.lx.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFeedback {

	private JFrame frame;
	private Boolean visible = false;
	
	/**
	 * Create the application.
	 */
	public TestFeedback(JFrame frame) {
		this.frame = frame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBounds(0, 0, 1194, 815);
		panel_1.setLayout(null);
		frame.getContentPane().add(panel_1);
		
		JLabel lblXdJdnsjnsjd = new JLabel("Feedback pannel");
		lblXdJdnsjnsjd.setBounds(361, 440, 56, 16);
		panel_1.add(lblXdJdnsjnsjd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(370, 557, 97, 25);
		panel_1.add(btnGoBack);
		
		btnGoBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				new TestLogin(frame);
			}
		});
	}

}
