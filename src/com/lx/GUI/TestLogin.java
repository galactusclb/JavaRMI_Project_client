package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lx.Beans.UserBean;
import com.lx.Interfaces.UsersEvents_Interface;

public class TestLogin {

	private ObjectMapper mapper;
	private UserBean[] user;
//	private Boolean visible = false;
	private JFrame frame;
	
	public TestLogin(JFrame frame) {
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
		
		JLabel lblXdJdnsjnsjd = new JLabel("XD jdnsjnsjd");
		lblXdJdnsjnsjd.setBounds(361, 440, 56, 16);
		panel_1.add(lblXdJdnsjnsjd);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(370, 557, 97, 25);
		panel_1.add(btnGoBack);
		
		btnGoBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				new TestFeedback(frame);
			}
		});
	}
}
