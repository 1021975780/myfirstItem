<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/MyFirstItem/admin/page/main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function() {
	$("#sea").click(function() {
		var name=$("#name").val();
		$(location).attr("href", "/MyFirstItem/manageServlet?method=searchInfo&goodName="+name);
	})
})
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<div class="searchdiv">
		<div>商品名称：<input id="name" type="text" value=""/></div><div id="sea" class="btn1" onclick="search()">查 找</div>
	</div>
	<table class="table">
		<tr>
			<th style="width:50px;">商品分类名字</th>
			<th style="width:150px;">商品名字</th>
			<th style="width:100px;">商品照片</th>
			<th style="width:100px;">商品价格</th>
			<th style="width:100px;">商品描述</th>
<!-- 			<th style="width:100px;">操作</th> -->
		</tr>

        	<c:forEach items="${requestScope.list }"  var="a">
			 <tr>
		
				<td align="center">${a.gclassName }</td>
				<td align="center">${a.goodName }</td>
				<td align="center"><img src="${a.image }" style="width:100px;height:100px"/></td>
				<td align="center">${a.price }</td>
				<td align="center">${a.miaoshu }</td>
<!-- 				<td align="center"> -->
<!-- 	            	<a href="goodsFindAllGclassAction.action"><div class="add"  title="添加"></div></a> -->
<%-- 	               <a href="goodsFindByIdAction.action?id=${a.id }"> <div class="modify"  title="修改"></div></a> --%>
<%-- 	                <div class="del" onclick="remove(${a.id})"  title="删除"></div> --%>
<!-- 	            </td> -->
			</tr>
			</c:forEach>	
		<tr>
			<td colspan="7" valign="middle" style="background:#F6F6F6">
			
			<j:navigator/>
			
			</td>
		</tr>
		
	</table>

	
</body>


</html>
