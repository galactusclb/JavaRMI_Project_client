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
	private JTextField txtType;
	private JTextField txtQuestion;
	private JTextField txtOrder;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		txtAddQuestions.setText("Question List");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 28));
		txtAddQuestions.setBounds(432, 50, 220, 37);
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
		btnAdd.setBounds(1022, 184, 112, 45);
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
		
		txtType = new JTextField();
		txtType.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtType.setForeground(Color.WHITE);
		txtType.setOpaque(false);
		txtType.setBorder(null);
		txtType.setText("Type");
		txtType.setBounds(706, 139, 116, 22);
		panel_1.add(txtType);
		txtType.setColumns(10);
		
		txtQuestion = new JTextField();
		txtQuestion.setForeground(Color.WHITE);
		txtQuestion.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtQuestion.setOpaque(false);
		txtQuestion.setBorder(null);
		txtQuestion.setText("Question");
		txtQuestion.setBounds(457, 139, 116, 22);
		panel_1.add(txtQuestion);
		txtQuestion.setColumns(10);
		
		txtOrder = new JTextField();
		txtOrder.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtOrder.setForeground(Color.WHITE);
		txtOrder.setBorder(null);
		txtOrder.setOpaque(false);
		txtOrder.setText("Order");
		txtOrder.setBounds(216, 139, 76, 22);
		panel_1.add(txtOrder);
		txtOrder.setColumns(10);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(195, 172, 614, 2);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(351, 139, 1, 483);
		panel_1.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(633, 139, 1, 483);
		panel_1.add(panel_3_1);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(216, 196, 76, 22);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Do you satisfy about our lecture");
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(380, 196, 241, 22);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("radio");
		textField_2.setOpaque(false);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(695, 196, 76, 22);
		panel_1.add(textField_2);
		
				
		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(AdminQuestions.class.getResource("/images/qa.jpg")));
		label.setBounds(0, 49, 1188, 573);
		panel_1.add(label);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnDelete.setBackground(new Color(230,55,12));
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDelete.setBorder(null);
		btnDelete.setFocusable(false);
		btnDelete.setBounds(821, 195, 97, 25);
		panel_1.add(btnDelete);
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Admin();
			}
		});
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new AdminQuestions();
			}
		});
	}
}
