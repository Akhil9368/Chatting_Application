package com.akhil.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.akhil.chatapp.utils.ConfigReader.getValue;

public interface commondao {

public static  Connection CreateConnection() throws ClassNotFoundException, SQLException {
	 //step-1
	 Class.forName(getValue("DRIVER"));
//	 STEP-2 MAKING A CONNECTORS

   final String CONNECTION_STRING = getValue("CONNECTION_URL");
   final String USER_ID = getValue("USERID");
   final String PASSWORD = getValue("PASSWORD");
	 Connection con = DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
	 if(con != null) {
		 System.out.println("Connection Created.....");
			 }
		 return con;
	 }
}
