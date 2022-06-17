package com.akhil.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.akhil.chatapp.dto.userdto;
import com.akhil.chatapp.utils.Encription;

public class UserDao {
	public boolean isLogin(userdto userDto) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException, Exception {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;
		final String SQL = "select User_id from users where User_id=? and password=?";
		try {
			con = commondao.CreateConnection();
			psmt = con.prepareStatement(SQL);
			psmt.setString(1,userDto.getUserid());
			String encryptedpwd = Encription.passswordEncrypt(new String(userDto.getPassword()));
			psmt.setString(2,encryptedpwd);
			rset=psmt.executeQuery();
			return rset.next();
		}
		finally {
			if(rset != null) {
				rset.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
	}
	public int add(userdto userDto) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException,Exception{
		System.out.println("Rec"+" " +  userDto.getUserid() + " " + " \nPassword " + " " + userDto.getPassword() );
		Connection connection = null;
		
    	Statement stmt = null;
    	try {
 		connection  = commondao.CreateConnection(); 
 		stmt = connection.createStatement();
 		int record = stmt.executeUpdate("insert into users(User_id,Password) values('" +userDto.getUserid() + "','" +Encription.passswordEncrypt( new String(userDto.getPassword()))+"')");
		return record;
    	}
    	finally {
    		if(stmt != null) {
    			stmt.close();
    		}
    		if(connection != null) {
    			connection.close();
    		}
    	}
	}
 
}
