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
	
	//�����ƷͼƬ
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
		} // ����request����
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (item.isFormField()) {  // ����Ǳ��� �����Ƿ��ļ��ϴ�Ԫ��
			String name = item.getFieldName(); // ��ȡname���Ե�ֵ
			String value = item.getString(); // ��ȡvalue���Ե�ֵ
			if (name.equals("goodid")) {
				id = value;
			} 
			}else {
//				fieldName = item.getFieldName(); // �ļ�����name���Ե�ֵ
				String fileName = item.getName(); // �ļ���ȫ·��������·�������ļ���
		//		String contentType = item.getContentType(); // �ļ�������
		//		long size = item.getSize(); // �ļ��Ĵ�С�����ֽ�Ϊ��λ
				System.out.println(fileName);
				saveName = UUID.randomUUID().toString() + fileName.substring
						(fileName.lastIndexOf("."));
				System.out.println(saveName);
				path = request.getSession().getServletContext().getRealPath("/upload/");
				File f = new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				File saveFile = new File(path+"\\"+saveName); // ����һ��fileָ��һ��������ļ�
				System.out.println(path+"\\"+saveName);
				try {
				item.write(saveFile);// ���ϴ�������д��һ���ļ���
				} catch (Exception e) {
				e.printStackTrace();
				} 
				}
		}
		good = dao.queryGoodsById(Integer.valueOf(id));
		good.setGoodimag("/upload/"+saveName);
		int flag = dao.updateGoods(good);
		if(flag!=0){
			request.setAttribute("mes", "��ӳɹ���");
			request.getRequestDispatcher("/goodListServlet").forward(request, response);
		}else{
			request.setAttribute("mes", "���ʧ�ܣ�");
			request.getRequestDispatcher("behind/addGoodImag.jsp").forward(request, response);
		}
     
	}
}
