package com.lx.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.Preferences;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lx.Beans.FeedBackBean;
import com.lx.Interfaces.FeedBackI;
import com.lx.Interfaces.UsersEvents_Interface;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Customer_account_pg {

	private JFrame frame;
	private JPanel mainPanel, panel, panel_1;

	public Preferences pref;
	private String user = null;
	private JButton btnReport;
	private JLabel txtUserid;
	private JLabel txtUsername;
	private JLabel txtEmail;
	private JLabel txtSubmitStatus;
	private JLabel lblPassword;

	public Customer_account_pg(JFrame frame) {
		pref = Preferences.userRoot().node("cockies");

		if (pref.get("uname", user) != null) {
			user = pref.get("uname", user);
			System.out.println();
		}

		this.frame = frame;
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

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnLogout = new JButton("");
		btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogout.setBorder(null);
		btnLogout.setOpaque(false);
		btnLogout.setBackground(new Color(0, 0, 0, 0));
		btnLogout.setFocusable(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/on-off-button.png")));
		btnLogout.setBounds(1115, 24, 58, 41);
		panel.add(btnLogout);

		JButton btnHome = new JButton("");
		btnHome.setBackground(new Color(0, 0, 0, 0));
		btnHome.setFocusable(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/home.png")));
		btnHome.setBorder(null);
		btnHome.setOpaque(false);
		btnHome.setBounds(1054, 23, 58, 41);
		panel.add(btnHome);

		btnReport = new JButton("");
		btnReport.setIcon(new ImageIcon(Customer_account_pg.class.getResource("/images/profit-report.png")));
		btnReport.setOpaque(false);
		btnReport.setFocusable(false);
		btnReport.setContentAreaFilled(false);
		btnReport.setBorder(null);
		btnReport.setBackground(new Color(0, 0, 0, 0));
		btnReport.setBounds(277, 371, 44, 39);
		btnReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnReport);
		

		JPanel popupDialog = new JPanel();
		popupDialog.setBounds(333, 138, 511, 354);
//		popupDialog.setVisible(false);
//		panel_1.add(popupDialog);

		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setForeground(new Color(255, 186, 8));
		lblUserId.setFont(new Font("Calibri", Font.BOLD, 19));
		lblUserId.setBounds(73, 126, 134, 16);
		panel_1.add(lblUserId);

		txtUserid = new JLabel();
		txtUserid.setFont(new Font("Calibri", Font.PLAIN, 19));
		txtUserid.setForeground(Color.WHITE);
		txtUserid.setBounds(287, 110, 418, 32);
		panel_1.add(txtUserid);

		JLabel lblUserName = new JLabel("User name");
		lblUserName.setForeground(new Color(255, 186, 8));
		lblUserName.setFont(new Font("Calibri", Font.BOLD, 19));
		lblUserName.setBounds(73, 177, 134, 16);
		panel_1.add(lblUserName);

		txtUsername = new JLabel();
		txtUsername.setFont(new Font("Calibri", Font.BOLD, 19));
		txtUsername.setForeground(Color.WHITE);
		txtUsername.setBounds(287, 169, 418, 32);
		panel_1.add(txtUsername);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 186, 8));
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 19));
		lblEmail.setBounds(73, 225, 134, 16);
		panel_1.add(lblEmail);

		txtEmail = new JLabel();
		txtEmail.setFont(new Font("Calibri", Font.BOLD, 19));
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBounds(287, 217, 418, 32);
		panel_1.add(txtEmail);

		JLabel lblSubmitASummary = new JLabel("Submit a summary");
		lblSubmitASummary.setForeground(new Color(255, 186, 8));
		lblSubmitASummary.setFont(new Font("Calibri", Font.BOLD, 19));
		lblSubmitASummary.setBounds(73, 332, 161, 16);
		panel_1.add(lblSubmitASummary);

		txtSubmitStatus = new JLabel();
		txtSubmitStatus.setFont(new Font("Calibri", Font.BOLD, 19));
		txtSubmitStatus.setForeground(Color.WHITE);
		txtSubmitStatus.setBounds(287, 329, 418, 32);
		panel_1.add(txtSubmitStatus);

		lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 186, 8));
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 19));
		lblPassword.setBounds(73, 283, 134, 16);
		panel_1.add(lblPassword);

		JButton btnChange = new JButton("Change");
		btnChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChange.setBorder(null);
		btnChange.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnChange.setFocusable(false);
		btnChange.setBackground(new Color(255, 186, 8));
		btnChange.setBounds(287, 279, 97, 35);
		panel_1.add(btnChange);

		displayDetails();

		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frame.disable();
				Passowrdchange();
			}
		});

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new login_pg(frame);
			}
		});

		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new C_Dashboard(frame, null);
			}
		});

		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPath = System.getProperty("user.dir");
				String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

				// make folder
				File theDir = new File(currentPath + "\\outputs\\clientReport");
				if (!theDir.exists()) {
					theDir.mkdirs();
				}

				// fonts
				BaseFont baseFont = null;
