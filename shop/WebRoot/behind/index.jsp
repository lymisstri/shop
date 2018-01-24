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
		<p>后台主页</p>
	</center>
	<ul>
		<li><a href="/shop/userListServlet">用户管理</a></li>
		<li><a href="/shop/goodListServlet">商品管理</a></li>
		<li><a href="/shop/orderManageServlet">订单管理</a></li>
	</ul>
	<script type="text/javascript">
		if('${mes}'!=''){
	  	alert('${mes }');
	  	}
	</script>
</body>
</html>