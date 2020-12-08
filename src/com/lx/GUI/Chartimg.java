package com.lx.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Chartimg extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chartimg frame = new Chartimg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chartimg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String title="GG";
		
		int angle1=10,angle2=40,angle3=35,angle4=15,totalCount=95;
		String type1="Expansion",type2="Payroll",type3="Equipment",type4="Xd";
		String typeCount1="jj",typeCount2="40",typeCount3="45",typeCount4="15";
		
		
		try {
//            
            String path ="https://image-charts.com/chart?"
            		+ "chd=t%3A"+angle1+"%2C"+angle2+"%2C"+angle3+"%2C"+angle4
            		+ "&chdl="+type1+"%7C"+type2+"%7C"+type3+"%7C"+type4
            		+ "&chdlp=b"
            		+ "&chf=b0%2Clg%2C90%2C68cefd%2C0%2C96a6ff%2C1"
            		+ "&chl="+typeCount1+"%7C"+typeCount2+"%7C"+typeCount3+"%7C"+typeCount4
            		+ "&chli="+totalCount+"%E2%82%AC&chma=0%2C0%2C20%2C20&chs=700x600&cht=pd&chtt="+title;
            
            System.out.println("Get Image from " + path);
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            System.out.println("Load image into frame...");
            JLabel label = new JLabel(new ImageIcon(image));
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.getContentPane().add(label);
            f.pack();
            f.setLocation(200, 200);
            f.setVisible(true);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
	}

}
