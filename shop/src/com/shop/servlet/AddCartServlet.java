package com.shop.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shop.dao.CartDao;
import com.shop.dao.GoodDao;
import com.shop.dao.UserDao;
import com.shop.daoImpl.CartDaoImpl;
import com.shop.daoImpl.GoodDaoImpl;
import com.shop.daoImpl.UserDaoImpl;
import com.shop.pojo.Cart;
import com.shop.pojo.Goods;
import com.shop.pojo.User;


public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	//添加购物车
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int goodid = Integer.valueOf(request.getParameter("goodid"));
		GoodDao gooddao = new GoodDaoImpl();
		CartDao cartdao = new CartDaoImpl();
		User user = (User) request.getSession().getAttribute("user");
		Cart cart = new Cart();
		Goods good = gooddao.queryGoodsById(goodid);
		cart.setCartno(user.getId());
		cart.setUserid(user.getId());
		cart.setGoodid(goodid);
		cart.setGood(good);
		
		if(good.getGoodnum()<1){
			request.setAttribute("mes", "库存不足");
			request.getRequestDispatcher("/showGoodServlet").forward(request, response);
		}else{
			cart.setNum(1);
			good.setGoodnum(good.getGoodnum()-1);
			good.setGoodsnum(good.getGoodsnum()+1);
			gooddao.updateGoods(good);
		}
		cart.setStatus(1);
		int flag = cartdao.addCart(cart);
		if(flag!=0){
			request.setAttribute("mes", "添加成功！");
			request.getRequestDispatcher("/showGoodServlet").forward(request, response);
		}else{
			request.setAttribute("mes", "系统异常");
			request.getRequestDispatcher("/showGoodServlet").forward(request, response);
		}
		
	}

}
