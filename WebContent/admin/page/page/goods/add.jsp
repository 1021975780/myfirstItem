<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../../main/css/right.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	input {width:500px;}
</style>
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<table class="table">
	<form action="/MyFirstItem/manageServlet?method=add" method="post" enctype="multipart/form-data">
		<tr>
			<th align="center" colspan="2">商品管理</th>
		</tr>
		<tr>
			<td>商品分类名字:</td>
			<td>
				<select name="gclassId" >
					<a:forEach items="${list }" var="a">
						<option value="${a.gclassId }">${a.name }</option>
					</a:forEach>
				</select>
			</td>
		</tr>
		<tr>
			
			<td>商品名字:</td>
			<td><input type="text" name="goodName" value=""/><font color="red"></font></td>
			
		</tr>
		<tr>
			<td>商品照片:</td>
			<td><input type="file" name="image" value=""/></td>
			
		</tr>
		<tr>
			<td>商品价格:</td>
			<td><input type="text" name="price" value=""/></td>
		</tr>
		<tr>
			<td>商品描述:</td>
			<td><input type="text" name="miaoshu" value=""/></td>
		</tr>
		<tr>
			<td colspan="2">添加:<input type="submit"  value="添加"/></td>
		</tr>
	</form>
			
		
	</table>

	
</body>


</html>
