package com.shop.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shop.dao.GoodDao;
import com.shop.dao.UserDao;
import com.shop.daoImpl.GoodDaoImpl;
import com.shop.daoImpl.UserDaoImpl;
import com.shop.pojo.Goods;
import com.shop.pojo.User;


public class AddGoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	//添加商品
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String goodname = request.getParameter("goodname");
		String gooddesc = request.getParameter("gooddesc");
		Double goodpirce = Double.valueOf(request.getParameter("goodpirce"));
		Double goodrprice = Double.valueOf(request.getParameter("goodrprice"));
		int goodnum = Integer.valueOf(request.getParameter("goodnum"));
		int goodsnum = Integer.valueOf(request.getParameter("goodsnum"));
		
		Goods good = new Goods();
		good.setGoodname(goodname);
		good.setGooddesc(gooddesc);
		good.setGoodpirce(goodpirce);
		good.setGoodrprice(goodrprice);
		good.setGoodnum(goodnum);
		good.setGoodsnum(goodsnum);
		GoodDao dao = new GoodDaoImpl();
		int flag = dao.addGood(good);
		if(flag!=0){
			request.setAttribute("mes", "添加成功！");
			request.getRequestDispatcher("/goodListServlet").forward(request, response);
		}else{
			request.setAttribute("mes", "添加失败！");
			request.getRequestDispatcher("behind/addGood.jsp").forward(request, response);
		}
		
	}

}
