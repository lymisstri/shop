package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.OrderDao;
import com.shop.pojo.Order;
import com.shop.util.Dbconn;

public class OrderDaoImpl implements OrderDao {

	public int addOrder(Order order) {
		int result = 0;
		String sql = "insert into s_order(orderid,date,totalprice) "
				+ "values("+order.getOrderid()+",'"+order.getDate()+"',"+order.getTotalprice()+")";
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

	public int deleteOrder(int orderid) {
		int result = 0;
		String sql = "delete from s_order where id="+orderid;
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

	public List<Order> queryOrderByUser(int userid) {
		Order o = null;
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from s_order";
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setId(rs.getInt(1));
				o.setOrderid(rs.getInt(2));
				o.setDate(rs.getString(3));
				o.setTotalprice(rs.getDouble(4));
				list.add(o);
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

	public List<Order> queryOrder() {
		Order o = null;
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from s_order";
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				o = new Order();
				o.setId(rs.getInt(1));
				o.setOrderid(rs.getInt(2));
				o.setDate(rs.getString(3));
				o.setTotalprice(rs.getDouble(4));
				list.add(o);
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

}
