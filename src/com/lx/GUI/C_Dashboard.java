package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lx.Beans.UserBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class C_Dashboard {

	private JFrame frame;
	private JPanel mainPanel,panel,panel_1;
	private UserBean currentUser;

	
	public C_Dashboard(JFrame frame,UserBean currentUser) {
		this.frame=frame;
		this.currentUser = currentUser;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 820);
		mainPanel.setBackground(new Color(0,0,0,0));
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 100);
		//frame.getContentPane().add(panel);
		mainPanel.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(1, 25, 54));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblUsername.setBounds(990, 30, 156, 16);
		panel.add(lblUsername);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFeedback = new JLabel("Feedback Form");
		lblFeedback.setForeground(Color.WHITE);
		lblFeedback.setBounds(161, 114, 97, 16);
		panel_1.add(lblFeedback);
		
		JButton btnFeedback = new JButton("Go");
		btnFeedback.setBounds(161, 143, 97, 25);
		panel_1.add(btnFeedback);
		
		
		if (currentUser !=null) {
			lblUsername.setText(currentUser.getUname());
		}
		
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new Customer_feedback_pg(frame,currentUser);
			}
		});
	}
}
