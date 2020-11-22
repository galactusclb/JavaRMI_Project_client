package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.lx.Beans.FeedBackBean;
import com.lx.Interfaces.FeedBackI;

import javax.swing.JTable;

public class AdminQuestionsList2 {

	private JFrame frame;
	private JPanel panel,panel_1;
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
		JPanel mainPanel = new JPanel();
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

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnAdd.setBackground(new Color(255, 186, 8));
		btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnAdd.setOpaque(false);
//		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorder(null);
		btnAdd.setFocusable(false);
		btnAdd.setBounds(1022, 46, 112, 45);
		panel_1.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(1053, 667, 97, 25);
		panel_1.add(btnBack);

		txtAddQuestions = new JTextField();
		txtAddQuestions.setText("Questions");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 28));
		txtAddQuestions.setBounds(532, 49, 161, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);

		
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
				new Admin(frame);
			}
		});
		
//		table = new JTable();

		FeedBackI feed = null;
		FeedBackBean[] model = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
			String response = feed.getAllFeedBack(false);
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
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
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

//		jt.getColumnModel().getColumn(0).setWidth(1);
//		jt.setBounds(80,139,964,300); 

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 139, 1106, 400);
		scrollPane.setViewportView(jt);
//		scrollPane.add(jt);

		panel_1.add(scrollPane);
		
		
		
		//get clicked row
		jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		    	
		    	if(!event.getValueIsAdjusting()){
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