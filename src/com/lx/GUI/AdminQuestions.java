package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.codehaus.jackson.map.ObjectMapper;

import com.lx.Beans.FeedBackBean;
import com.lx.Beans.ResponsJsonBean;
import com.lx.Interfaces.FeedBackI;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Rectangle;
import javax.swing.SwingConstants;

public class AdminQuestions {

	private JFrame frame;
	private JPanel orderNUmbers;
	private JTextArea txtQuestion, txtAnswers;
	private JTextField txtAddQuestions;
	private ButtonGroup radion_qType_group;
	private JButton btnSave, btnCancel, btnDelete;
	private JRadioButton rdbtn_checkBox, rdbtn_txtArea, rdbtn_radio;

	private FeedBackI feed;
	private JTextField txtOrder;
	private int editQuestionId;
	private JLabel lblAvailable;

	public AdminQuestions(JFrame frame, int qId) {
		this.frame = frame;
		initialize();

		if (Optional.ofNullable(qId).orElse(0) != 0) {
//			System.out.println(qId);
			this.txtAddQuestions.setText("Edit Question");
			this.editQuestionId = qId;

			try {
				feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");

				String response = feed.getFeedBackByQid(editQuestionId);
				ObjectMapper mapper = new ObjectMapper();
				FeedBackBean[] model = mapper.readValue(response, FeedBackBean[].class);

				txtQuestion.setText(model[0].getQuestion());
				txtAnswers.setText(model[0].getAnswers());
				txtOrder.setText(Integer.toString(model[0].getOrder()));

				if (model[0].getType().equalsIgnoreCase("checkBox")) {
					rdbtn_checkBox.setSelected(true);
				} else if (model[0].getType().equalsIgnoreCase("textArea")) {
					rdbtn_txtArea.setSelected(true);
				} else {
					rdbtn_radio.setSelected(true);
				}
				
				getCurrentOrder(true) ;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			getCurrentOrder(false) ;
			btnDelete.setVisible(false);

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1200, 820);
		mainPanel.setBackground(new Color(0, 0, 0, 0));
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 100);
		mainPanel.add(panel);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(1, 25, 54));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		txtQuestion = new JTextArea();
		txtQuestion.setBackground(Color.WHITE);
		txtQuestion.setLineWrap(true);
		txtQuestion.setWrapStyleWord(true);
		txtQuestion.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtQuestion.setBorder(null);
		txtQuestion.setBounds(304, 122, 396, 82);
		txtQuestion.setColumns(10);
		panel_1.add(txtQuestion);

		txtAnswers = new JTextArea();
		txtAnswers.setLineWrap(true);
		txtAnswers.setBorder(null);
		txtAnswers.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtAnswers.setBounds(304, 378, 396, 143);
		txtAnswers.setColumns(10);
		panel_1.add(txtAnswers);

		rdbtn_radio = new JRadioButton("Radio");
		rdbtn_radio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtn_radio.setActionCommand("radio");
		rdbtn_radio.setOpaque(false);
		rdbtn_radio.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtn_radio.setForeground(Color.WHITE);
		rdbtn_radio.setBackground(new Color(0, 0, 0, 0));
		rdbtn_radio.setBorder(null);
		rdbtn_radio.setFocusable(false);
		rdbtn_radio.setBounds(306, 229, 83, 25);
		panel_1.add(rdbtn_radio);

		rdbtn_txtArea = new JRadioButton("Text Area");
		rdbtn_txtArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtn_txtArea.setActionCommand("textArea");
		rdbtn_txtArea.setOpaque(false);
		rdbtn_txtArea.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtn_txtArea.setForeground(Color.WHITE);
//		rdbtnTextArea.setBackground(new Color(0,0,0,0));
		rdbtn_txtArea.setBorder(null);
		rdbtn_txtArea.setFocusable(false);
		rdbtn_txtArea.setBounds(415, 229, 99, 25);
		panel_1.add(rdbtn_txtArea);

		rdbtn_checkBox = new JRadioButton("Check Box");
		rdbtn_checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtn_checkBox.setActionCommand("checkBox");
		rdbtn_checkBox.setOpaque(false);
		rdbtn_checkBox.setFont(new Font("Cambria", Font.PLAIN, 18));
		rdbtn_checkBox.setForeground(Color.WHITE);
		rdbtn_checkBox.setFocusable(false);
		rdbtn_checkBox.setBorder(null);
		rdbtn_checkBox.setBounds(544, 229, 119, 25);
		panel_1.add(rdbtn_checkBox);

		radion_qType_group = new ButtonGroup();
		radion_qType_group.add(rdbtn_radio);
		radion_qType_group.add(rdbtn_txtArea);
		radion_qType_group.add(rdbtn_checkBox);

