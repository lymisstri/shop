package com.shop.dao;

import java.util.List;

import com.shop.pojo.Cart;

public interface CartDao {
	//查看某个用户的购物车
	public List<Cart> queryCartByUser(int userid);
	//清空购物车
	public void deleteCart();
	//删除购物车中的商品
	public void deleteCartById(int cartid);
	//添加购物车
	public int addCart(Cart cart);
	//修改购物车信息
	public int updateCart(Cart cart);
	//查询某条购物车记录
	public Cart queryCartById(int cartid);
}
