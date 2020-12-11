package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lx.Beans.FeedBackBean;
import com.lx.Interfaces.FeedBackI;

import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.Rectangle;

public class AdminQuestionsList2 {

	private JFrame frame;
	private JPanel mainPanel, panel, panel_1;
	private JTextField txtAddQuestions;
	private JTable table;

	public AdminQuestionsList2(JFrame frame) {
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

		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/add.png")));
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(null);
		btnAdd.setOpaque(false);
		btnAdd.setFocusable(false);
		btnAdd.setBackground(new Color(0,0,0,0));
//		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAdd.setBounds(1083, 115, 52, 45);
		btnAdd.setToolTipText("<html><div style='padding:15px 10px'>" 
				+ "Add new question"  
				+ "</div></html>");
		UIManager.put("ToolTip.background", Color.ORANGE);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 16));
		panel_1.add(btnAdd);

		JButton btnBack = new JButton("Back");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(null);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnBack.setFocusable(false);
		btnBack.setBackground(new Color(255, 186, 8));
		btnBack.setBounds(1056, 644, 104, 45);
		panel_1.add(btnBack);

		txtAddQuestions = new JTextField();
		txtAddQuestions.setText("Questions");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(new Color(255, 186, 8));
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 28));
		txtAddQuestions.setBounds(554, 49, 139, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);

		JCheckBox checkboxStatus = new JCheckBox("Status ");
		checkboxStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkboxStatus.setFocusable(false);
		checkboxStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkboxStatus.setForeground(Color.WHITE);
		checkboxStatus.setBorder(null);
		checkboxStatus.setOpaque(false);
		checkboxStatus.setBounds(67, 124, 76, 25);
		panel_1.add(checkboxStatus);

		JButton btnReport = new JButton("");
		btnReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReport.setBackground(new Color(0,0,0,0));
		btnReport.setContentAreaFilled(false);
		btnReport.setBorder(null);
		btnReport.setOpaque(false);
		btnReport.setFocusable(false);
		btnReport.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/profit-report.png")));
		btnReport.setBounds(1027, 118, 44, 39);
		btnReport.setToolTipText("<html><div style='padding:15px 10px'>" 
				+ "Generate report"  
				+ "</div></html>");
		UIManager.put("ToolTip.background", Color.ORANGE);
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 16));
		panel_1.add(btnReport);

		JButton btnReload = new JButton("");
		btnReload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReload.setContentAreaFilled(false);
		btnReload.setBorder(null);
		btnReload.setOpaque(false);
		btnReload.setFocusable(false);
		btnReload.setBackground(new Color(0,0,0,0));
		btnReload.setIcon(new ImageIcon(AdminQuestionsList2.class.getResource("/images/reload.png")));
		btnReload.setBounds(145, 119, 44, 39);
		panel_1.add(btnReload);

		displayTable(false);


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
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				new AdminQuestions(frame, 0);
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new Admin(frame, null);
			}
		});

