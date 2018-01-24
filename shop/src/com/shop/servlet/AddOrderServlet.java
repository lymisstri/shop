package com.shop.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.CartDao;
import com.shop.dao.OrderDao;
import com.shop.dao.UserDao;
import com.shop.daoImpl.CartDaoImpl;
import com.shop.daoImpl.OrderDaoImpl;
import com.shop.daoImpl.UserDaoImpl;
import com.shop.pojo.Cart;
import com.shop.pojo.Order;
import com.shop.pojo.User;


public class AddOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//添加订单
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		User user = (User) session.getAttribute("user");
		Double totalprice = (Double) session.getAttribute("totalprice");
		CartDao cartdao = new CartDaoImpl();
		List<Cart> cartlist = cartdao.queryCartByUser(user.getId());
		for(Cart c : cartlist){
			c.setStatus(0);
			cartdao.updateCart(c);
		}
		Order order = new Order();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date date=new Date();  
		String str=sdf.format(date); 
		order.setDate(str);
		order.setOrderid(user.getId());
		order.setTotalprice(totalprice);
		OrderDao orderDao = new OrderDaoImpl();
		UserDao userdao = new UserDaoImpl();
		user.setRank(user.getRank() + totalprice);
		userdao.updateRank(user);
		orderDao.addOrder(order);
		request.setAttribute("mes", "已提交订单");
		request.getRequestDispatcher("/showOrderServlet").forward(request, response);
		
	}

}
