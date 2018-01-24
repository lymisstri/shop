package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.UserDao;
import com.shop.daoImpl.UserDaoImpl;
import com.shop.pojo.User;


public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	//Ç°Ì¨µÇÂ¼
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		User user = new User();
		UserDao dao = new UserDaoImpl();
		user = dao.login(username, userpass);
		if(user!=null){
			session.setAttribute("user", user);
			request.getRequestDispatcher("/showGoodServlet").forward(request, response);
		}
	}

}