		txtAddQuestions = new JTextField();
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 22));
		txtAddQuestions.setText("Add Questions");
		txtAddQuestions.setBounds(429, 41, 154, 37);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblOrder.setForeground(Color.WHITE);
		lblOrder.setBounds(211, 274, 63, 14);
		panel_1.add(lblOrder);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setBounds(198, 150, 69, 14);
		panel_1.add(lblQuestion);
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblType.setBounds(211, 236, 53, 14);
		panel_1.add(lblType);
		
		

		JLabel label = new JLabel("");
		label.setIcon(null);
		label.setBounds(10, 41, 1188, 573);
		panel_1.add(label);
		
		lblAvailable = new JLabel("available order numbers");
		lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAvailable.setForeground(Color.WHITE);
		lblAvailable.setBounds(304, 309, 224, 14);
		panel_1.add(lblAvailable);

		txtOrder = new JTextField();
		txtOrder.setHorizontalAlignment(SwingConstants.CENTER);
		txtOrder.setBounds(304, 265, 119, 33);
		txtOrder.setEditable(false);
		txtOrder.setDisabledTextColor(Color.BLACK);
		panel_1.add(txtOrder);
		txtOrder.setColumns(10);
		
		orderNUmbers = new JPanel();
		orderNUmbers.setBackground(new Color(0,0,0,0));
		orderNUmbers.setBounds(302, 335, 550, 25);
		panel_1.add(orderNUmbers);
		orderNUmbers.setLayout(new BoxLayout(orderNUmbers, BoxLayout.X_AXIS));
		
		
		btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(AdminQuestions.class.getResource("/images/Rectangle_3_edit.png")));
		btnCancel.setBackground(new Color(0, 0, 0, 0));
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.setOpaque(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setFocusable(false);
		btnCancel.setBounds(439, 532, 125, 43);
		panel_1.add(btnCancel);

		btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon(AdminQuestions.class.getResource("/images/Rectangle 11_edit.png")));
		btnSave.setBackground(new Color(0, 0, 0, 0));
		btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSave.setOpaque(false);
		btnSave.setContentAreaFilled(false);
		btnSave.setBorderPainted(false);
		btnSave.setFocusable(false);
		btnSave.setBounds(292, 532, 125, 43);
		panel_1.add(btnSave);

		btnDelete = new JButton("");
		btnDelete.setBackground(new Color(0, 0, 0, 0));
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDelete.setOpaque(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setFocusable(false);
		btnDelete.setIcon(new ImageIcon(AdminQuestions.class.getResource("/images/delete.png")));
		btnDelete.setBounds(574, 532, 53, 43);
		panel_1.add(btnDelete);

		rdbtn_radio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtAnswers.isVisible()) {
					txtAnswers.setVisible(true);					
				}
			}
		});
		
		rdbtn_checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtAnswers.isVisible()) {
					txtAnswers.setVisible(true);					
				}
			}
		});
		
		rdbtn_txtArea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtAnswers.isVisible()) {
					txtAnswers.setText("");
					txtAnswers.setVisible(false);
				}
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				new AdminQuestionsList2(frame);
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {
					try {
						feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");

						Boolean res = feed.deleteFeedBackByQid(editQuestionId);

						if (res) {
							JOptionPane.showMessageDialog(frame, "Feedback delete succesfully.");
							mainPanel.setVisible(false);
							new AdminQuestionsList2(frame);
						} else {
							JOptionPane.showMessageDialog(frame, "Failed to delete the feedback question.");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

//				else if (response == JOptionPane.CLOSED_OPTION) {
//					System.out.println("JOptionPane closed");
//				} else if (response == JOptionPane.NO_OPTION) {
//					System.out.println("No button clicked");

			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					String type = null;
					String question = txtQuestion.getText();
					String answers = txtAnswers.getText();
					int order = Integer.parseInt(txtOrder.getText());

					if (rdbtn_checkBox.isSelected()) {
						type = rdbtn_checkBox.getActionCommand();
					} else if (rdbtn_txtArea.isSelected()) {
						type = rdbtn_txtArea.getActionCommand();
					} else {
						type = rdbtn_radio.getActionCommand();
					}

					feed = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");

					String res = null;
					if (editQuestionId > 0) { // edit question
						res = feed.editFeedBack(editQuestionId, type, question, answers, order);
					} else {
						res = feed.addFeedBack(type, question, answers, order);
					}
//					System.out.println(res);

					ObjectMapper mapper = new ObjectMapper();
					ResponsJsonBean model = mapper.readValue(res, ResponsJsonBean.class);

					System.out.println(model.getMessage());

					if (model.getStatus() == 200) {
						JOptionPane.showMessageDialog(frame, model.getMessage(), "Successful",
								JOptionPane.QUESTION_MESSAGE, new ImageIcon("images/logo.png"));
						mainPanel.setVisible(false);
						new AdminQuestionsList2(frame);
					} else {
						JOptionPane.showMessageDialog(frame, model.getMessage());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	void getCurrentOrder(boolean isEdit) {
		Integer[] numb = new Integer[16];

		try {
			
			FeedBackI feed2 = (FeedBackI) Naming.lookup("rmi://localhost/Feedbacks");
			
			List<Integer> order = feed2.getFeedbacksOrderNumbers();
			
			for (int i = 0; i < 16; i++) {
				if ( !order.contains(i)) {
					numb[i] = i;
				} 
			}
			
			
			boolean minNUm = false;
			for (int i = 1; i < numb.length; i++) {
				
				if (numb[i] !=null) {
					JButton ordersNumb = new JButton(numb[i].toString());
					ordersNumb.setBackground(Color.WHITE);
					ordersNumb.setForeground(Color.BLACK);
					ordersNumb.setHorizontalAlignment(SwingConstants.CENTER);
					ordersNumb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					ordersNumb.setFocusable(false);
					
					ordersNumb.setPreferredSize(new Dimension(40, 25));
					ordersNumb.setMaximumSize(new Dimension(40, 25)); 
			        
					ordersNumb.setBorder(null);
					orderNUmbers.add(ordersNumb);
					orderNUmbers.add(Box.createRigidArea(new Dimension(10, 0)));
					
					if (!isEdit && minNUm == false) {
						txtOrder.setText(numb[i].toString());	
						minNUm = true;
					}
					
					int j = i;
					ordersNumb.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							txtOrder.setText(Integer.toString(j));
						}
					});
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
