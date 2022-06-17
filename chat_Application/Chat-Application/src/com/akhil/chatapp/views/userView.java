package com.akhil.chatapp.views;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class userView extends JFrame{
	int counter;
	userView(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		counter=0;
		setResizable(false);
		setSize(500,500);
		setTitle("Chat Application");
		JLabel window = new JLabel("Login/Register");
		window.setBounds(160, 10, 300, 50);
		window.setFont(new Font("Arial",Font.BOLD,25));
		Container container = this.getContentPane();
		container.setLayout(null);
		container.add(window);
		JButton button =new JButton("Login");
		
        button.addActionListener(new ActionListner() {
        	@override
        	public void actionPerformed(ActionEvent event) {
        		counter++;
        		window.setText("Count" + counter);
        	}
        });
		container.add(button);
		button.setBounds(90, 100, 100,30);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		userView userview = new userView();
	}

}
