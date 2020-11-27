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
		
		JButton btnLogout = new JButton("");
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setIcon(new ImageIcon(C_Dashboard.class.getResource("/images/on-off-button.png")));
		btnLogout.setOpaque(false);
		btnLogout.setFocusable(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(0, 0, 0, 0));
		btnLogout.setBounds(1115, 24, 58, 41);
		panel.add(btnLogout);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblUsername.setBounds(951, 39, 156, 16);
		panel.add(lblUsername);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel tileU = new JPanel();
		tileU.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tileU.setLayout(null);
		tileU.setOpaque(false);
		tileU.setBorder(null);
		tileU.setBounds(115, 126, 182, 206);
		panel_1.add(tileU);
		
		JButton btnFeedbacks = new JButton("");
		btnFeedbacks.setOpaque(false);
		btnFeedbacks.setFocusable(false);
		btnFeedbacks.setContentAreaFilled(false);
		btnFeedbacks.setBorder(null);
		btnFeedbacks.setBackground(new Color(0, 0, 0, 0));
		btnFeedbacks.setBounds(0, 5, 175, 198);
		tileU.add(btnFeedbacks);
		
		JLabel lblFIcon = new JLabel("");
		lblFIcon.setIcon(new ImageIcon(C_Dashboard.class.getResource("/images/activity.png")));
		lblFIcon.setBounds(77, 76, 21, 24);
		tileU.add(lblFIcon);
		
		JLabel lblFLbl = new JLabel("FEEDBACK");
		lblFLbl.setForeground(new Color(255, 186, 8));
		lblFLbl.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFLbl.setBounds(48, 139, 90, 23);
		tileU.add(lblFLbl);
		
		JLabel lblF = new JLabel("");
		lblF.setIcon(new ImageIcon(C_Dashboard.class.getResource("/images/Rectangle_2.png")));
		lblF.setBounds(0, 5, 175, 198);
		tileU.add(lblF);
		
		
		if (currentUser !=null) {
			lblUsername.setText(currentUser.getUname());
		}
		
		btnFeedbacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new Customer_feedback_pg(frame,currentUser);
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
