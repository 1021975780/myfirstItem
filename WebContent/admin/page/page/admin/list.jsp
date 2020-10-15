<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://www.666666.com" prefix="j" %> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/MyFirstItem/admin/page/main/css/right.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function remove() {
		var name = $("tr:eq(1) td:first").text();
		var id = $("a:eq(1)").next().attr("sid");
		if (id == null) {
			alert("请先查找要删除的管理员");
		} else {
			if (confirm("你确定要删除" + name + "吗?")) {
				//var id=$("a:eq(1)").next().text();
				//alert(id);
				$(location).attr("href",
						"/MyFirstItem/adminServlet?method=remove&id=" + id);
			}
		}
	}
	function search() {
		var url = "/MyFirstItem/adminServlet";
		var email = $("#email").val();
		dataa = {
			"method" : "search",
			"email" : email
		};
		$.getJSON(url, dataa, function(data) {
			$("tr:eq(1) td:eq(0)").text(data.email);
			$("img").attr("src", data.image);
			//alert($("img").attr("src"));
			$("a:eq(1)").attr(
					"href",
					"/MyFirstItem/adminServlet?method=forwardModify&id="
							+ data.id);
			$("a:eq(1)").next().attr("sid", data.id);
			//$("a:eq(1)").next().text(data.id);
		})
	}
	$(function() {
		$("a:eq(1)").click(function() {
			if ($(this).attr("href")=="") {
				alert("请先选出要修改的管理员");
			}
		})
	})
</script>
</head>
<body>
	<div id="right_font">
		<div></div>
		您现在所在的位置：首页 &rarr; 管理菜单 &rarr; <span>管理员管理</span>
	</div>
	<div class="searchdiv">
		<div>
			管理员邮箱：<input id="email" type="text" value="${param.email }" />
		</div>
		<div class="btn1" onclick="search()">查 找</div>

	</div>
	<table class="table">

		<tr>
			<th style="width: 150px;">邮箱</th>
			<th style="width: 100px;">一寸艳照</th>
			<th style="width: 100px;">操作</th>
		</tr>


		<tr>

			<td align="center"></td>
			<td align="center"><img src=""
				style="width: 100px; height: 100px;"></td>
			<td align="center"><a
				href="/MyFirstItem/admin/page/page/admin/add.jsp"><div
						class="add" title="添加"></div></a> <a
				href="">
					<div class="modify" title="修改"></div>
			</a>
				<div class="del" onclick="remove()" title="删除"></div></td>
		<tr>
		<tr>
			<td colspan="5" valign="middle" style="background: #F6F6F6"></td>
		</tr>

	</table>


</body>


</html>
