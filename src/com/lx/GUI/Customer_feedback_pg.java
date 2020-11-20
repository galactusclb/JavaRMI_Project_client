package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.lx.Beans.FeedBackBean;
import com.lx.Interfaces.FeedBackI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Customer_feedback_pg {

	private JFrame frame;
	public JPanel panel_answers;
	private JTextField textField;
	public JButton btnSubmit;

	public String[][] arrStr = new String[3][4];
	JSONParser jsonp = new JSONParser();

	int i = 0;
	int total = 0;
	int questionIndex = 0;

	FeedBackBean[] model;
	private JTextField questionCount;

	/**
	 * Create the application.
	 */
	public Customer_feedback_pg(JFrame frame) {
		this.frame = frame;
		initialize();

//		for (int i = 0; i < arrStr.length; i++) {
//			for (int j = 0; j < arrStr[i].length; j++) {
//				arrStr[i][j] = "Str" + j;
//				System.out.print(arrStr[i][j] + " ");
//			}
//			System.out.println("");
//		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

//		frame = new JFrame();
//		frame.getContentPane().setBackground(new Color(245, 245, 245));
//		frame.getContentPane().setLayout(null);
//		frame.setVisible(true);
//		frame.setTitle("GrandLuck University - FeedBack");
//		frame.setBounds(300, 100, 1200, 850);
//		frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1182, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Customer_feedback_pg.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(0, 0, 0, 0));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1194, 716);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

//		Elments 

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(224, 58, 0));
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnLogout.setOpaque(false);
//		btnLogout.setContentAreaFilled(false);
		btnLogout.setFocusable(false);
		btnLogout.setBounds(1019, 36, 97, 25);
		panel.add(btnLogout);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBounds(155, 166, 840, 22);
		panel_1.add(textField);
		textField.setColumns(10);

		panel_answers = new JPanel();
		panel_answers.setBorder(null);
		panel_answers.setOpaque(false);
		panel_answers.setForeground(Color.WHITE);
		panel_answers.setBounds(155, 212, 632, 333);
		panel_answers.setLayout(new BoxLayout(panel_answers, BoxLayout.Y_AXIS));
		panel_1.add(panel_answers);
		
		questionCount = new JTextField();
		questionCount.setOpaque(false);
		questionCount.setBorder(null);
		questionCount.setBackground(new Color(0,0,0,0));
		questionCount.setForeground(Color.WHITE);
		questionCount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		questionCount.setBounds(1010, 31, 116, 22);
		questionCount.setColumns(10);
		panel_1.add(questionCount);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Corbel Light", Font.BOLD, 25));
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(592, 638, 135, 50);
		panel_1.add(btnBack);

		btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Corbel Light", Font.BOLD, 25));
		btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSubmit.setOpaque(false);
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorderPainted(false);
		btnSubmit.setBounds(991, 638, 135, 50);
		btnSubmit.setFocusable(false);
		panel_1.add(btnSubmit);

		ObjectMapper mapper = new ObjectMapper();

		FeedBackI feed = null;
		
		try {
			feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
			String response = feed.getAllFeedBack(true);
			model = mapper.readValue(response, FeedBackBean[].class);
			
			DisplayAnswers();
//			for(FeedBackBean fb:gg){
//				System.out.println("  type : "+ fb.getType());
//			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		} catch( IOException e1) {
			e1.printStackTrace();
		}catch (Exception e1) {
			e1.printStackTrace();
		} 
		

//			model = mapper.readValue(new File("QA.json"), FeedBackBean[].class);

		// CLICK EVENTS

		btnSubmit.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (questionIndex < model.length - 1) {
					questionIndex += 1;

					DisplayAnswers();

					if (questionIndex == model.length - 1) {
						btnSubmit.setText("Submit");
					}
				}else if(questionIndex == model.length -1) {
					int num=0;
					boolean next = true;
					JSONArray objArray = new JSONArray();
					String output =null;
					
					try {
						for (FeedBackBean fb : model) {
							JSONObject subObj = new JSONObject();
							if (fb.getSelectedAnswer() == null) {
								next = false;
							} else {
								next = true;
								subObj.put("_id",fb.get_id());
								subObj.put("type", fb.getType());
								subObj.put("question", fb.getQuestion());
								subObj.put("selectedAnswer", fb.getSelectedAnswer());
								
								objArray.add(subObj);						
							}
						}	
						output = objArray.toString();
						
						FeedBackI feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
						
						if (!next) {
							JOptionPane.showMessageDialog(frame, "Please, answer for every questions before submit");
						} else {
							feed.clientFeedBack("210451", output);
							JOptionPane.showMessageDialog(frame, "Feedback submit successfully");
							
							//clear data
							for (FeedBackBean fb : model) {
								fb.setSelectedAnswer(null);
							}	
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (questionIndex > 0) {
					questionIndex -= 1;

					DisplayAnswers();
				}
			}
		});

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new login_pg(frame);
			}
		});

		JRadioButton rdbtnLecturepanel = new JRadioButton("dd");
		rdbtnLecturepanel.setFont(new Font("Calibri Light", Font.PLAIN, 24));
		rdbtnLecturepanel.setForeground(Color.WHITE);
		rdbtnLecturepanel.setBorder(null);
		rdbtnLecturepanel.setBackground(new Color(0, 0, 0, 0));
		rdbtnLecturepanel.setBorderPainted(false);
		rdbtnLecturepanel.setBounds(23, 653, 30, 30);
		panel_1.add(rdbtnLecturepanel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Customer_feedback_pg.class.getResource("/images/bg_feedback_empty.jpg")));
		label.setBounds(12, 156, 1194, 573);
		panel_1.add(label);

	}

	void DisplayAnswers() {
		panel_answers.removeAll();
//		textArea.setVisible(false);
		btnSubmit.setText("Next");
		
		//display question
		textField.setText(model[questionIndex].getQuestion());
		
		int count = model.length;
		questionCount.setText((questionIndex+1)+"/"+count);
		

		if (model[questionIndex].getType().equals("radio")) {		
			String answers = model[questionIndex].getAnswers();
			String[] answersArray = answers.split(",");
			
			int j;
			final JRadioButton rbtn[] = new JRadioButton[answersArray.length];

			for (j = 0; j < answersArray.length; j++) {
//				rbtn[j] = new JRadioButton(model[questionIndex].getAnswers()[j]);
				rbtn[j] = new JRadioButton(answersArray[j]);
				rbtn[j].setOpaque(false);
				rbtn[j].setContentAreaFilled(false);
				rbtn[j].setBackground(new Color(0, 0, 0, 0));
				rbtn[j].setFont(new Font("Calibri Light", Font.PLAIN, 24));
				rbtn[j].setForeground(Color.WHITE);
				rbtn[j].setActionCommand(Integer.toString(j));
				rBtnClick(rbtn, answersArray.length, j);
				panel_answers.add(rbtn[j], BorderLayout.EAST);
				
				
				//get select dynamic answer
				int xd = j;
				rbtn[j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
//						System.out.println(" q index : "+questionIndex+" selected answer : "+rbtn[xd].getText());
						model[questionIndex].setSelectedAnswer(rbtn[xd].getText().toString());
					}
				});
			}
			
			
		} else if (model[questionIndex].getType().equals("textArea")) {
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setBounds(155, 212, 632, 197);
			textArea.setBackground(Color.WHITE);
			textArea.setVisible(true);
			panel_answers.add(textArea);
			
			textArea.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					model[questionIndex].setSelectedAnswer(textArea.getText());
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}

		panel_answers.validate();
		panel_answers.repaint();
	}

	// find and uncheck non selected radio button
	void rBtnClick(JRadioButton btn[], int num, int selected) {
		btn[selected].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(btn.getText());
//				System.out.println(btn.getActionCommand());

				for (int i = 0; i < num; i++) {
//					int k = Integer.parseInt(btn[selected].getActionCommand());
					int k = selected;
					if (k != i) {
//						System.out.println("not selected "+ i);
						btn[i].setSelected(false);
					}else {
						btn[i].setSelected(true);
					}
				}
			}
		});
	}
}
