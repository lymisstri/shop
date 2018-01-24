package com.shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.UserDao;
import com.shop.daoImpl.UserDaoImpl;

public class DeleteUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	//删除用户
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int result = 0;
		int userid = Integer.parseInt(request.getParameter("userid"));
		UserDao dao = new UserDaoImpl();
		result = dao.deleteUser(userid);
		
		if(result!=0){
			request.setAttribute("mes", "删除成功");
			request.getRequestDispatcher("/userListServlet").forward(request, response);
		}
		
		
	}

}
