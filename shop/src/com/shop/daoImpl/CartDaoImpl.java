package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.CartDao;
import com.shop.pojo.Cart;
import com.shop.pojo.Goods;
import com.shop.pojo.User;
import com.shop.util.Dbconn;

public class CartDaoImpl implements CartDao {

	public List<Cart> queryCartByUser(int userid) {
		Cart c = null;
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select * from s_cart where status=1 and userid="+userid;
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				c = new Cart();
				c.setId(rs.getInt(1));
				c.setCartno(rs.getInt(2));
				c.setUserid(rs.getInt(3));
				c.setGoodid(rs.getInt(4));
				c.setNum(rs.getInt(5));
				c.setStatus(rs.getInt(6));
				list.add(c);
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

	public void deleteCart() {
		String sql = "delete from s_cart where status=1";
		try {
			Connection con = Dbconn.getconnection();
			Statement st = con.createStatement();
			st.executeUpdate(sql);		
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addCart(Cart cart) {
		int result = 0;
		String sql = "insert into s_cart(cartno,userid,goodid,num,status) "
				+ "values("+cart.getCartno()+","+cart.getUserid()+","+cart.getGoodid()+","+cart.getNum()+","+cart.getStatus()+")";
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

	public int updateCart(Cart cart) {
		int result = 0;
		String sql = "update s_cart set num=?,status=? where id="+cart.getId();
		
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cart.getNum());
			pst.setInt(2, cart.getStatus());
			result = pst.executeUpdate();		
			conn.close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Cart queryCartById(int cartid) {
		Cart cart = null;
		String sql = "select * from s_cart where id="+cartid;
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				cart = new Cart();
				cart.setId(rs.getInt(1));
				cart.setCartno(rs.getInt(2));
				cart.setUserid(rs.getInt(3));
				cart.setGoodid(rs.getInt(4));
				cart.setNum(rs.getInt(5));
				cart.setStatus(rs.getInt(6));
			}
			conn.close();
			rs.close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}

	public void deleteCartById(int cartid) {
		String sql = "delete from s_cart where id="+cartid;
		try {
			Connection con = Dbconn.getconnection();
			Statement st = con.createStatement();
			st.executeUpdate(sql);		
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
