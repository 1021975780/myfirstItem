<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="no-cache" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0,minimal-ui" />   
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>个人信息页</title>
<link rel="stylesheet" type="text/css" href="common/css/common.css">
<style>
 
#indexNum02 .index-head{
	outline:1px solid #e7e7e7;
	border-style:none none solid none;
	background:#F4F4F4;
	padding:1.2em 0em 1.2em 0em;
	position:relative;
}
#indexNum02 .index-head .s_title{
	font-size:2.365em;
	color:#666;
	outline:0px solid #0033CC;
}
#indexNum02 .index-head .left{
	outline:0px solid #FF0000;
	position:absolute;
	left:1em;
	top:1.2em;
	padding:0em 1em 0em 0px;
}
#indexNum02 .index-head .left .home{
	outline:0px solid #FF0000;
}
#indexNum02 .index-head .left .home .mall{
	width:3em;
	height:3em;
	color: #424242;
	display:inline-block;
	outline:0px solid #FF0000;
	margin-left:1em;
	background:url(common/images/icon_home.png) no-repeat;
	background-size:100% 100%;
}
#indexNum02 .index-head .right{
	outline:0px solid #FF0000;
	position:absolute;
	right:1em;
	top:1.2em;
	padding:0em 1em 0em 0px;
}
#indexNum02 .index-head .right .a1{
	width:3em;
	height:3em;
	display:inline-block;
	margin-left:1em;
	outline:0px solid #FF0000;
	
}
#indexNum02 .index-head .right .user{
	background:url(common/images/icon_03.png) no-repeat;
	background-size:100% 100%;
}
#indexNum02 .index-head .right .cart{
	background:url(common/images/icon_02.png) no-repeat;
	background-size:100% 100%;
}

#ddtj{
	outline:0px solid #FF0000;background:#eee;
}
#ddtj .dd_center{
	width:94%;
	margin:0 auto;
}
#ddtj .t01{
	position:relative;
	margin:1em 0px;
	background:#FFF;
	padding:2em 0px;
}
#ddtj .t01 .dd_center .ltm{
	position:relative;
	padding:0.4em 0px;
}
#ddtj .t01 .dd_center .ltm .eof{
	position:absolute;
	right:1.4em;
	top:0em;
	color:#ff6600;
	outline:0px solid #FF0000;
}
#ddtj .t01 .dd_center .ltm .yil{
	padding:0.4em 0px;
}
#ddtj .t01 .dd_center .butinfo01{
	font-size:1.4em;
	color:#666;
}
#ddtj .t01 .dd_center .butinfo02{
	font-size:1.4em;
	color:#666;
}
#ddtj .t01 .dd_center .butinfo03{
	font-size:1.4em;
	color:#333;
}
#ddtj .t01 .dd_center .butinfo04{
	font-size:1.4em;
	color:#ff6600;
}
#ddtj .t01 .dd_center  .foor{
	width:3em;
	height:3em;
	position:absolute;
	right:1em;
	top:1.5em;
	z-index:1;
	color:#999;
	outline:0px solid #FF0000;
	background:url(common/images/icon_s_06.png) no-repeat;
	background-size:100% 100%;
}
#ddtj .io_02{
	width:100%;
	background:#ff6600;
	color:#FFF;
	border-radius:0.2em;
	font-size:2em;
	padding:0.4em 0px;
	border:0px;
}
</style>
</head>
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#addAdd").click(function() {
			$(location).attr("href", "/MyFirstItem/addressServlet?method=province");
		})
	})
</script>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="index.htm" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">订单提交</span></center>

	</div>
</div>
<div id="ddtj">
		<br />
		<ul>
			<li id="addAdd" class="t01">
				<div class="dd_center">
					<span class="butinfo01">添加地址</span>
					<div class="foor"></div>
				</div>
			</li>
			<li class="t01">
				<div class="dd_center">
					<div class="ltm">
						<span class="butinfo01">支付方式</span>
						<span class="butinfo02">&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span class="butinfo03">在线支付</span>
					</div>
					<div class="ltm">
						<span class="butinfo01">配送方式</span>
						<span class="butinfo02">&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span class="butinfo03">快速配送(免运费)</span>
					</div>
					<div class="ltm">
						<span class="butinfo01">送货时间</span>
						<span class="butinfo02">&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span class="butinfo03">不限送货时间</span>
						<div class="eof">修改</div>
					</div>
					<div class="ltm">
						<span class="butinfo01">发票信息</span>
						<span class="butinfo02">&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span class="butinfo03">电子发票</span>
						<div class="eof">修改</div>
					</div>
				</div>
				
			</li>
			<li class="t01">
				<div class="dd_center">
					<span class="butinfo01">使用优惠券</span>
					<div class="foor"></div>
				</div>
			</li>
			<li class="t01">
				<div class="dd_center">
					<span class="butinfo01">商品清单：共3件商品</span>
					<div class="foor"></div>
				</div>
			</li>
			<li class="t01">
				<div class="dd_center">
					<div class="ltm">
						<table width="100%">
							<tr>
								<td class="yil"><span class="butinfo01">商品金额合计</span></td>
								<td align="right"><span class="butinfo03">863.9元</span></td>
							</tr>
							<tr>
								<td class="yil"><span class="butinfo01">运费费用</span></td>
								<td align="right"><span class="butinfo03">0元</span></td>
							</tr>
							<tr>
								<td class="yil"><span class="butinfo01">订单金额</span></td>
								<td align="right"><span class="butinfo04">863.9元</span></td>
							</tr>
						</table>
					</div>
					<div>
						<input type="submit" class="io_02" value="去结算" />
					</div>
					
				</div>
				
			</li>
			
		</ul>	
</div>
<br /><br /><br /><br />
</body>
</html>


