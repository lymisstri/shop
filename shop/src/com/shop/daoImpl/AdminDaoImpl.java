package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.dao.AdminDao;
import com.shop.pojo.Admin;
import com.shop.pojo.User;
import com.shop.util.Dbconn;

public class AdminDaoImpl implements AdminDao {

	public Admin login(String adminname, String adminpass) {
		Admin admin = null;
		String sql = "select * from s_admin where adminname=? and adminpass=?";
		
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, adminname);
			pstm.setString(2, adminpass);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setAdminname(rs.getString(2));
				admin.setAmdinpass(rs.getString(3));
			}
			conn.close();
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admin;
	}

}
