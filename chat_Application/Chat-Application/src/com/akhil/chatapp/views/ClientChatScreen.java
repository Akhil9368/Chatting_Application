package com.akhil.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.akhil.chatapp.network.Client;
import com.akhil.chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtRunBox;
	private JTextArea textArea;
	private Client client ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
					try{
						ClientChatScreen frame = new ClientChatScreen();
						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}
	private void SendIt() {
		String message = txtRunBox.getText();
		try {
			System.out.println(UserInfo.USER_NAME );
			client.SendMessage(UserInfo.USER_NAME  + "-" +message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		
		textArea = new JTextArea();
		
		client = new Client(textArea);
		setTitle(UserInfo.USER_NAME);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 343);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 576, 223);
		contentPane.add(scrollPane);
	
		
	
		textArea.setFont(new Font("Segoe Print", Font.BOLD, 16));
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(10, 11, 576, 223);
		scrollPane.setViewportView(textArea);
		
		txtRunBox = new JTextField();
		txtRunBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRunBox.setBounds(10, 245, 407, 37);
		contentPane.add(txtRunBox);
		txtRunBox.setColumns(10);
		
		JButton btnNewButton = new JButton("Send Meassage");
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendIt();
			}
			
		});
		btnNewButton.setActionCommand("New Button\r\n\r\n");
		btnNewButton.setBounds(458, 245, 128, 37);
		contentPane.add(btnNewButton);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
}
