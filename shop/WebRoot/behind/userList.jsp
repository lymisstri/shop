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
		<h1>潮鞋商城后台系统</h1>
		<hr>
		<p>用户管理</p>
		<table border="1px" cellpadding="5px" width="50%">
			<tr align="center">
				<td>id</td>
				<td>姓名</td>
				<td>密码</td>
				<td>会员等级</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${userlist }" var="item">
				<tr align="center">
					<td>${item.id }</td>
					<td>${item.username }</td>
					<td>${item.userpass }</td>
					<td>${item.rank }</td>
					<td>
						<a href="/shop/deleteUserServlet?userid=${item.id }">删除</a>
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