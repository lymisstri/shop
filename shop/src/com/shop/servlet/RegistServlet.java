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


public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	//ÓÃ»§×¢²á
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		User user = new User();
		user.setRank(0.00);
		user.setUsername(username);
		user.setUserpass(userpass);
		UserDao dao = new UserDaoImpl();
		int flag = dao.userRegist(user);
		if(flag!=0){
			request.setAttribute("mes", "×¢²á³É¹¦£¡");
			request.getRequestDispatcher("front/login.jsp").forward(request, response);
		}else{
			request.setAttribute("mes", "×¢²áÊ§°Ü£¡");
			request.getRequestDispatcher("front/regist.jsp").forward(request, response);
		}
		
	}

}
