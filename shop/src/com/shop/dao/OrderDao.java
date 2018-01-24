package com.shop.dao;

import java.util.List;

import com.shop.pojo.Order;

public interface OrderDao {
	//�ύ����
	public int addOrder(Order order);
	//ɾ������
	public int deleteOrder(int orderid);
	//��ѯĳ���û��Ķ���
	public List<Order> queryOrderByUser(int userid);
	//��ѯ�����û��Ķ���
	public List<Order> queryOrder();
}
