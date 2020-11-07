package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;

public class AdminQuestions {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtAddQuestions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminQuestions window = new AdminQuestions();
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
	public AdminQuestions() {
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
		frame.setTitle("GrandLuck University - Questions");
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
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBounds(317, 132, 369, 66);
		textField.setColumns(10);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setOpaque(false);
		textField_1.setBounds(304, 311, 396, 143);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JRadioButton rdbtnRadio = new JRadioButton("Radio");
		rdbtnRadio.setOpaque(false);
		rdbtnRadio.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtnRadio.setForeground(Color.WHITE);
		rdbtnRadio.setBackground(new Color(0,0,0,0));
		rdbtnRadio.setBorder(null);
		rdbtnRadio.setFocusable(false);
		rdbtnRadio.setBounds(306, 229, 83, 25);
		panel_1.add(rdbtnRadio);
		
		JRadioButton rdbtnTextArea = new JRadioButton("Text Area");
		rdbtnTextArea.setOpaque(false);
		rdbtnTextArea.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtnTextArea.setForeground(Color.WHITE);
//		rdbtnTextArea.setBackground(new Color(0,0,0,0));
		rdbtnTextArea.setBorder(null);
		rdbtnTextArea.setFocusable(false);
		rdbtnTextArea.setBounds(415, 229, 99, 25);
		panel_1.add(rdbtnTextArea);
		
		txtAddQuestions = new JTextField();
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 22));
		txtAddQuestions.setText("Add Questions");
		txtAddQuestions.setBounds(429, 41, 154, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(0,0,0,0));
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(439, 532, 112, 43);
		panel_1.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new AdminQuestionsList();
			}
		});
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminQuestions.class.getResource("/images/qa.jpg")));
		label.setBounds(0, 49, 1188, 573);
		panel_1.add(label);
		
	}
}
