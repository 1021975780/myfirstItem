<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="no-cache" />
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0,minimal-ui" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>${good.goodName }-为发烧而生</title>
<link rel="stylesheet" type="text/css" href="common/css/common.css">
<style>
body {
	background: #FFF;
}

#indexNum02 .index-head {
	outline: 1px solid #e7e7e7;
	border-style: none none solid none;
	background: #F4F4F4;
	padding: 1.2em 0em 1.2em 0em;
	position: relative;
}

#indexNum02 .index-head .s_title {
	font-size: 2.365em;
	color: #666;
	outline: 0px solid #0033CC;
}

#indexNum02 .index-head .left {
	outline: 0px solid #FF0000;
	position: absolute;
	left: 1em;
	top: 1.2em;
	padding: 0em 1em 0em 0px;
}

#indexNum02 .index-head .left .home {
	outline: 0px solid #FF0000;
}

#indexNum02 .index-head .left .home .mall {
	width: 3em;
	height: 3em;
	color: #424242;
	display: inline-block;
	outline: 0px solid #FF0000;
	margin-left: 1em;
	background: url(common/images/icon_home.png) no-repeat;
	background-size: 100% 100%;
}

#indexNum02 .index-head .right {
	outline: 0px solid #FF0000;
	position: absolute;
	right: 1em;
	top: 1.2em;
	padding: 0em 1em 0em 0px;
}

#indexNum02 .index-head .right .a1 {
	width: 3em;
	height: 3em;
	display: inline-block;
	margin-left: 1em;
	outline: 0px solid #FF0000;
}

#indexNum02 .index-head .right .user {
	background: url(common/images/icon_03.png) no-repeat;
	background-size: 100% 100%;
}

#indexNum02 .index-head .right .cart {
	background: url(common/images/icon_02.png) no-repeat;
	background-size: 100% 100%;
}

#goods_list {
	outline: 0px solid #FF0000;
	background: #FFF;
}

#goods_list .centerNum20150618 {
	
}

#goods_list .centerNum20150618 .goods_content {
	padding: 0em;
	background: #FFF;
	margin: 1em;
}

#goods_list .centerNum20150618 .goods_content .g_info {
	padding: 1em;
	border: 1px solid #f4f4f4;
	border-style: none none solid none;
}

#goods_list .centerNum20150618 .goods_content .g_info table {
	
}

#goods_list .centerNum20150618 .goods_content .g_info   img {
	width: 8em;
	height: 8em;
}

#goods_list .centerNum20150618 .goods_content .g_info .s_name {
	outline: 0px solid #FF0000;
	font-size: 1.8em;
	color: #333;
}

#goods_list .centerNum20150618 .goods_content .g_info .money {
	outline: 0px solid #FF0000;
	font-size: 1.2em;
	color: #999;
}

#goods_list .centerNum20150618 .goods_content .g_info .help {
	outline: 0px solid #FF0000;
	color: #999;
	font-size: 1.4em;
}

#goods_list .centerNum20150618 .goods_content .g_info .delete {
	position: relative;
}

#goods_list .centerNum20150618 .goods_content .g_info .number {
	position: relative;
}

#goods_list .centerNum20150618 .goods_content .g_info .number table {
	border-collapse: collapse;
}

#goods_list .centerNum20150618 .goods_content .g_info .number td {
	border: 1px solid #CCC;
}

#goods_list .centerNum20150618 .goods_content .g_info .number .snum {
	display: inline-block;
	text-align: center;
	font-size: 2em;
	width: 1.5em;
}

#goods_list .centerNum20150618 .goods_content .g_info .number .t01 {
	background: #f4f4f4;
}

#goods_list .centerNum20150618 .goods_content .g_info .number .t02 {
	background: #FFF;
	border: 0px;
}

#goods_list .centerNum20150618 .goods_content .g_info .number .t03 {
	background: #eee;
}

#goods_list .centerNum20150618 .goods_content .g_info .cl {
	font-size: 1.6em;
	color: black;
	position: absolute;
	right: 0em;
	top: 0em;
	background: #eee;
	padding: 0.2em;
}

#goods_list .centerNum20150618 .goods_content .buy {
	background: #F3F5F6;
}

#goods_list .centerNum20150618 .goods_content .buy .buy_ok {
	width: 49%;
	text-align: center;
	font-size: 1.4em;
	padding: 1em 0em 1em 0em;
	float: left;
	border: 1px solid #CCC;
	border-style: none solid none none;
}

#goods_list .centerNum20150618 .goods_content .buy .buy_cart {
	width: 49%;
	text-align: center;
	font-size: 1.4em;
	padding: 1em 0em 1em 0em;
	float: right;
}

