package com.shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.CartDao;
import com.shop.dao.GoodDao;
import com.shop.dao.UserDao;
import com.shop.daoImpl.CartDaoImpl;
import com.shop.daoImpl.GoodDaoImpl;
import com.shop.daoImpl.UserDaoImpl;
import com.shop.pojo.Cart;
import com.shop.pojo.Goods;
import com.shop.pojo.User;

public class DeleteAllCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//清空购物车
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		CartDao cartdao = new CartDaoImpl();
		GoodDao gooddao = new GoodDaoImpl();
		List<Cart> cartlist = cartdao.queryCartByUser(user.getId());
		for(Cart c : cartlist){
			Goods good = gooddao.queryGoodsById(c.getGoodid());
			good.setGoodnum(good.getGoodnum() + c.getNum());
			good.setGoodsnum(good.getGoodsnum() - c.getNum());
			gooddao.updateGoods(good);
			cartdao.deleteCartById(c.getId());
		}
		request.setAttribute("mes", "删除成功");
		request.getRequestDispatcher("/showCartServlet").forward(request, response);
	}

}
