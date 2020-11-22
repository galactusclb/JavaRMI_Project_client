package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Admin {

	private JFrame frame;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Admin window = new Admin();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Admin(JFrame frame) {
		this.frame=frame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.getContentPane().setBackground(new Color(245, 245, 245));
//		frame.getContentPane().setLayout(null);
//		frame.setVisible(true);
//		frame.setTitle("GrandLuck University - Admin");
//		frame.setResizable(false);
//		frame.setBounds(300, 100, 1200, 850);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(1,25,54));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(224, 58, 0));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnLogout.setOpaque(false);
//		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(null);
		btnLogout.setFocusable(false);
		btnLogout.setBounds(1019, 36, 97, 25);
		panel.add(btnLogout);

		JPanel panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextField txtAddQuestions = new JTextField();
		txtAddQuestions.setText("Admin Dashboard");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 30));
		txtAddQuestions.setBounds(486, 27, 256, 65);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);
		
//		JButton btnCustomizeQuestions = new JButton("Customize Questions");
		JButton btnCustomizeQuestions = new JButton("");
		btnCustomizeQuestions.setBackground(new Color(0,0,0,0));
		btnCustomizeQuestions.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCustomizeQuestions.setOpaque(false);
		btnCustomizeQuestions.setContentAreaFilled(false);
		btnCustomizeQuestions.setFocusable(false);
		btnCustomizeQuestions.setBorder(null);
		btnCustomizeQuestions.setBounds(206, 135, 170, 155);
		panel_1.add(btnCustomizeQuestions);
		
		//Summary btn
		JButton btnSummary = new JButton("");
		btnSummary.setBackground(new Color(0,0,0,0));
		btnSummary.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSummary.setOpaque(false);
		btnSummary.setContentAreaFilled(false);
		btnSummary.setFocusable(false);
		btnSummary.setBorder(null);
		btnSummary.setBounds(516, 135, 170, 155);
		panel_1.add(btnSummary);
		
		//users btn
		JButton btnUsers = new JButton("");
		btnUsers.setBackground(new Color(0,0,0,0));
		btnUsers.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnUsers.setOpaque(false);
		btnUsers.setContentAreaFilled(false);
		btnUsers.setFocusable(false);
		btnUsers.setBorder(null);
		btnUsers.setBounds(825, 135, 170, 155);
		panel_1.add(btnUsers);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/images/admin dashboard.jpg")));
		lblNewLabel.setBounds(0, 0, 1200, 720);
		panel_1.add(lblNewLabel);
		
		btnCustomizeQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				new AdminQuestionsList2(frame);
			}
		});
		
		btnSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new AdminSummary();
			}
		});
		
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				new login_pg(frame);
			}
		});
		
	}
}