//				try {
//					baseFont = BaseFont.createFont("res/font/montserratregular.ttf", "UTF-8",BaseFont.EMBEDDED);
//				} catch ( Exception e1) {
//					e1.printStackTrace();
//				}

				Font footerN = new Font(FontFactory.TIMES_ROMAN, 18, Font.BOLD);

				String fileName = currentPath + "\\outputs\\clientReport\\GL_Feedback_UserReport_" + timeStamp + ".pdf";
				Document document = new Document(PageSize.A4, 36, 36, 36, 72);

				document.addCreationDate();
				document.addAuthor("Chanaka Laksha");
				document.addCreator("Grandluck.com");

				PdfPTable tableFooter = new PdfPTable(1);
				tableFooter.setTotalWidth(700);

				PdfPCell footerName = new PdfPCell(new Phrase("LOGICCHIP"));
				PdfPCell footerEmail = new PdfPCell(new Phrase("info@logicchip.com"));

				PdfPCell footerEmpty = new PdfPCell(new Phrase(""));

				footerName.setBorder(Rectangle.NO_BORDER);
				footerEmpty.setBorder(Rectangle.NO_BORDER);
				footerEmail.setBorder(Rectangle.NO_BORDER);

				PdfPCell preBorderBlue = new PdfPCell(new Phrase(""));
				preBorderBlue.setMinimumHeight(5f);
				preBorderBlue.setUseVariableBorders(true);
				preBorderBlue.setBorderColorTop(new BaseColor(new Color(255, 185, 6)));
				preBorderBlue.setBorderWidthTop(3);

				tableFooter.addCell(preBorderBlue);
				tableFooter.addCell(footerName);
				tableFooter.addCell(footerEmail);

				try {
					PdfWriter.getInstance(document, new FileOutputStream(fileName));
					document.open();

//					Paragraph para = new Paragraph("Test GL_Feedback_QA_"+timeStamp+".pdf");
//					document.add(para);

					Paragraph para = new Paragraph(user);
					para.setSpacingAfter(35);
					para.setAlignment(Element.ALIGN_CENTER);
					document.add(para);

					para = new Paragraph(" ");
					document.add(para);

					PdfPTable ptable = new PdfPTable(3);
//
					// add table header
					PdfPCell c1 = new PdfPCell(new Phrase("Question ID"));
					ptable.addCell(c1);
					c1 = new PdfPCell(new Phrase("Question"));
					ptable.addCell(c1);
					c1 = new PdfPCell(new Phrase("Answers"));
					ptable.addCell(c1);
					ptable.setHeaderRows(1);
//
					FeedBackI feed = null;
					FeedBackBean[] model = null;
					ObjectMapper mapper = new ObjectMapper();
//
					feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
					String response = feed.getclientFeedbackSummaryByClientId(user);
					System.out.println(response);

					JSONObject obj = new JSONObject(response);
//					System.out.println(obj.getString("QA"));

					model = mapper.readValue(obj.getString("QA"), FeedBackBean[].class);

					for (FeedBackBean feedBackBean : model) {
//						System.out.println(feedBackBean.getQuestion() + " : " + feedBackBean.getSelectedAnswer());

//						for (int j = 0; j < 3; j++) {
						ptable.addCell(Integer.toString(feedBackBean.get_id()));
						ptable.addCell(feedBackBean.getQuestion());
						ptable.addCell(feedBackBean.getSelectedAnswer());
//						}
					}

					document.add(ptable);

					para = new Paragraph(" ");
					para.setSpacingAfter(35);
					document.add(para);

					document.add(tableFooter);

					document.close();

					JOptionPane.showMessageDialog(frame, "Report export successfully.\n " + currentPath
							+ "\\outputs\\clientReport\\GL_Feedback_UserReport_" + timeStamp + ".pdf");

					System.out.println("pdf create is finished. " + currentPath
							+ "\\outputs\\clientReport\\GL_Feedback_UserReport_" + timeStamp + ".pdf");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

//				System.out.println("Working Directory = " + fileName);
			}
		});
	}

	void displayDetails() {
		try {
			UsersEvents_Interface ui = (UsersEvents_Interface) Naming.lookup("rmi://localhost/UserEvents");
			String response = ui.getUserDetails(user);

			System.out.println(response);

			JSONObject jsonobj = new JSONObject(response.toString());

			if (jsonobj.has("email")) {
				txtEmail.setText(jsonobj.getString("email"));
			} else {
				txtEmail.setText("-");
			}
			
			if (jsonobj.has("_id")) {
				txtUserid.setText(Integer.toString(jsonobj.getInt("_id")));
			} else {
				txtUserid.setText("-");
			}

			txtUsername.setText(jsonobj.getString("uname"));

			if (jsonobj.has("date")) {
				txtSubmitStatus.setText(jsonobj.getString("date"));
				btnReport.setVisible(true);
			} else {
				txtSubmitStatus.setText("not yet submit");
				btnReport.setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void Passowrdchange() {

		frame.setEnabled(false);

		JDialog dialog = new JDialog();
		dialog.setTitle("Change Password");
		dialog.setResizable(false);
		dialog.setBounds(700, 390, 490, 360);
		dialog.getContentPane().setLayout(null);
//		contentPanel.setLayout(new FlowLayout());

		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 0, 484, 325);
		contentPanel.setBackground(new Color(1, 24, 55));
		contentPanel.setLayout(null);
		contentPanel.setBorder(new LineBorder(new Color(255, 186, 8), 6, true));

		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		dialog.getContentPane().add(contentPanel, BorderLayout.CENTER);

		{
			JLabel lblCurrentPassword = new JLabel("Current Password");
			lblCurrentPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCurrentPassword.setForeground(new Color(255, 186, 8));
			lblCurrentPassword.setFont(new Font("Calibri", Font.BOLD, 19));
			lblCurrentPassword.setBounds(30, 50, 154, 16);
			contentPanel.add(lblCurrentPassword);

			JPasswordField txtCurrentPassword = new JPasswordField();
			txtCurrentPassword.setFont(new Font("Calibri", Font.BOLD, 19));
			txtCurrentPassword.setForeground(new Color(255, 186, 8));
			txtCurrentPassword.setBounds(210, 42, 220, 32);
			contentPanel.add(txtCurrentPassword);

			JLabel lblNewPassword = new JLabel("New Password");
			lblNewPassword.setForeground(new Color(255, 186, 8));
			lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewPassword.setFont(new Font("Calibri", Font.BOLD, 19));
			lblNewPassword.setBounds(30, 110, 154, 16);
			contentPanel.add(lblNewPassword);

			JPasswordField txtNewPassword = new JPasswordField();
			txtNewPassword.setFont(new Font("Calibri", Font.BOLD, 19));
			txtNewPassword.setForeground(new Color(255, 186, 8));
			txtNewPassword.setBounds(210, 100, 220, 32);
			contentPanel.add(txtNewPassword);

			JLabel lblConfirmPassword = new JLabel("Confirm Password");
			lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblConfirmPassword.setForeground(new Color(255, 186, 8));
			lblConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 19));
			lblConfirmPassword.setBounds(30, 170, 154, 16);
			contentPanel.add(lblConfirmPassword);

			JPasswordField txtConfirmPassword = new JPasswordField();
			txtConfirmPassword.setFont(new Font("Calibri", Font.BOLD, 19));
			txtConfirmPassword.setForeground(new Color(255, 186, 8));
			txtConfirmPassword.setBounds(210, 158, 220, 32);
			contentPanel.add(txtConfirmPassword);

			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setBorder(null);
				okButton.setFont(new Font("Calibri", Font.PLAIN, 19));
				okButton.setFocusable(false);
				okButton.setBackground(new Color(255, 186, 8));
				okButton.setForeground(Color.WHITE);
				okButton.setBounds(260, 250, 80, 40);
				contentPanel.add(okButton);
//				dialog.getRootPane().setDefaultButton(okButton);

				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						try {

							String oldpassword = null;
							String currentpassword = txtCurrentPassword.getText();

							if (!currentpassword.isEmpty()
									&& currentpassword.equals(pref.get("password", oldpassword))) {
								if (!txtNewPassword.getText().isEmpty()
										&& txtNewPassword.getText().equals(txtConfirmPassword.getText())) {
									System.out.println(" same");

									UsersEvents_Interface ui = (UsersEvents_Interface) Naming
											.lookup("rmi://localhost/UserEvents");
									String response = ui.updatePassword(user, txtNewPassword.getText());
									System.out.println(response);
									
									JSONObject obj =new JSONObject(response);
									
									if (obj.has("message") && obj.get("message").equals("success")) {
										frame.setEnabled(true);
										dialog.dispose();
										JOptionPane.showMessageDialog(frame, "password changed successful");	
									}else {
										JOptionPane.showMessageDialog(frame, "password error");
									}
									

								} else {
									System.out.println("not same");
									JOptionPane.showMessageDialog(frame, "new password is empty.");
								}

							} else {
								System.out.println("emp");
								JOptionPane.showMessageDialog(frame, "current password is not match.");
							}

						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setBorder(null);
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 19));
				cancelButton.setFocusable(false);
				cancelButton.setBackground(new Color(230,55,12));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBounds(350, 250, 80, 40);
				contentPanel.add(cancelButton);

				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setEnabled(true);
//						dialog.setVisible(false);
						dialog.dispose();
					}
				});
			}
		}

		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				frame.setEnabled(true);
			}
		});
	}
}
