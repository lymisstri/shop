package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UserDao;
import com.shop.daoImpl.UserDaoImpl;
import com.shop.pojo.User;



public class UserListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//查看所有用户
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> list = new ArrayList<User>();
		UserDao dao = new UserDaoImpl();
		list = dao.queryUsers();
		
		request.setAttribute("userlist", list);
		request.getRequestDispatcher("/behind/userList.jsp").forward(request, response);
	}

}
