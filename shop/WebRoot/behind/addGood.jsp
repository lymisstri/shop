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
		<p>新增商品</p>
		<form action="/shop/addGoodServlet" method="post" >
			商品名称：<input type="text" name="goodname"><br><br>
			商品描述：<textarea rows="5" cols="17" name="gooddesc"></textarea><br><br>
			商品原价：<input type="text" name="goodpirce"><br><br>
			会员价：&nbsp;&nbsp;<input type="text" name="goodrprice"><br><br>
			商品库存：<input type="text" name="goodnum"><br><br>
			<input type="hidden" value="0" name="goodsnum"><br>
			<input type="submit" value="新增">
		</form>
	</center>
	<script type="text/javascript">
		if('${mes}'!=''){
	  	alert('${mes }');
	  	}
	</script>
</body>
</html>