package com.akhil.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtWelcomeToChat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.runProgressbar();
				
		
	}
	private Timer timer;
     private void runProgressbar() {
	    timer= new Timer(40 , new ActionListner() {
	    		@override
	    		public void actionPerformed(ActionEvent e) {
	    			progressBar.setValue(count);
	    			count++;
	    			if(count>100) {
	    				if(timer!= null) {
	    					
	    					timer.stop();
	    					SplashScreen.this.setVisible(false);
	    					SplashScreen.this.dispose();
	    					UserScreen userscreen = new UserScreen();
	    					userscreen.setVisible(true);
	    				}
	    			}
	    		}	
	    		});
	    timer.start();
}
     private int count = 0;
     JProgressBar progressBar = new JProgressBar();
	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 622, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWelcomeToChat = new JTextField();
		txtWelcomeToChat.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtWelcomeToChat.setText("Welcome To SkyChat");
		txtWelcomeToChat.setBounds(183, 260, 244, 43);
		contentPane.add(txtWelcomeToChat);
		txtWelcomeToChat.setColumns(10);
		
	    progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 13));
		progressBar.setForeground(Color.BLUE);
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 329, 586, 25);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NCB\\Desktop\\chatt.jpg"));
		lblNewLabel.setBounds(0, -12, 617, 341);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		setTitle("Welcome to SkyChat");
	}
}
