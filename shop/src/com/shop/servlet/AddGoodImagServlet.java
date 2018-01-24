package com.shop.servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shop.dao.GoodDao;
import com.shop.daoImpl.GoodDaoImpl;
import com.shop.pojo.Goods;

public class AddGoodImagServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	
	//添加商品图片
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Goods good = new Goods();
		GoodDao dao = new GoodDaoImpl();
		String path="";
		String saveName="";
		String id = "";
		List items = null;
		try {
		items = upload.parseRequest(request);
		} catch (FileUploadException e) {
		e.printStackTrace();
		} // 解析request请求
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.isFormField()) {  // 如果是表单域 ，就是非文件上传元素
			String name = item.getFieldName(); // 获取name属性的值
			String value = item.getString(); // 获取value属性的值
			if (name.equals("goodid")) {
				id = value;
			} 
			}else {
//				fieldName = item.getFieldName(); // 文件域中name属性的值
				String fileName = item.getName(); // 文件的全路径，绝对路径名加文件名
		//		String contentType = item.getContentType(); // 文件的类型
		//		long size = item.getSize(); // 文件的大小，以字节为单位
				System.out.println(fileName);
				saveName = UUID.randomUUID().toString() + fileName.substring
						(fileName.lastIndexOf("."));
				System.out.println(saveName);
				path = request.getSession().getServletContext().getRealPath("/upload/");
				File f = new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				File saveFile = new File(path+"\\"+saveName); // 定义一个file指向一个具体的文件
				System.out.println(path+"\\"+saveName);
				try {
				item.write(saveFile);// 把上传的内容写到一个文件中
				} catch (Exception e) {
				e.printStackTrace();
				} 
				}
		}
		good = dao.queryGoodsById(Integer.valueOf(id));
		good.setGoodimag("/upload/"+saveName);
		int flag = dao.updateGoods(good);
		if(flag!=0){
			request.setAttribute("mes", "添加成功！");
			request.getRequestDispatcher("/goodListServlet").forward(request, response);
		}else{
			request.setAttribute("mes", "添加失败！");
			request.getRequestDispatcher("behind/addGoodImag.jsp").forward(request, response);
		}
     
	}
}
