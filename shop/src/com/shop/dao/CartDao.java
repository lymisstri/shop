package com.shop.dao;

import java.util.List;

import com.shop.pojo.Cart;

public interface CartDao {
	//�鿴ĳ���û��Ĺ��ﳵ
	public List<Cart> queryCartByUser(int userid);
	//��չ��ﳵ
	public void deleteCart();
	//ɾ�����ﳵ�е���Ʒ
	public void deleteCartById(int cartid);
	//��ӹ��ﳵ
	public int addCart(Cart cart);
	//�޸Ĺ��ﳵ��Ϣ
	public int updateCart(Cart cart);
	//��ѯĳ�����ﳵ��¼
	public Cart queryCartById(int cartid);
}
