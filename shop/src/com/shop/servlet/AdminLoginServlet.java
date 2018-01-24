package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.AdminDao;
import com.shop.dao.UserDao;
import com.shop.daoImpl.AdminDaoImpl;
import com.shop.daoImpl.UserDaoImpl;
import com.shop.pojo.Admin;
import com.shop.pojo.User;


public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	//管理员后台登录
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String adminname = request.getParameter("username");
		String adminpass = request.getParameter("userpass");
		Admin admin = new Admin();
		AdminDao dao = new AdminDaoImpl();
		admin = dao.login(adminname, adminpass);
		if(admin!=null){
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("behind/index.jsp").forward(request, response);
		}else{
			request.setAttribute("mes", "用户名或者密码错误！");
			request.getRequestDispatcher("behind/login.jsp").forward(request, response);
		}
	}

}
