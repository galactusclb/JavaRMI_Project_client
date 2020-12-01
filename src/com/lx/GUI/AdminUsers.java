package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.lx.Interfaces.UsersEvents_Interface;

public class AdminUsers {

	private JFrame frame;
	private JPanel mainPanel, panel, panel_1;
	private JTextField textSearch;

	
	public AdminUsers(JFrame frame) {
		this.frame = frame;
		initialize();
	}

	
	private void initialize() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 820);
		mainPanel.setBackground(new Color(0, 0, 0, 0));
//		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 100);
		// frame.getContentPane().add(panel);
		mainPanel.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(1, 25, 54));
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
		
		JButton btnHome = new JButton("");
		btnHome.setBackground(new Color(0,0,0,0));
		btnHome.setFocusable(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/home.png")));
		btnHome.setBorder(null);
		btnHome.setOpaque(false);
		btnHome.setBounds(1054, 23, 58, 41);
		panel.add(btnHome);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserDetails = new JLabel("User Details");
		lblUserDetails.setBorder(null);
		lblUserDetails.setOpaque(false);
		lblUserDetails.setForeground(new Color(255, 186, 8));
		lblUserDetails.setFont(new Font("Calibri", Font.PLAIN, 28));
		lblUserDetails.setBounds(59, 29, 201, 26);
		panel_1.add(lblUserDetails);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Calibri", Font.PLAIN, 18));
		textSearch.setBorder(null);
		textSearch.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		textSearch.setBounds(59, 72, 266, 45);
		panel_1.add(textSearch);
		textSearch.setColumns(10);
		
		JButton btnSearch = new JButton();
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnSearch.setContentAreaFilled(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorder(null);
//		btnSearch.setOpaque(false);
		btnSearch.setFocusable(false);
		btnSearch.setIcon(new ImageIcon(AdminUsers.class.getResource("/images/search_2.png")));
		btnSearch.setBounds(324, 72, 55, 45);
		panel_1.add(btnSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0,0,0,0));
		panel_2.setBounds(59, 133, 901, 540);
		panel_2.setVisible(false);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminUsers.class.getResource("/images/graduation-hat.png")));
		label.setBounds(12, 13, 282, 328);
		panel_2.add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 186, 8));
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 19));
		lblUsername.setBounds(330, 95, 109, 32);
		panel_2.add(lblUsername);
		
		JLabel lblUserNameDetails = new JLabel("");
		lblUserNameDetails.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblUserNameDetails.setForeground(Color.WHITE);
		lblUserNameDetails.setBounds(437, 97, 202, 30);
		panel_2.add(lblUserNameDetails);
		
		JLabel lblUid = new JLabel("UID");
		lblUid.setForeground(new Color(255, 186, 8));
		lblUid.setFont(new Font("Calibri", Font.BOLD, 19));
		lblUid.setBounds(330, 130, 109, 32);
		panel_2.add(lblUid);
		
		JLabel lblUIDDetails = new JLabel("");
		lblUIDDetails.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblUIDDetails.setForeground(Color.WHITE);
		lblUIDDetails.setBounds(437, 130, 202, 30);
		panel_2.add(lblUIDDetails);
		
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new Admin(frame, null);
			}
		});

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				new login_pg(frame);
			}
		});
		

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					panel_2.setVisible(false);
					
					UsersEvents_Interface user = (UsersEvents_Interface) Naming.lookup("rmi://localhost/UserEvents");
					
					String jString = user.getUsers();
					
					JSONArray jArray = (JSONArray) new JSONTokener(jString.toString()).nextValue();
					
					boolean x =true;
					for (int i = 0; i < jArray.length(); i++) {
						JSONObject jObject = jArray.getJSONObject(i);
						
//						System.out.println(jObject.getString("userID") + " " + jObject.getString("uName") + " "
//								+ jObject.getString("role"));
						
						if (textSearch.getText().equalsIgnoreCase(jObject.getString("uName"))) {
							panel_2.setVisible(true);
							lblUserNameDetails.setText(jObject.getString("uName"));
							lblUIDDetails.setText(jObject.getString("userID"));
							
							x = false;
						}
//						else if( i == (jArray.length() -1 ) && !textSearch.getText().equalsIgnoreCase(jObject.getString("uName"))){
//							JOptionPane.showMessageDialog(frame, "No user found!");
//						}
					}
					
					if (x) {
						JOptionPane.showMessageDialog(frame, "No user found!");
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
