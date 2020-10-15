<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	input {width:500px;}
</style>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<table class="table">
	<form action="/MyFirstItem/manageServlet?method=modifyPrice" method="post" >
		<tr>
			<th align="center" colspan="2">商品管理</th>
		</tr>
	
		<tr>
			
			<td>修改价格:</td>
			<td>
				<input type="hidden" name="id" value="${goods.goodId }"/>
				<input type="text" name="price" value="${goods.price }"/>
			</td>
			
		</tr>
	
		<tr>
			<td colspan="2">修改:<input type="submit"  value="修改"/></td>
		</tr>
	</form>
			
		
	</table>

	
</body>


</html>
