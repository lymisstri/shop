<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/shop/css/style.css">
<title>登录</title>
</head>
<body>
	<center>
		<h1>潮鞋商城</h1>
		<hr>
		<p>商品展示</p>
		<form action="/shop/querGoodByWordServlet" method="post">
			商品名：<input type="text" name="word"><input type="submit" value="搜索">
			<a href="/shop/showCartServlet">查看购物车</a> |
			<a href="/shop/showOrderServlet">查看订单</a>
		</form>
		<br>
		<table border="1px" cellpadding="5px" width="80%">
			<tr align="center">
				<td>商品图片</td>
				<td>商品名称</td>
				<td>商品描述</td>
				<td>商品原价</td>
				<td>会员价</td>
				<td>库存数量</td>
				<td>已售数量</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${goodlist }" var="item">
				<tr align="center">
					<td><img alt="" height="150px" width="150px" src="<%=request.getContextPath() %>${item.goodimag }"></td>
					<td>${item.goodname }</td>
					<td>${item.gooddesc }</td>
					<td>${item.goodpirce }</td>
					<td>${item.goodrprice }</td>
					<td>${item.goodnum }</td>
					<td>${item.goodsnum }</td>
					<td>
						<a href="/shop/addCartServlet?goodid=${item.id }">添加购物车</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>