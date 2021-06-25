package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {

		
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Class wasn't found");
			e.printStackTrace();
		}
		

		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=grow_net";
		String username = "postgres";
		String password = "password"; 
		
				
		return DriverManager.getConnection(url,username,password);
		
	
	}//getConnection()		
}//class