.s_js {
	border-style: solid none none none;
	padding: 2em 0em;
	position: relative;
}

.s_js .js_jz {
	font-size: 1.4em;
	color: #FF6600;
}

.s_js .js_ok {
	font-size: 2em;
	color: #FFF;
	background: #FF6600;
	border-radius: 0.2em;
	width: 8em;
	text-align: center;
	padding: 0.3em 0em;
}
</style>
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function remove(node) {
		node.parents(".g_info").remove();
// 		var url = "/MyFirstItem/manageServlet";
// 		var id = node.attr("sid");
// 		data = {
// 			"method" : "removeFromCar",
// 			"id" : id
// 		};
// 		//$(location).attr("href","/MyFirstItem/manageServlet?method=removeFromCar");
// 		$.getJSON(url, data, function(data) {
			
// 		})
	}
	$(function() {
		$(".snum.t03").click(function(sum) {
			sum = $(this).parent().prev().find(":first-child").val();
			sum = sum * 1 + 1;
			$(this).parent().prev().find(":first-child").val(sum);
			var url = "/MyFirstItem/manageServlet";
			var id=$(this).attr("cid");
			data={"sum":sum,"method":"changePrice","id":id};
			$.getJSON(url, data, function(data) {
				var totalPrice= data.totalPrice;
				$(".js_jz").text("应付金额："+totalPrice+"元");
			})
			return false;
		})
		$(".snum.t01").click(function(sum) {
			sum = $(this).parent().next().find(":first-child").val();
			//alert(sum);
			if (sum > 0) {
				sum = sum * 1 - 1;
				$(this).parent().next().find(":first-child").val(sum);
			} 
			var url = "/MyFirstItem/manageServlet";
			var id=$(this).attr("cid");
			data={"sum":sum,"method":"changePrice","id":id};
			$.getJSON(url, data, function(data) {
 				var totalPrice= data.totalPrice;
 				$(".js_jz").text("应付金额："+totalPrice+"元");
			if (sum==0) {
				remove($(".cl:first"));
			}
			})
			return false;
		})
		$(".cl").click(function() {
			var url = "/MyFirstItem/manageServlet";
			var id = $(this).attr("sid");
			data = {
				"method" : "removeFromCar",
				"id" : id
			};
			//$(location).attr("href","/MyFirstItem/manageServlet?method=removeFromCar");
			$.getJSON(url, data, function(data) {
				var totalPrice= data.totalPrice;
 				$(".js_jz").text("应付金额："+totalPrice+"元");
			})
			$(this).parents(".g_info").remove();
		})
		$(".js_ok").click(function () {
			$(location).attr("href", "/MyFirstItem/user/orderForm.jsp");
		})
	})
</script>
</head>
<body>
	<c:set var="countPay" value="0" scope="session"></c:set>
	<div id="indexNum02">
		<div class="index-head clearfix">
			<div class="left">
				<div class="home">
					<a href="index.jsp" class="mall"></a>
				</div>
			</div>
			<center>
				<span class="s_title">购物车</span>
			</center>
			<div class="right">
				<a href="" class="a1 cart" title="购物车"></a>
			</div>
		</div>
	</div>
	<div id="goods_list">
		<div class="centerNum20150618">
			<ul>
				<li class="goods_content"><c:forEach
						items="${sessionScope.shoppingCar }" var="good">
						<div class="g_info">
							<table width="100%">
								<tr>
									<td width=1><img src="${good.image }" /></td>
									<td><span class="s_name">${good.goodName }</span><br /> <span
										class="money">售价：${good.price }元</span> <span
										do=${ countPay=countPay+good.price}></span> <br />
									<br />
										<table width="100%">
											<tr>
												<td>
													<div class="delete">
														<div class="number">
															<table>
																<tr>
																	<td><a cid="${good.goodId }" class="snum t01" href="a"
																		onclick="remove()">-</a></td>
																	<td><input cid="b" class="snum t02" type="text"
																		value="${sumPrice[good.goodId] }" /></td>
																	<td><a cid="${good.goodId }" class="snum t03" href="c"
																		onclick="add()">+</a></td>
																</tr>
															</table>
														</div>
														<div class="cl" sid=${good.goodId }>
															<a href="#">删</a>
														</div>
													</div>
												</td>
											</tr>
										</table></td>
								</tr>
							</table>
						</div>
					</c:forEach></li>

			</ul>
		</div>
		<div class="s_js">
			<table width="100%">
				<tr>
					<td style="padding-left: 1em;"><span class="js_jz">应付金额：${sessionScope.totalPrice }元</span></td>
					<td width=1 style="padding-right: 1em;"><div class="js_ok">结算</div></td>
				</tr>
			</table>


		</div>
	</div>


</body>
</html>


