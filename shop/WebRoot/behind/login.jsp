<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<p>后台登录</p>
		<form action="/shop/adminLoginServlet" method="post">
			用户名：<input type="text" name="username"><br>
			密&nbsp;&nbsp;码：<input type="password" name="userpass"><br>
			<input type="submit" value="登录">
		</form>
	</center>
	<script type="text/javascript">
		if('${mes}'!=''){
	  	alert('${mes }');
	  	}
	</script>
</body>
</html>