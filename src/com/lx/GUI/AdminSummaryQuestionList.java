package com.lx.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import com.lx.Beans.FeedBackBean;
import com.lx.Beans.Summary_answerCountBean;
import com.lx.Interfaces.FeedBackI;

public class AdminSummaryQuestionList {

	private JFrame frame;
	private JPanel mainPanel, panel, panel_1;
	private JTextField txtAddQuestions;
	private JButton btnBack;

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

		btnBack = new JButton("Back");
		btnBack.setBounds(1053, 667, 97, 25);
		panel_1.add(btnBack);

		txtAddQuestions = new JTextField();
		txtAddQuestions.setText("Questions Summary");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 28));
		txtAddQuestions.setBounds(532, 49, 161, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				new Admin(frame);
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
//		
//		
		String[] columnNames = { "Id", "order", "type", "question", "answers" };

		JTable jt = new JTable(data, columnNames);
		jt.setFont(new Font("Calibri", Font.PLAIN, 18));

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 139, 1106, 400);
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

					displayPieChart(selectedData);
				}
			}
		});
	}

	public void displayPieChart(int qid) {
		DefaultPieDataset pieDataSet = new DefaultPieDataset();
		
		ObjectMapper mapper = new ObjectMapper();
		FeedBackI feed = null;
//		Summary_answerCountBean[] model = null;

		try {
			feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
			String response = feed.getclientFeedbackSummaryByQid(qid);
//			model = mapper.readValue(response, FeedBackBean[].class);
			
			//for read map-like jason
			Map<String, Object> map = mapper.readValue(response, new TypeReference<Map<String, Object>>() {});
			
//			System.out.println(map.get("answersCount"));
//			String answerCountList = map.get("answersCount").toString();
//			System.out.println(answerCountList);
			
			List ansContList = (List) map.get("answersCount");
			
//			System.out.println(((Map)ansContList.get(0)).get("answer"));
			
			for (int i = 0; i < ansContList.size(); i++) {
				String labelName = (String)((Map)ansContList.get(i)).get("answer");
				int summaryCount = (int)((Map)ansContList.get(i)).get("count");
				pieDataSet.setValue( labelName ,summaryCount );
			}
	
			
//			model = mapper.readValue(answerCountList, Summary_answerCountBean[].class);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		
		
//		pieDataSet.setValue("one", new Integer(20));
//		pieDataSet.setValue("Two", new Integer(30));
//		pieDataSet.setValue("Three", new Integer(50));
		
		JFreeChart chart = ChartFactory.createPieChart3D("Pie chart "+qid, pieDataSet, true,true,true);
		PiePlot3D p = (PiePlot3D) chart.getPlot();
//		p.setForegroundAlpha(TOP_ALIGNMENT);
		ChartFrame frame=new ChartFrame("Pie Chart", chart);
		
		frame.setVisible(true);
//		frame.setSize(450,500);
		frame.setBounds(600, 200, 600, 600);
	}
}
