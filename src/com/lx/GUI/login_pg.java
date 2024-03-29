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
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

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
import java.util.prefs.Preferences;

import javax.swing.JButton;
import java.awt.Cursor;

public class login_pg {

	private ObjectMapper mapper;
	private UserBean currentUser = new UserBean();

	private JFrame frame;
	private JPanel panel;
	private JTextField txtuname;
	private JPasswordField txtpass;

	public Preferences pref;

	public final static Cursor busyCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
	public final static Cursor defaultCursor = Cursor.getDefaultCursor();

	public login_pg(JFrame frame) {
		pref = Preferences.userRoot().node("cockies");

		this.frame = frame;
		initialize();

		String user = null;
		String role = null;
		String pass = null;

		System.out.println(pref.get("uname", user));

		//get logged details  
		if (pref.get("uname", user) != null && pref.get("password", pass) != null && pref.get("role", role) != null) {
			txtuname.setText(pref.get("uname", user));
			txtpass.setText(pref.get("password", pass));
		} else {

		}
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

		txtuname = new JTextField();
		txtuname.setForeground(new Color(102, 102, 102));
		txtuname.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtuname.setText("");
		txtuname.setOpaque(false);
		txtuname.setBorder(null);
		txtuname.setBounds(761, 322, 256, 35);
		txtuname.setColumns(10);
		panel.add(txtuname);

		txtpass = new JPasswordField();
		txtpass.setText("");
		txtpass.setOpaque(false);
		txtpass.setForeground(new Color(102, 102, 102));
		txtpass.setFont(new Font("Calibri", Font.PLAIN, 24));
		txtpass.setColumns(10);
		txtpass.setBorder(null);
		txtpass.setBounds(761, 397, 256, 35);
		panel.add(txtpass);

		JButton btnLogin = new JButton("");
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBounds(678, 483, 365, 65);
		panel.add(btnLogin);

		JLabel lblS = new JLabel("");
		lblS.setBackground(Color.WHITE);
		lblS.setIcon(new ImageIcon(login_pg.class.getResource("/images/login_bg_2.jpg")));
		lblS.setBounds(0, 0, 1194, 815);
		panel.add(lblS);

		mapper = new ObjectMapper();

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setCursor(busyCursor);
				btnLogin.setCursor(busyCursor);
				btnLogin.setEnabled(false);

				String username = txtuname.getText();
				String password = txtpass.getText();

				String resulte = null;

				try {
					
					//connect server
					UsersEvents_Interface user = (UsersEvents_Interface) Naming.lookup("rmi://localhost/UserEvents");

					resulte = user.LoginUsersApi(username, password);

					frame.setCursor(defaultCursor);
					btnLogin.setCursor(defaultCursor);
					btnLogin.setEnabled(true);

					System.out.println("logged role : " + resulte);

					JSONObject jObject = null;

					if (resulte != null) {
						jObject = new JSONObject(resulte);

						if (jObject.has("role")) {
							JOptionPane.showMessageDialog(frame, "Succesfully Logged");

							currentUser.setUname(username);
							currentUser.setRole(jObject.getString("role"));

							setCockies(username, password, jObject.getString("role"));

							if (jObject.getString("role").equalsIgnoreCase("admin")) {
								panel.setVisible(false);
								new Admin(frame, currentUser);
							} else {
								panel.setVisible(false);
								new C_Dashboard(frame, currentUser);
							}

						} else {
							JOptionPane.showMessageDialog(frame, "Invalid username or password");
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Invalid username or password");
					}

				} catch (Exception err) {
					err.printStackTrace();
				}
			}
		});
	}

	
	//create cookies for logged user
	public void setCockies(String uname, String password, String role) {

		pref.put("uname", uname);
		pref.put("password", password);
		pref.put("role", role);

		System.out.println("Saved.");
	}
}
