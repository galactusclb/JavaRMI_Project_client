package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Panel;

public class AdminQuestionsList {

	private JFrame frame;
	private JTextField txtAddQuestions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminQuestionsList window = new AdminQuestionsList();
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
	public AdminQuestionsList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("GrandLuck University - Summary ");
		frame.setResizable(false);
		frame.setBounds(300, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(1,25,54));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtAddQuestions = new JTextField();
		txtAddQuestions.setText("Questions");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 28));
		txtAddQuestions.setBounds(532, 49, 161, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAdd.setBackground(new Color(255,186,8));
		btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnAdd.setOpaque(false);
//		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(null);
		btnAdd.setFocusable(false);
		btnAdd.setBounds(1022, 46, 112, 45);
		panel_1.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnBack.setBackground(new Color(0,0,0,0));
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(1022, 635, 112, 45);
		panel_1.add(btnBack);
		
				
		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(AdminQuestions.class.getResource("/images/qa.jpg")));
		label.setBounds(0, 49, 1188, 573);
		panel_1.add(label);
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
//				new Admin();
			}
		});
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false);
				new Admin(frame);
			}
		});
	}
}
