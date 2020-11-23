package com.lx.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class AdminSummary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSummary window = new AdminSummary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("GrandLuck University - Summary ");
		frame.setResizable(false);
		frame.setBounds(300, 100, 1200, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1200, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/logo_2.png")));
		label_1.setBackground(new Color(1,25,54));
		label_1.setBounds(53, 10, 180, 80);
		panel.add(label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(1, 24, 55));
		panel_1.setBounds(0, 99, 1200, 720);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextField txtAddQuestions = new JTextField();
		txtAddQuestions.setText("Summary ");
		txtAddQuestions.setBorder(null);
		txtAddQuestions.setOpaque(false);
		txtAddQuestions.setForeground(Color.WHITE);
		txtAddQuestions.setFont(new Font("Calibri", Font.PLAIN, 30));
		txtAddQuestions.setBounds(574, 35, 137, 65);
		panel_1.add(txtAddQuestions);
		txtAddQuestions.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 22));
		btnBack.setBackground(new Color(0,0,0,0));
		btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(1022, 635, 112, 45);
		panel_1.add(btnBack);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(197, 495, 97, 25);
		panel_1.add(btnNewButton);
		
				
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AdminSummary.class.getResource("/images/summary_chart.JPG")));
		label.setBounds(205, 102, 775, 380);
		panel_1.add(label);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultPieDataset pieDataSet = new DefaultPieDataset();
				
				pieDataSet.setValue("one", new Integer(20));
				pieDataSet.setValue("Two", new Integer(30));
				pieDataSet.setValue("Three", new Integer(50));
				
				JFreeChart chart = ChartFactory.createPieChart3D("Pie chart", pieDataSet, true,true,true);
				PiePlot3D p = (PiePlot3D) chart.getPlot();
//				p.setForegroundAlpha(TOP_ALIGNMENT);
				ChartFrame frame=new ChartFrame("Pie Chart", chart);
				
				frame.setVisible(true);
				frame.setSize(450,500);
				
				
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Admin(frame);
			}
		});
		
		
	}
}
