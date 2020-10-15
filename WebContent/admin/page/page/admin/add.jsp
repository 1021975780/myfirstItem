<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://www.666666.com" prefix="j" %> --%>
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
<script type="text/javascript">
	$(function() {
		$(":text").change(function() {
			url="/MyFirstItem/adminServlet?method=addAdmin";
			var email= $(this).val();
			data={"email":email};
			$.getJSON(url, data,function(data) {
				var error=data.error;
				$("font").text(data.error);
			})
		})
		$(":password:eq(1)").change(function() {
			url="/MyFirstItem/adminServlet?method=addAdmin";
			var pwd1= $(this).val();
			var pwd=$(":password:eq(0)").val();
			data={"pwd1":pwd1,"pwd":pwd};
			$.getJSON(url, data,function(data) {
				var error=data.error;
				$("font").text(data.error);
			})
		})
	})
</script>
</head>
<body>
	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 管理员管理 &rarr; <span>管理员管理</span>
	</div>
	<table class="table">
	<form action="/MyFirstItem/adminServlet?method=addAdmin&&submit=upload" method="post" enctype="multipart/form-data">
		<tr>
			<th align="center" colspan="2">管理员管理</th>
		</tr>
	
		<tr>
			
			<td>邮箱:</td>
			<td><input type="text" name="email" value=""/></td>
			
		</tr>
		<tr>
			<td>艳照:</td>
			<td><input type="file" name="image" value=""/></td>
			
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="pwd" value=""/></td>
		</tr>
		<tr>
			<td>密码确认:</td>
			<td><input type="password" name="pwd1" value=""/></td>
		</tr>
		<tr>
			<td colspan="2">添加:<input type="submit"  value="添加"/><font color="red">${error }</font></td>
		</tr>
	</form>
			
		
	</table>

	
</body>


</html>
