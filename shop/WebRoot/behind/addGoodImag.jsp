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
		<p>添加商品图片</p>
		<br>
		<form action="/shop/addGoodImagServlet" method="post" enctype="multipart/form-data">
			选择图片：<br>
			<input type="file" name="goodimag"><br>
			<input type="hidden" name="goodid" value="${param.goodid }"><br>
			<input type="submit" value="上传">
		</form>
	</center>
	<script type="text/javascript">
		if('${mes}'!=''){
	  	alert('${mes }');
	  	}
	</script>
</body>
</html>