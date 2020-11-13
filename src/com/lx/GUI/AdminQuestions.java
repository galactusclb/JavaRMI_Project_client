package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.codehaus.jackson.map.ObjectMapper;

import com.lx.Beans.ResponsJsonBean;
import com.lx.Interfaces.FeedBackI;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextArea;

public class AdminQuestions {

	private JFrame frame;
	private JTextArea txtQuestion, txtAnswers;
	private JTextField txtAddQuestions;
	private ButtonGroup radion_qType_group;
	private JButton btnSave, btnCancel;

	private FeedBackI feed;
	private JTextField txtOrder;

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
		label_1.setBackground(new Color(1, 25, 54));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		txtQuestion = new JTextArea();
		txtQuestion.setLineWrap(true);
		txtQuestion.setWrapStyleWord(true);
		txtQuestion.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtQuestion.setBorder(null);
		txtQuestion.setOpaque(false);
		txtQuestion.setBounds(304, 122, 396, 82);
		txtQuestion.setColumns(10);
		panel_1.add(txtQuestion);

		txtAnswers = new JTextArea();
		txtAnswers.setLineWrap(true);
		txtAnswers.setBorder(null);
		txtAnswers.setOpaque(false);
		txtAnswers.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtAnswers.setBounds(304, 311, 396, 143);
		txtAnswers.setColumns(10);
		panel_1.add(txtAnswers);
		
		JRadioButton rdbtn_radio = new JRadioButton("Radio");
		rdbtn_radio.setActionCommand("radio");
		rdbtn_radio.setOpaque(false);
		rdbtn_radio.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtn_radio.setForeground(Color.WHITE);
		rdbtn_radio.setBackground(new Color(0, 0, 0, 0));
		rdbtn_radio.setBorder(null);
		rdbtn_radio.setFocusable(false);
		rdbtn_radio.setBounds(306, 229, 83, 25);
		panel_1.add(rdbtn_radio);

		JRadioButton rdbtn_txtArea = new JRadioButton("Text Area");
		rdbtn_txtArea.setActionCommand("textarea");
		rdbtn_txtArea.setOpaque(false);
		rdbtn_txtArea.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtn_txtArea.setForeground(Color.WHITE);
//		rdbtnTextArea.setBackground(new Color(0,0,0,0));
		rdbtn_txtArea.setBorder(null);
		rdbtn_txtArea.setFocusable(false);
		rdbtn_txtArea.setBounds(415, 229, 99, 25);
		panel_1.add(rdbtn_txtArea);

		JRadioButton rdbtn_checkBox = new JRadioButton("Check Box");
		rdbtn_checkBox.setActionCommand("checkbox");
		rdbtn_checkBox.setOpaque(false);
		rdbtn_checkBox.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtn_checkBox.setForeground(Color.WHITE);
		rdbtn_checkBox.setFocusable(false);
		rdbtn_checkBox.setBorder(null);
		rdbtn_checkBox.setBounds(544, 229, 119, 25);
		panel_1.add(rdbtn_checkBox);
		
		radion_qType_group= new ButtonGroup();
		radion_qType_group.add(rdbtn_radio);
		radion_qType_group.add(rdbtn_txtArea);
		radion_qType_group.add(rdbtn_checkBox);
		
		txtAddQuestions = new JTextField();
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 22));
		txtAddQuestions.setText("Add Questions");
		txtAddQuestions.setBounds(429, 41, 154, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);
		
		txtOrder = new JTextField();
		txtOrder.setBounds(301, 267, 119, 22);
		panel_1.add(txtOrder);
		txtOrder.setColumns(10);

		btnCancel = new JButton("");
		btnCancel.setBackground(new Color(0, 0, 0, 0));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setOpaque(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setFocusable(false);
		btnCancel.setBounds(439, 532, 112, 43);
		panel_1.add(btnCancel);

		btnSave = new JButton("");
		btnSave.setBackground(new Color(0, 0, 0, 0));
		btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false);
		btnSave.setBorderPainted(false);
		btnSave.setFocusable(false);
		btnSave.setBounds(292, 532, 119, 43);
		panel_1.add(btnSave);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminQuestions.class.getResource("/images/qa.jpg")));
		label.setBounds(0, 49, 1188, 573);
		panel_1.add(label);

		
		
		
//		rdbtn_radio.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				rdbtn_txtArea.setSelected(false);
//				rdbtn_radio.setSelected(true);
//				rdbtn_checkBox.setSelected(false);
//			}
//		});
//		rdbtn_txtArea.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				rdbtn_txtArea.setSelected(true);
//				rdbtn_radio.setSelected(false);
//				rdbtn_checkBox.setSelected(false);
//			}
//		});
//		rdbtn_checkBox.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				rdbtn_txtArea.setSelected(false);
//				rdbtn_radio.setSelected(false);
//				rdbtn_checkBox.setSelected(true);
//			}
//		});
		
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new AdminQuestionsList();
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					String type = null;
					String question = txtQuestion.getText();
					String answers = txtAnswers.getText();
					int order = Integer.parseInt(txtOrder.getText());

					if (rdbtn_checkBox.isSelected()) {
						type = rdbtn_checkBox.getActionCommand();
					} else if(rdbtn_txtArea.isSelected()){
						type = rdbtn_txtArea.getActionCommand();
					}else {
						type = rdbtn_radio.getActionCommand();
					}
					
					feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
					String res = feed.addFeedBack(type, question, answers, order);
//					System.out.println(res);
					
					ObjectMapper mapper = new ObjectMapper();
					ResponsJsonBean model = mapper.readValue(res, ResponsJsonBean.class);
					
					System.out.println(model.getMessage());
					
					if(model.getStatus() == 400) {
						JOptionPane.showMessageDialog(frame, model.getMessage(),"Successful", JOptionPane.QUESTION_MESSAGE,new ImageIcon("images/logo.png"));
					}else {
						JOptionPane.showMessageDialog(frame, model.getMessage());
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
