package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shop.dao.OrderDao;
import com.shop.daoImpl.OrderDaoImpl;


public class DeleteOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//É¾³ý¶©µ¥
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int result = 0;
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		OrderDao dao = new OrderDaoImpl();
		result = dao.deleteOrder(orderid);
		
		if(result!=0){
			request.setAttribute("mes", "É¾³ý³É¹¦");
			request.getRequestDispatcher("/showOrderServlet").forward(request, response);
		}
		
		
	}

}
