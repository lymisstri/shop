package com.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.CartDao;
import com.shop.dao.GoodDao;
import com.shop.daoImpl.CartDaoImpl;
import com.shop.daoImpl.GoodDaoImpl;
import com.shop.pojo.Cart;
import com.shop.pojo.User;




public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//查看购物车
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User) request.getSession().getAttribute("user");
		List<Cart> list = new ArrayList<Cart>();
		CartDao dao = new CartDaoImpl();
		GoodDao gooddao = new GoodDaoImpl();
		list = dao.queryCartByUser(user.getId());
		List<Cart> list2 = new ArrayList<Cart>();
		Double totalprice =0.0;
		for(Cart c : list){
			c.setGood(gooddao.queryGoodsById(c.getGoodid()));
			if(user.getRank()<10000){
				totalprice += c.getGood().getGoodpirce();
			}else{
				totalprice += c.getGood().getGoodrprice();
			}
			list2.add(c);
		}
		
		session.setAttribute("totalprice", totalprice);
		request.setAttribute("cartlist", list2);
		request.getRequestDispatcher("/front/cart.jsp").forward(request, response);
	}

}
