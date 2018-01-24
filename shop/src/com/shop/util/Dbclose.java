package com.shop.util;

import java.sql.*;

public class Dbclose {
	public static void close(ResultSet rs,Statement stm,Connection conn){
		try {
			if(rs!=null) rs.close();
			if(stm!=null) stm.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
				
			e.printStackTrace();
		}
	}
	
}