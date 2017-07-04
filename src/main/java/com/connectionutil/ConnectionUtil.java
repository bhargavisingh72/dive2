package com.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;



public class ConnectionUtil {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/bhargavidb";
	public static final String USERNAME="root";
	public static final String PASSWORD="root";
	
	public static Connection getConnection(){
		
		
		try {
			Class.forName(DRIVER);
		Connection	con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
	
			return con;
		} 
		catch(SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
