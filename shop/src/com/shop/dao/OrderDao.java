package com.shop.dao;

import java.util.List;

import com.shop.pojo.Order;

public interface OrderDao {
	//提交订单
	public int addOrder(Order order);
	//删除订单
	public int deleteOrder(int orderid);
	//查询某个用户的订单
	public List<Order> queryOrderByUser(int userid);
	//查询所有用户的订单
	public List<Order> queryOrder();
}
