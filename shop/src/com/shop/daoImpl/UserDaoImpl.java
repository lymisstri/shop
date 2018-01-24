package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.UserDao;
import com.shop.pojo.User;
import com.shop.util.Dbconn;

public class UserDaoImpl implements UserDao {

	public User login(String username, String userpass) {
		User user = null;
		String sql = "select * from s_user where username=? and userpass=?";
		
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, userpass);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setUserpass(rs.getString(3));
				user.setRank(rs.getDouble(4));
			}
			conn.close();
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public int userRegist(User user) {
		int result = 0;
		String sql = "insert into s_user(username,userpass,rank) values('"+user.getUsername()+"','"+user.getUserpass()+"',"+user.getRank()+")";
		try {
			Connection conn = Dbconn.getconnection();
			Statement stm = conn.createStatement();
			result = stm.executeUpdate(sql);
			conn.close();
			stm.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<User> queryUsers() {
		User u = null;
		List<User> list = new ArrayList<User>();
		String sql = "select * from s_user";
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setUserpass(rs.getString(3));
				u.setRank(rs.getDouble(4));
				list.add(u);
			}
			conn.close();
			rs.close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int deleteUser(int userid) {
		int result = 0;
		String sql = "delete from s_user where id="+userid;
		try {
			Connection con = Dbconn.getconnection();
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);		
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateRank(User user) {
		int result = 0;
		String sql = "update s_user set rank=? where id="+user.getId();
		
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1, user.getRank());
			result = pst.executeUpdate();		
			conn.close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
