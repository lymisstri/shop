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
		<p>订单</p>
		<a href="/shop/showGoodServlet">返回主页</a>
			<table border="1px" cellpadding="5px" width="50%">
			<tr align="center">
				<td>订单编号</td>
				<td>订单用户</td>
				<td>日期</td>
				<td>订单总价</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${orderlist }" var="item">
				<tr align="center">
					<td>${item.id }</td>
					<td>${sessionScope.user.username }</td>
					<td>${item.date }</td>
					<td>${item.totalprice }</td>
					<td>
						<a href="/shop/deleteOrderServlet?orderid=${item.id }">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
	<script type="text/javascript">
		if('${mes}'!=''){
	  	alert('${mes }');
	  	}
	</script>
</body>
</html>