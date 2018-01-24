package com.shop.servlet;

import java.io.IOException;
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

public class DeleteCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//删除购物车记录
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int cartid = Integer.parseInt(request.getParameter("cartid"));
		CartDao cartdao = new CartDaoImpl();
		GoodDao gooddao = new GoodDaoImpl();
		Cart cart = cartdao.queryCartById(cartid);
		Goods good = gooddao.queryGoodsById(cart.getGoodid());
		good.setGoodnum(good.getGoodnum() + cart.getNum());
		good.setGoodsnum(good.getGoodsnum() - cart.getNum());
		gooddao.updateGoods(good);
		cartdao.deleteCartById(cartid);
		request.setAttribute("mes", "删除成功");
		request.getRequestDispatcher("/showCartServlet").forward(request, response);
	}

}