//		table = new JTable();

		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkboxStatus.isSelected()) {
					displayTable(true);
				} else {
					displayTable(false);
				}
			}
		});

		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPath = System.getProperty("user.dir");
				String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

				// make folder
				File theDir = new File(currentPath + "\\outputs");
				if (!theDir.exists()) {
					theDir.mkdirs();
				}

				String fileName = currentPath + "\\outputs\\GL_Feedback_QA_" + timeStamp + ".pdf";
				Document document = new Document();

				try {
					PdfWriter.getInstance(document, new FileOutputStream(fileName));
					document.open();

//					Paragraph para = new Paragraph("Test GL_Feedback_QA_"+timeStamp+".pdf");
//					document.add(para);

					Paragraph para = new Paragraph("Questionnaire List");
					para.setSpacingAfter(35);
					para.setAlignment(Element.ALIGN_CENTER);
					document.add(para);

					para = new Paragraph(" ");
					document.add(para);

					PdfPTable ptable = new PdfPTable(3);

					// add table header
					PdfPCell c1 = new PdfPCell(new Phrase("Question"));
					ptable.addCell(c1);
					c1 = new PdfPCell(new Phrase("Answers"));
					ptable.addCell(c1);
					c1 = new PdfPCell(new Phrase("Type"));
					ptable.addCell(c1);
					ptable.setHeaderRows(1);

					FeedBackI feed = null;
					FeedBackBean[] model = null;
					ObjectMapper mapper = new ObjectMapper();

					feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
					String response = feed.getAllFeedBack(false);
					model = mapper.readValue(response, FeedBackBean[].class);

					for (FeedBackBean fb : model) {
//						for (int j = 0; j < 5; j++) {
						ptable.addCell(fb.getQuestion());
						ptable.addCell(fb.getAnswers());
						ptable.addCell(fb.getType());
//						}
					}
					document.add(ptable);

					document.close();
					
					JOptionPane.showMessageDialog(frame, "Report export successfully.\n "
							+ currentPath + "\\GL_Feedback_QA_" + timeStamp + ".pdf");
					
					System.out.println(
							"pdf create is finished. " + currentPath + "\\GL_Feedback_QA_" + timeStamp + ".pdf");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

//				System.out.println("Working Directory = " + fileName);
			}
		});
	}

	public void displayTable(boolean checked) {
		FeedBackI feed = null;
		FeedBackBean[] model = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
			String response = feed.getAllFeedBack(checked);
			model = mapper.readValue(response, FeedBackBean[].class);

//			JSONArray objArray = new JSONArray();
//			
//			for (FeedBackBean fb : model) {
//				JSONObject subObj = new JSONObject();
////				System.out.println("  type : " + fb.getType());
//				subObj.put("_id",fb.get_id());
//				subObj.put("type", fb.getType());
//				subObj.put("question", fb.getQuestion());
//				subObj.put("answers", fb.getAnswers());
//				subObj.put("order", fb.getOrder());
//				
//				objArray.add(subObj);
//			}
//			System.out.println(objArray);

//			for(FeedBackBean fb:gg){
//				System.out.println("  type : "+ fb.getType());
//			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

//		Object[][] data = {
//				{1,"radio","Do you satisfy about our lecture panel ?","Excellent, Great,Bad,Very Bad",0}
//		};

		Object[][] data = new Object[model.length][6];

		int k = 0;
		for (FeedBackBean fb : model) {
			for (int j = 0; j < 5; j++) {
				if (j == 0) {
					data[k][j] = fb.get_id();
				} else if (j == 1) {
					data[k][j] = fb.getOrder();
				} else if (j == 2) {
					data[k][j] = fb.getType();
				} else if (j == 3) {
					data[k][j] = fb.getQuestion();
				} else if (j == 4) {
					data[k][j] = fb.getAnswers();
				}
//		        data[i][j] = i + " gg "+ j;
			}
			++k;
		}

//		for (int i = 0; i < model.length; i++)
//		{
//		    for (int j =  0; j < 5; j++)
//		    {
//		    	if (j == 0) {
//					
//				}
//		        data[i][j] = i + " gg "+ j;
//		    }
//		}

//			{ { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
//				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
//				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
//				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
//				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

		String[] columnNames = { "Id", "order", "type", "question", "answers" };

		JTable jt = new JTable(data, columnNames);
		jt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jt.setSelectionBackground(Color.ORANGE);
		jt.setRowHeight(22);
		jt.setBackground(Color.white);
		jt.setFont(new Font("Calibri", Font.PLAIN, 18));

		JTableHeader header = jt.getTableHeader();
		header.setBackground(Color.BLACK);
		header.setForeground(new Color(255, 186, 8));
		header.setFont(new Font("Calibri", Font.BOLD, 19));
		header.setPreferredSize(new Dimension(100, 50));

		TableColumn column = null;
		for (int i = 0; i < 3; i++) {
			column = jt.getColumnModel().getColumn(i);
			if (i == 0)
				column.setMaxWidth(50);
			if (i == 1)
				column.setMaxWidth(50);
//		    if (i == 2)
//		        column.setMaxWidth(100);
//		    if (i == 3)
//		        column.setMaxWidth(468);
			if (i == 2)
				column.setMaxWidth(100);
		}

//		jt.getColumnModel().getColumn(0).setWidth(1);
//		jt.setBounds(80,139,964,300); 

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(38, 182, 1122, 400);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setViewportView(jt);
		panel_1.add(scrollPane);

		// get clicked row
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {

				if (!event.getValueIsAdjusting()) {
					int selectedData = 0;

					int selectedRow = jt.getSelectedRow();
//		    	    int selectedColumns = jt.getSelectedColumn();

					for (int i = 0; i <= selectedRow; i++) {
						for (int j = 0; j < 1; j++) {
							selectedData = (int) jt.getValueAt(selectedRow, 0);
						}
					}
//		    	    System.out.println("Selected: " + Integer.toString(selectedData));
					mainPanel.setVisible(false);
					new AdminQuestions(frame, selectedData);
				}
			}
		});
	}
}
