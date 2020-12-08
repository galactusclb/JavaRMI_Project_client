package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

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
import com.lx.Beans.ClientFeedbackBean;
import com.lx.Beans.FeedBackBean;
import com.lx.Interfaces.FeedBackI;
import com.lx.Interfaces.UsersEvents_Interface;

public class AdminUsers {

	private JFrame frame;
	private JPanel mainPanel, panel, panel_1;
	private JTextField textSearch;

	private String searchedUser = null;

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
		
		JButton btnHome_1 = new JButton("");
		btnHome_1.setIcon(new ImageIcon(AdminUsers.class.getResource("/images/business-report.png")));
		btnHome_1.setOpaque(false);
		btnHome_1.setFocusable(false);
		btnHome_1.setContentAreaFilled(false);
		btnHome_1.setBorder(null);
		btnHome_1.setBackground(new Color(0, 0, 0, 0));
		btnHome_1.setBounds(994, 24, 58, 41);
		panel.add(btnHome_1);

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
		panel_2.setBackground(new Color(0, 0, 0, 0));
		panel_2.setBounds(59, 133, 901, 540);
		panel_2.setVisible(false);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(0, 0, 0, 0));
		panel_3.setBounds(396, 294, 450, 211);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Search Users From Univercity");
		lblNewLabel.setBounds(17, 5, 416, 44);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255, 128));

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AdminUsers.class.getResource("/images/group_edited.png")));
		label_2.setBounds(171, 47, 100, 100);
		panel_3.add(label_2);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JButton btnReport = new JButton("");
		btnReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReport.setBackground(new Color(0, 0, 0, 0));
		btnReport.setContentAreaFilled(false);
		btnReport.setBorder(null);
		btnReport.setOpaque(false);
		btnReport.setFocusable(false);
		btnReport.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/profit-report.png")));
		btnReport.setBounds(831, 95, 44, 39);
		panel_2.add(btnReport);

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
					panel_3.setVisible(true);

					UsersEvents_Interface user = (UsersEvents_Interface) Naming.lookup("rmi://localhost/UserEvents");

					String jString = user.getUsers();

					JSONArray jArray = (JSONArray) new JSONTokener(jString.toString()).nextValue();

					boolean x = true;
					for (int i = 0; i < jArray.length(); i++) {
						JSONObject jObject = jArray.getJSONObject(i);

//						System.out.println(jObject.getString("userID") + " " + jObject.getString("uName") + " "
//								+ jObject.getString("role"));

						if (textSearch.getText().equalsIgnoreCase(jObject.getString("uName"))) {
							panel_2.setVisible(true);
							panel_3.setVisible(false);

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

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPath = System.getProperty("user.dir");
				String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

				// make folder
				File theDir = new File(currentPath + "\\outputs\\userReport");
				if (!theDir.exists()) {
					theDir.mkdirs();
				}
				
				//fonts
				BaseFont baseFont = null;
//				try {
//					baseFont = BaseFont.createFont("res/font/montserratregular.ttf", "UTF-8",BaseFont.EMBEDDED);
//				} catch ( Exception e1) {
//					e1.printStackTrace();
//				}
				
				Font footerN = new Font(FontFactory.TIMES_ROMAN,18, Font.BOLD);

				String fileName = currentPath + "\\outputs\\userReport\\GL_Feedback_UserReport_" + timeStamp + ".pdf";
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
				preBorderBlue.setBorderColorTop(new BaseColor(new Color(255,185,6)));
				preBorderBlue.setBorderWidthTop(3);
				
				tableFooter.addCell(preBorderBlue);
				tableFooter.addCell(footerName);
				tableFooter.addCell(footerEmail);

				
				try {
					PdfWriter.getInstance(document, new FileOutputStream(fileName));
					document.open();

//					Paragraph para = new Paragraph("Test GL_Feedback_QA_"+timeStamp+".pdf");
//					document.add(para);

					Paragraph para = new Paragraph(lblUserNameDetails.getText().toString());
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
					String response = feed.getclientFeedbackSummaryByClientId("chanaka");
					System.out.println(response);
					
					JSONObject obj =new JSONObject(response);
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
							+ "\\outputs\\userReport\\GL_Feedback_UserReport_" + timeStamp + ".pdf");

					System.out.println("pdf create is finished. " + currentPath
							+ "\\outputs\\userReport\\GL_Feedback_UserReport_" + timeStamp + ".pdf");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

//				System.out.println("Working Directory = " + fileName);
			}
		});
	}
}
