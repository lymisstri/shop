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
		<p>购物车</p>
		<a href="/shop/deleteAllCartServlet">清空购物车</a> | <a href="/shop/showGoodServlet">返回主页</a>
			<table border="1px" cellpadding="5px" width="50%">
			<tr align="center">
				<td>商品图片</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>数量</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${cartlist }" var="item">
				<tr align="center">
					<td><img alt="" height="150px" width="150px" src="<%=request.getContextPath() %>${item.good.goodimag }"></td>
					<td>${item.good.goodname }</td>
					<td>
						<c:if test="${sessionScope.user.rank le 1000}">
							${item.good.goodpirce }
						</c:if>
						<c:if test="${sessionScope.user.rank gt 1000}">
							${item.good.goodrprice }
						</c:if>
					</td>
					<td>${item.num }</td>
					<td>
						<a href="/shop/deleteCartServlet?cartid=${item.id }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<h1>总价格：${sessionScope.totalprice }</h1> <a href="/shop/addOrderServlet">提交订单</a>
	</center>
	<script type="text/javascript">
		if('${mes}'!=''){
	  	alert('${mes }');
	  	}
	</script>
</body>
</html>