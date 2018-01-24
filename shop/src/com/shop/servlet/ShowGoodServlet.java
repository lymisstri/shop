package com.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.GoodDao;
import com.shop.daoImpl.GoodDaoImpl;
import com.shop.pojo.Goods;




public class ShowGoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//�鿴��Ʒ
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Goods> list = new ArrayList<Goods>();
		GoodDao dao = new GoodDaoImpl();
		list = dao.queryAllGood();
		
		request.setAttribute("goodlist", list);
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
	}

}
