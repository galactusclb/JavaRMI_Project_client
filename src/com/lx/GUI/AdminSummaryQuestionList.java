package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.net.URLEncoder;
import java.rmi.Naming;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONObject;

import com.lx.Beans.FeedBackBean;
import com.lx.Interfaces.FeedBackI;
import javax.swing.JRadioButton;

public class AdminSummaryQuestionList {

	private JFrame frame;
	private JPanel mainPanel, panel, panel_1;
	private JTextField txtAddQuestions;
	private JButton btnBack;

	public final static Cursor busyCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
	public final static Cursor defaultCursor = Cursor.getDefaultCursor();
	
	
	public AdminSummaryQuestionList(JFrame frame) {
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

		btnBack = new JButton("Back");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(null);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnBack.setFocusable(false);
		btnBack.setBackground(new Color(255, 186, 8));
		btnBack.setBounds(1056, 644, 104, 45);
		panel_1.add(btnBack);

		txtAddQuestions = new JTextField();
		txtAddQuestions.setText("Questions Summary");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 28));
		txtAddQuestions.setBounds(476, 49, 240, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new Admin(frame, null);
			}
		});

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

		// table display
		FeedBackI feed = null;
		FeedBackBean[] model = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
			String response = feed.getAllFeedBack(false);
			model = mapper.readValue(response, FeedBackBean[].class);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
