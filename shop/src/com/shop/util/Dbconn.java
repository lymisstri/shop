package com.shop.util;

import java.sql.*;

public class Dbconn {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://127.0.0.1/shop";
	public static final String DBUSER = "root";
	public static final String DBPASS = "123456";
	
	public static Connection getconnection(){
		Connection conn = null;
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
}
