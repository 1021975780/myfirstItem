<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/MyFirstItem/admin/page/main/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function message() {
		var href1="/MyFirstItem/manageServlet?method=showAll";
		$(location).attr('href', href1);
	}
	function add() {
		var href1="/MyFirstItem/manageServlet?method=showKind";
		$(location).attr('href', href1);
// 		return;
// 		var goodName=$("#goodName").val();
// 		var price=$("#price").val();
// 		var kind=$("#kind").val();
// 		var url="/MyFirstItem/manageServlet";
// 		var data={"goodName":goodName,"method":"add","price":price,"kind":kind};
// 		$.getJSON(url, data, function(data) {
// 			$("#kind").prev().remove();
// 			$("#kind").remove();
// 			$("#goodName").remove();
// 			$("#price").remove();
// 			search();
// 		})
		//location.href="/MyFirstItem/manageServlet?method=add&goodName="+goodName;
	}
	function search() {
		var size=$("tr").length;
		for (var i = 1; i <size; i++) {
			$("tr:eq(1)").remove();
		}
		var goodName=$("#name").val();
		var url="/MyFirstItem/manageServlet";
		var data={"goodName":goodName,"method":"search"};
		$.getJSON(url, data, function(data) {
			for (var i = 0; i < data.length; i++) {
				$("tr:last").after(" <tr><td align='center'>"+data[i].goodId+"</td>"
				+"<td align='center'>"+data[i].goodName+"</td>"
						+"<td align='center'>"+data[i].price+"</td>"
						+"<td align='center'>"
			            	+"<div class='add'  title='添加'></div>"
			               +" <div class='modify'  title='修改'></div>"
			                +"<div class='del'   title='删除'></div>"
			            +"</td>"
					+"</tr>");
				}
				$(".add").click(function() {
					var bool=confirm("你确定要添加吗？");
					if (bool) {
					var href1="/MyFirstItem/manageServlet?method=showKind";
					$(location).attr('href', href1);
					}
				})
					$(".del").click(function() {
					var name=$(this).parent().prev().prev().text();
					var id=$(this).parent().prev().prev().prev().text();
					var bool=confirm("你确定要删除"+name+"吗？");
					if (bool) {
						var url="/MyFirstItem/manageServlet";
						var data={"goodID":id,"method":"delete"};
						$.getJSON(url, data, function(data) {
							search();
						})
					}
				})
				$(".modify").click(function() {
					var name=$(this).parent().prev().prev().text();
					var id=$(this).parent().prev().prev().prev().text();
					var href1="/MyFirstItem/manageServlet?method=forwordModify&goodId="+id;
					var bool=confirm("你确定要修改"+name+"吗？");
					if (bool) {
						$(location).attr('href', href1);
					}
					
				})
		})
	}
	$(function() {
		search();
	})
</script>
</head>
<body>

	<div id="right_font">
		<div></div> 
		您现在所在的位置：首页 &rarr; 商品管理 &rarr; <span>商品管理</span>
	</div>
	<div class="searchdiv">
		<div>文件名称：<input id="name" type="text" value=""/></div><div class="btn1" onclick="search()">查 找</div>
		<div class="btn1" onclick="add()">添加</div>
		<div class="btn1" onclick="message()">详细信息</div>
	</div>
	<table class="table">
		<tr>
			<th style="width:50px;">ID</th>
			<th style="width:100px;">商品名称</th>
			<th style="width:50px;">价格</th>
			<th style="width:50px;">操作</th>
		</tr>
<!-- 		<tr> -->
<!-- 			<td colspan="5" valign="middle" style="background:#F6F6F6"> -->
				
<!-- 			</td> -->
<!-- 		</tr> -->
	</table>

	
</body>


</html>
