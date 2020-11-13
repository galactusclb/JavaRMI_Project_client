package com.lx.GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lx.Beans.UserBean;
import com.lx.Interfaces.UsersEvents_Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import java.awt.Cursor;

public class login_pg {

	private ObjectMapper mapper;
	private UserBean[] user;

	private JFrame frame;
	private JPanel panel;
	private JTextField uname;
	private JPasswordField pass;
	
	/**
	 * Create the application.
	 */
	public login_pg(JFrame frame) {
		this.frame = frame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel = new JPanel();
		panel.setVisible(true);
		panel.setBounds(0, 0, 1194, 815);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		uname = new JTextField();
		uname.setForeground(new Color(102, 102, 102));
		uname.setFont(new Font("Calibri", Font.PLAIN, 24));
		uname.setText("");
		uname.setOpaque(false);
		uname.setBorder(null);
		uname.setBounds(761, 315, 256, 35);
		uname.setColumns(10);
		panel.add(uname);

		pass = new JPasswordField();
		pass.setText("");
		pass.setOpaque(false);
		pass.setForeground(new Color(102, 102, 102));
		pass.setFont(new Font("Calibri", Font.PLAIN, 24));
		pass.setColumns(10);
		pass.setBorder(null);
		pass.setBounds(761, 390, 256, 35);
		panel.add(pass);

		JButton btnLogin = new JButton("");
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBounds(678, 478, 365, 65);
		panel.add(btnLogin);

		JLabel lblS = new JLabel("");
		lblS.setBackground(Color.WHITE);
		lblS.setIcon(new ImageIcon(login_pg.class.getResource("/images/login_bg_2.jpg")));
		lblS.setBounds(0, 0, 1182, 803);
		panel.add(lblS);
		
		mapper = new ObjectMapper();
		
		try {
			user = mapper.readValue(new File("users.json"), UserBean[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = uname.getText();
				String password = pass.getText();
				
				Boolean resulte = false;
				String role = null ;
				System.out.println("xd : "+role);
				
				try {
					UsersEvents_Interface user = (UsersEvents_Interface) Naming.lookup("rmi://localhost/UserEvents");
					
					role = user.Login(username,password);
					
					if (role != null && !role.trim().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Succesfully Logged");
						
						if(role.equals("admin")) {
							panel.setVisible(false);
							new Admin(frame);						
						}else {
							panel.setVisible(false);
							new Customer_feedback_pg(frame);			
						}
					}else {
						JOptionPane.showMessageDialog(frame, "Invalid username or password");
					}
					
					
				} catch (MalformedURLException err) {
					err.printStackTrace();
				} catch (RemoteException err) {
					err.printStackTrace();
				} catch (NotBoundException err) {
					err.printStackTrace();
				} catch (Exception err)  {
					err.printStackTrace();
				}				
			}
		});
}	
}
