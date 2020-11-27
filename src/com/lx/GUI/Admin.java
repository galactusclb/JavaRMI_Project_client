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

import com.lx.Beans.UserBean;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Admin {

	private JFrame frame;
	private UserBean currentUser;
	private JPanel mainPanel,panel,panel_1;
	
	
	public Admin(JFrame frame,UserBean currentUser) {
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
		mainPanel.setBackground(new Color(0, 0, 0, 0));
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 100);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(1,25,54));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);
		
		JButton btnLogout = new JButton("");
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBorder(null);
		btnLogout.setOpaque(false);
		btnLogout.setBackground(new Color(0,0,0,0));
		btnLogout.setFocusable(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/on-off-button.png")));
		btnLogout.setBounds(1115, 24, 58, 41);
		panel.add(btnLogout);

		panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		mainPanel.add(panel_1);
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
		
//		JButton btnCustomizeQuestions = new JButton("");
//		btnCustomizeQuestions.setBackground(new Color(0,0,0,0));
//		btnCustomizeQuestions.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnCustomizeQuestions.setOpaque(false);
//		btnCustomizeQuestions.setContentAreaFilled(false);
//		btnCustomizeQuestions.setFocusable(false);
//		btnCustomizeQuestions.setBorder(null);
//		btnCustomizeQuestions.setBounds(720, 135, 176, 194);
//		panel_1.add(btnCustomizeQuestions);
		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/images/admin dashboard.jpg")));
//		lblNewLabel.setBounds(0, 0, 1200, 720);
//		panel_1.add(lblNewLabel);
		
		
		JPanel tileS = new JPanel();
		tileS.setLayout(null);
		tileS.setOpaque(false);
		tileS.setBorder(null);
		tileS.setBounds(495, 127, 182, 206);
		panel_1.add(tileS);
		
		JButton btnSummary = new JButton("");
		btnSummary.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSummary.setOpaque(false);
		btnSummary.setFocusable(false);
		btnSummary.setContentAreaFilled(false);
		btnSummary.setBorder(null);
		btnSummary.setBackground(new Color(0, 0, 0, 0));
		btnSummary.setBounds(0, 5, 175, 198);
		tileS.add(btnSummary);
		
		JLabel lblSIcon = new JLabel("");
		lblSIcon.setIcon(new ImageIcon(Admin.class.getResource("/images/activity.png")));
		lblSIcon.setBounds(77, 76, 21, 24);
		tileS.add(lblSIcon);
		
		JLabel lblSLbl = new JLabel("SUMMARY");
		lblSLbl.setForeground(new Color(255, 186, 8));
		lblSLbl.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSLbl.setBounds(50, 139, 87, 23);
		tileS.add(lblSLbl);
		
		JLabel lblS = new JLabel("");
		lblS.setIcon(new ImageIcon(Admin.class.getResource("/images/Rectangle_2.png")));
		lblS.setBounds(0, 5, 175, 198);
		tileS.add(lblS);
		
		JPanel tileQ = new JPanel();
		tileQ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tileQ.setBorder(null);
		tileQ.setOpaque(false);
		tileQ.setBounds(177, 127, 182, 206);
		panel_1.add(tileQ);
		tileQ.setLayout(null);
		
		//Summary btn
		JButton btnQuestions = new JButton("");
		btnQuestions.setBounds(0, 5, 175, 198);
		tileQ.add(btnQuestions);
		btnQuestions.setBackground(new Color(0,0,0,0));
		btnQuestions.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnQuestions.setOpaque(false);
		btnQuestions.setContentAreaFilled(false);
		btnQuestions.setFocusable(false);
		btnQuestions.setBorder(null);
		
		JLabel lblQIcon = new JLabel("");
		lblQIcon.setBounds(77, 76, 21, 24);
		tileQ.add(lblQIcon);
		lblQIcon.setIcon(new ImageIcon(Admin.class.getResource("/images/addfolderalt.png")));
		
		JLabel lblQLbl = new JLabel("QUESTIONS");
		lblQLbl.setBounds(44, 139, 87, 23);
		tileQ.add(lblQLbl);
		lblQLbl.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblQLbl.setForeground(new Color(255, 186, 8));
		
		JLabel lblQ = new JLabel("");
		lblQ.setBounds(0, 5, 175, 198);
		tileQ.add(lblQ);
		lblQ.setIcon(new ImageIcon(Admin.class.getResource("/images/Rectangle_2.png")));
		
		JPanel tileU = new JPanel();
		tileU.setBounds(833, 127, 182, 206);
		panel_1.add(tileU);
		tileU.setLayout(null);
		tileU.setOpaque(false);
		tileU.setBorder(null);
		
		JButton btnUsers = new JButton("");
		btnUsers.setOpaque(false);
		btnUsers.setFocusable(false);
		btnUsers.setContentAreaFilled(false);
		btnUsers.setBorder(null);
		btnUsers.setBackground(new Color(0, 0, 0, 0));
		btnUsers.setBounds(0, 5, 175, 198);
		tileU.add(btnUsers);
		
		JLabel lblUIcon = new JLabel("");
		lblUIcon.setIcon(new ImageIcon(Admin.class.getResource("/images/t_users.png")));
		lblUIcon.setBounds(77, 76, 21, 24);
		tileU.add(lblUIcon);
		
		JLabel lblULbl = new JLabel("USERS");
		lblULbl.setForeground(new Color(255, 186, 8));
		lblULbl.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblULbl.setBounds(65, 139, 60, 23);
		tileU.add(lblULbl);
		
		JLabel lblU = new JLabel("");
		lblU.setIcon(new ImageIcon(Admin.class.getResource("/images/Rectangle_2.png")));
		lblU.setBounds(0, 5, 175, 198);
		tileU.add(lblU);
		
		btnSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new AdminSummaryQuestionList(frame);
			}
		});
		
		btnQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new AdminQuestionsList2(frame);
			}
		});
		
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new login_pg(frame);
			}
		});
		
	}
}