//
//
		Object[][] data = new Object[model.length][6];

		int k = 0;
		for (FeedBackBean fb : model) {
			if (!fb.getType().equalsIgnoreCase("textArea")) {
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
		}
		
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
		
		JRadioButton radioChartPie = new JRadioButton("Pie Chart");
		radioChartPie.setOpaque(false);
		radioChartPie.setFocusable(false);
		radioChartPie.setBackground(new Color(0,0,0,0));
		radioChartPie.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioChartPie.setForeground(Color.WHITE);
		radioChartPie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioChartPie.setBounds(58, 98, 109, 23);
		radioChartPie.setSelected(true);
		panel_1.add(radioChartPie);
		
		JRadioButton radioChartBar = new JRadioButton("Bar Chart");
		radioChartBar.setOpaque(false);
		radioChartBar.setFocusable(false);
		radioChartBar.setBackground(new Color(0,0,0,0));
		radioChartBar.setFont(new Font("Calibri", Font.PLAIN, 14));
		radioChartBar.setForeground(Color.WHITE);
		radioChartBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioChartBar.setBounds(182, 98, 109, 23);
		panel_1.add(radioChartBar);

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioChartPie);
		bg.add(radioChartBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 141, 1106, 400);
		scrollPane.setViewportView(jt);

		panel_1.add(scrollPane);

		// get clicked row
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				System.out.println("xd");

				if (!event.getValueIsAdjusting()) {
					
					frame.setCursor(busyCursor);
					jt.setEnabled(false);
					
					
					int selectedData = 0;
					String selectedQuestion = null;
					int selectedRow = jt.getSelectedRow();
//		    	    int selectedColumns = jt.getSelectedColumn();

					for (int i = 0; i <= selectedRow; i++) {
						for (int j = 0; j < 1; j++) {
							selectedData = (int) jt.getValueAt(selectedRow, 0);
							selectedQuestion = (String) jt.getValueAt(selectedRow, 3);
						}
					}
//		    	    System.out.println("Selected: " + Integer.toString(selectedData));

//					displayPieChart(selectedData);
//					chartImgPieChart() ;
					
					if (radioChartPie.isSelected()) {
						displayChartConfiger(selectedData, "pie",selectedQuestion);						
					}else {
						displayChartConfiger(selectedData, "bar",selectedQuestion);
					}
					
					frame.setCursor(defaultCursor);
					jt.setEnabled(true);
				}
			}
		});
	}

	public void displayChartConfiger(int qid, String type,String selectedQuestion) {
		FeedBackI feed = null;

		try {
			feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
			String response = feed.getclientFeedbackSummaryByQid(qid);

//			System.out.println(response);
			
			if (type.equalsIgnoreCase("pie")) {
				chartImgPieChart(response,selectedQuestion);				
			}else {
				chartImgBarChart(response,selectedQuestion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void displayPieChart(int qid) {
//		DefaultPieDataset pieDataSet = new DefaultPieDataset();
//
//		ObjectMapper mapper = new ObjectMapper();
//		FeedBackI feed = null;
////		Summary_answerCountBean[] model = null;
//
//		try {
//			feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
//			String response = feed.getclientFeedbackSummaryByQid(qid);
////			model = mapper.readValue(response, FeedBackBean[].class);
//
//			// for read map-like jason without using model structure
//			Map<String, Object> map = mapper.readValue(response, new TypeReference<Map<String, Object>>() {
//			});
//
////			System.out.println(map.get("answersCount"));
////			String answerCountList = map.get("answersCount").toString();
////			System.out.println(answerCountList);
//
//			List ansContList = (List) map.get("answersCount");
//
////			System.out.println(((Map)ansContList.get(0)).get("answer"));
//
//			for (int i = 0; i < ansContList.size(); i++) {
//				String labelName = (String) ((Map) ansContList.get(i)).get("answer");
//				int summaryCount = (int) ((Map) ansContList.get(i)).get("count");
//				pieDataSet.setValue(labelName, summaryCount);
//			}
//
////			model = mapper.readValue(answerCountList, Summary_answerCountBean[].class);
//
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//
////		pieDataSet.setValue("one", new Integer(20));
////		pieDataSet.setValue("Two", new Integer(30));
////		pieDataSet.setValue("Three", new Integer(50));
//
//		JFreeChart chart = ChartFactory.createPieChart("Pie chart " + qid, pieDataSet, true, true, true);
//		PiePlot p = (PiePlot) chart.getPlot();
////		p.setForegroundAlpha(TOP_ALIGNMENT);
//		chart.getPlot().setBackgroundPaint(Color.WHITE);
//		chart.setBorderVisible(false);
//		ChartFrame frame = new ChartFrame("Pie Chart", chart);
//
//		frame.setVisible(true);
////		frame.setSize(450,500);
//		frame.setBounds(600, 200, 600, 600);
//	}

	public void chartImgPieChart(String json,String selectedQuestion) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			Integer[] angle ;
			String[] answers;
			int totalCount ;
			
			Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});

			List ansContList = (List) map.get("answersCount");
			
			System.out.println(ansContList.size());
			angle = new Integer[ansContList.size()];
			answers = new String[ansContList.size()];
			
			for (int i = 0; i < ansContList.size(); i++) {
				angle[i] = (Integer) ((Map) ansContList.get(i)).get("count");
				answers[i] = (String) ((Map) ansContList.get(i)).get("answer");
			}
			
			StringBuilder builder = new StringBuilder();//for angle 
			StringBuilder builderAnswer = new StringBuilder();//for answers title
			StringBuilder builderAnswerCount = new StringBuilder();//for display answers count
			
			for (int j = 0; j < answers.length; j++) {				
				Integer x = (Integer) ((angle[j]*100)/7);
				
					builder.append(x);	
					builderAnswer.append(answers[j]);
					
					if (angle[j]>0) {
						builderAnswerCount.append(angle[j]);						
					}
					
					if (j != answers.length-1) {
						builder.append(",");
						builderAnswer.append("|");
						builderAnswerCount.append("|");
					} 
			}
			
			String strAngles = builder.toString();
			String strAnswersTitle = builderAnswer.toString().replaceAll("\\s+","");
			String strAnswersCount = builderAnswerCount.toString();
			System.out.println(strAnswersCount);

			totalCount = (int) map.get("questionsCount");
//			String title = "GG";
			
			
//			JSONObject subObj = new JSONObject();
//			subObj.put("formatter", "function(){if(this.y!=0){return this.y;}}");
			
//			JSONObject paramObj  = new JSONObject();
//			paramObj.put("dataLabels", subObj);
//			
//			System.out.println(paramObj);
			
//			String chl = "Hello|World";
//			System.out.println(URLEncoder.encode(chl, "UTF-8"));
			
			String path = "https://image-charts.com/chart?" 
					+ "chco=FFFF10%2CFF2027"
//					+ "&chd=t%3A"+ URLEncoder.encode(strAngles, "UTF-8")
					+ "&chd=t%3A"+ strAngles
					+ "&chdl="+strAnswersTitle+"&chdlp=b"
//					+ "&chf=b0%2Clg%2C90%2C68cefd%2C0%2C96a6ff%2C1"
					+ "&chl=" + strAnswersCount
					+ "&chli=" + totalCount
					+ "&chma=0%2C0%2C60%2C40&chs=700x600&cht=pd";
//					+ "&chtt=" + title;
//					+ "&dataLabels="+(URLEncoder.encode(subObj.toString(), "UTF-8"));
			
//			String path = "https://image-charts.com/chart?" 
//					+ "chco=FFFF10%2CFF2027"
//					+ "&chd=t"+strAngles
//					+ "&chdl="+strAnswersTitle+"&chdlp=b"
////					+ "&chf=b0%2Clg%2C90%2C68cefd%2C0%2C96a6ff%2C1"
//					+ "&chl=" + strAnswersCount
//					+ "&chli=" + totalCount
//					+ "&chma=0%2C0%2C20%2C20&chs=700x600&cht=pd&chtt=" + title;

//			String path = "https://image-charts.com/chart?" + "chd=t%3A" + angle1 + "%2C" + angle2 + "%2C" + angle3
//					+ "%2C" + angle4 + "&chdl=" + type1 + "%7C" + type2 + "%7C" + type3 + "%7C" + type4 + "&chdlp=b"
//					+ "&chf=b0%2Clg%2C90%2C68cefd%2C0%2C96a6ff%2C1" + "&chl=" + typeCount1 + "%7C" + typeCount2 + "%7C"
//					+ typeCount3 + "%7C" + typeCount4 + "&chli=" + totalCount
//					+ "%E2%82%AC&chma=0%2C0%2C20%2C20&chs=700x600&cht=pd&chtt=" + title;

			JFrame f = new JFrame();
			
			JLabel lblQuestion = new JLabel(selectedQuestion);
			lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuestion.setBounds(0, 0, 700, 50);
			lblQuestion.setFont(new Font("Calibri", Font.BOLD, 19));
			Border border = lblQuestion.getBorder();
			Border margin = new EmptyBorder(50, 10, 80, 10);
			lblQuestion.setBorder(new CompoundBorder(border, margin));
			f.getContentPane().add(lblQuestion);
			
			System.out.println("Get Image from " + path);
			URL url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			System.out.println("Load image into frame...");
			JLabel label = new JLabel(new ImageIcon(image));
			
//			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.getContentPane().add(label);
			f.pack();
			f.setLocation(550, 250);
			f.setVisible(true);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public void chartImgBarChart(String json,String selectedQuestion) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			
			System.out.println("ques :"+selectedQuestion);
			
			Integer[] angle ;
			String[] answers;
			int totalCount ;
			
			Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});

			List ansContList = (List) map.get("answersCount");
			
			System.out.println(ansContList.size());
			angle = new Integer[ansContList.size()];
			answers = new String[ansContList.size()];
			
			for (int i = 0; i < ansContList.size(); i++) {
				angle[i] = (Integer) ((Map) ansContList.get(i)).get("count");
				answers[i] = (String) ((Map) ansContList.get(i)).get("answer");
			}
			
			StringBuilder builder = new StringBuilder();//for angle 
			StringBuilder builderAnswer = new StringBuilder();//for answers title
			StringBuilder builderAnswerCount = new StringBuilder();//for display answers count
			
			for (int j = 0; j < answers.length; j++) {				
				Integer x = (Integer) ((angle[j]*100)/7);
				
					builder.append(x);	
					builderAnswer.append(answers[j]);
					
//					if (angle[j]>0) {
						builderAnswerCount.append(angle[j]);						
//					}
					
					if (j != answers.length-1) {
						builder.append(",");
						builderAnswer.append("|");
//						builderAnswerCount.append("|");
						builderAnswerCount.append(",");
					} 
			}
			
			String strAngles = builder.toString(); //chd
			
			String strAnswersTitle = builderAnswer.toString().replaceAll("\\s+","");//chxl 
			System.out.println(strAnswersTitle);
			String strAnswersCount = builderAnswerCount.toString();
			System.out.println(strAnswersCount);

			totalCount = (int) map.get("questionsCount");
			
			String bar = "https://image-charts.com/chart?"
					+ "chbr=10"
					+ "&chco=EA469E%7C03A9F4%7CFFC00C%7CFFFF10%7CFF2027"
					+ "&chd=t:"+strAnswersCount
					+ "&chs=700x500"
					+ "&cht=bvs"
					+ "&chxl=1:|"+strAnswersTitle
					+ "&chma=40%2C60%2C40%2C40&chxt=y%2Cx";

			JFrame f = new JFrame();
			
			JLabel lblQuestion = new JLabel(selectedQuestion);
			lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuestion.setBounds(0, 0, 700, 50);
			lblQuestion.setFont(new Font("Calibri", Font.BOLD, 19));
			Border border = lblQuestion.getBorder();
			Border margin = new EmptyBorder(50, 10, 80, 10);
			lblQuestion.setBorder(new CompoundBorder(border, margin));
			f.getContentPane().add(lblQuestion);
			
			System.out.println("Get Image from " + bar);
			URL url = new URL(bar);
			BufferedImage image = ImageIO.read(url);
			System.out.println("Load image into frame...");
			JLabel label = new JLabel(new ImageIcon(image));
			
			
			f.getContentPane().add(label);
			f.pack();
			f.setLocation(550, 250);
			f.setVisible(true);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
