package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.GoodDao;
import com.shop.pojo.Goods;
import com.shop.pojo.User;
import com.shop.util.Dbconn;

public class GoodDaoImpl implements GoodDao {

	public List<Goods> queryAllGood() {
		Goods good = null;
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from s_good";
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				good = new Goods();
				good.setId(rs.getInt(1));
				good.setGoodname(rs.getString(2));
				good.setGoodimag(rs.getString(3));
				good.setGooddesc(rs.getString(4));
				good.setGoodpirce(rs.getDouble(5));
				good.setGoodrprice(rs.getDouble(6));
				good.setGoodnum(rs.getInt(7));
				good.setGoodsnum(rs.getInt(8));
				list.add(good);
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

	public int addGood(Goods good) {
		int result = 0;
		String sql = "insert into s_good(goodname,gooddesc,goodprice,goodrprice,goodnum,goodsnum) "
				+ "values('"+good.getGoodname()+"','"+good.getGooddesc()+"',"+good.getGoodpirce()+","+good.getGoodrprice()+","+good.getGoodnum()+","+good.getGoodsnum()+")";
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

	public Goods queryGoodsById(int goodid) {
		Goods good = null;
		String sql = "select * from s_good where id="+goodid;
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				good = new Goods();
				good.setId(rs.getInt(1));
				good.setGoodname(rs.getString(2));
				good.setGoodimag(rs.getString(3));
				good.setGooddesc(rs.getString(4));
				good.setGoodpirce(rs.getDouble(5));
				good.setGoodrprice(rs.getDouble(6));
				good.setGoodnum(rs.getInt(7));
				good.setGoodsnum(rs.getInt(8));
			}
			conn.close();
			rs.close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return good;
	}

	public int updateGoods(Goods good) {
		int result = 0;
		String sql = "update s_good set goodnum=?,goodimag=?,goodsnum=? where id="+good.getId();
		
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, good.getGoodnum());
			pst.setString(2, good.getGoodimag());
			pst.setInt(3, good.getGoodsnum());
			result = pst.executeUpdate();		
			conn.close();
			pst.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Goods> queryByWord(String word) {
		Goods good = null;
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select * from s_good where goodname like '%"+word+"%'";
		try {
			Connection conn = Dbconn.getconnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				good = new Goods();
				good.setId(rs.getInt(1));
				good.setGoodname(rs.getString(2));
				good.setGoodimag(rs.getString(3));
				good.setGooddesc(rs.getString(4));
				good.setGoodpirce(rs.getDouble(5));
				good.setGoodrprice(rs.getDouble(6));
				good.setGoodnum(rs.getInt(7));
				good.setGoodsnum(rs.getInt(8));
				list.add(good);
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
