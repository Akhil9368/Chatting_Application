package com.akhil.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.akhil.chatapp.dao.UserDao;
import com.akhil.chatapp.dto.userdto;
import com.akhil.chatapp.utils.UserInfo;


public class UserScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;

	
	public static void main(String[] args) {
		
		new UserScreen();
					
	}
	UserDao userdao= new UserDao();
  private void dologin() {
	String userid =username.getText();
	
//	String pass = password.getText();
	// as the line above line getText method is  depricated because of password security (because it print the password) 
	char[] pass =  password.getPassword();
	
	userdto userDto = new userdto(userid , pass);
	try {
		String message ="";
		if(userdao.isLogin(userDto)) {
			message ="Welcome "+userid +" in SkyChat ";
			UserInfo.USER_NAME = userid;
			JOptionPane.showMessageDialog(this, message);
			setVisible(false);
			dashboard dashBoard = new dashboard(message);
			dashBoard.setVisible(true);
		}
		else
		{
			message = "Invalid Userid or Password";
			JOptionPane.showMessageDialog(this, message);
		}
		
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	private void register(userdto userdto) throws ClassNotFoundException, SQLException {
		String userid = username.getText();
//		String pass = password.getText();
		// as the line above line getText method is  depricated because of password security (because it print the password) 
		char[] pass =  password.getPassword();
		//UserDao userdao= new UserDao();
		userdto userDto = new userdto(userid , pass);
		try {
			
		int result = userdao.add(userDto);
		if (result>0) {
			JOptionPane.showMessageDialog(this,"Record Added Succesfully");
			//System.out.println("User Added in database...");
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Record not Added");
		}
		}
		catch(ClassNotFoundException | SQLException ex){
			System.out.println("Db Issue.....");
			ex.printStackTrace();
		}
		//now this time the password is showing in the character array format like in this way [classnameHashcode]   
		catch(Exception ex) {
			System.out.println("Some Generic raised....");
			ex.printStackTrace();
		}
//		System.out.println("UserName "+ userid +" " + " \nPassword " + pass);
		}
//		
//	
	
	public UserScreen() {
		
		setResizable(false);
		setTitle("Welcome to SkyChat");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBackground(new Color(169, 169, 169));
		username.setBounds(268, 132, 195, 28);
		getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login/Register");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(205, 56, 201, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(137, 132, 101, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(137, 185, 113, 33);
		getContentPane().add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBackground(new Color(192, 192, 192));
		password.setBounds(268, 185, 195, 29);
		getContentPane().add(password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dologin();
			}
		});
		login.setBackground(new Color(50, 205, 50));
		login.setBounds(173, 255, 101, 33);
		getContentPane().add(login);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			@override
			public void actionPerformed(ActionEvent e) {
				try {
					register(null);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		register.setBackground(new Color(255, 102, 0));
		register.setBounds(321, 255, 106, 33);
		getContentPane().add(register);
		setBackground(Color.WHITE);
		
		setVisible(true);
		setSize(588, 366);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
