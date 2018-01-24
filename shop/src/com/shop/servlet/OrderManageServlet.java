package com.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.GoodDao;
import com.shop.dao.OrderDao;
import com.shop.daoImpl.GoodDaoImpl;
import com.shop.daoImpl.OrderDaoImpl;
import com.shop.pojo.Goods;
import com.shop.pojo.Order;
import com.shop.pojo.User;




public class OrderManageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//后台订单管理
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		List<Order> list = new ArrayList<Order>();
		OrderDao dao = new OrderDaoImpl();
		list = dao.queryOrder();
		
		request.setAttribute("orderlist", list);
		request.getRequestDispatcher("/behind/order.jsp").forward(request, response);
	}

}
