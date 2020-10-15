<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-control" content="no-cache" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0,minimal-ui" />   
<meta name="apple-mobile-web-app-capable" content="yes" />
<title>小米-为发烧而生</title>
<link rel="stylesheet" type="text/css" href="common/css/common.css">
<style>
 
#indexNum01 .index-head{
	outline:0px solid #FF0000;
	background:#F4F4F4;
}
#indexNum01 .index-head .left{
	outline:0px solid #FF0000;
	float:left;
}
#indexNum01 .index-head .left .home{
	outline:0px solid #FF0000;
}
#indexNum01 .index-head .left .home .mall{
	font-size:2em;
	color: #424242;
	display:inline-block;
	outline:0px solid #FF0000;
	margin-left:1em;
	margin:0.75em;
}
#indexNum01 .index-head .right{
	outline:0px solid #FF0000;
	float:right;
	padding:1.2em 1em 1.2em 0px;
}
#indexNum01 .index-head .right .a1{
	width:3em;
	height:3em;
	display:inline-block;
	margin-left:1em;
	outline:0px solid #FF0000;
	
}
#indexNum01 .index-head .right .user{
	background:url(common/images/icon_03.png) no-repeat;
	background-size:100% 100%;
}
#indexNum01 .index-head .right .cart{
	background:url(common/images/icon_02.png) no-repeat;
	background-size:100% 100%;
}

#centerNum01 .img_center{
	outline:0px solid #0033cc;
} 
#centerNum01 .img_center img{
	width:100%;
} 
#centerNum01 .s_submit{
	background:#FFF;
}
#centerNum01 .s_submit .s_center{
	width:23%;
	height:7em;
	border:1px solid #F5F5F5;
	border-style:none solid none none;
	float:left;
}

#centerNum01 .s_submit .c1{
	border:0px;
}
#centerNum01 .s_submit .s_center .s_background{
	height:5em;
	width:5em;
	margin:0 auto;
}
#centerNum01 .s_submit .s_center .s_span{
	line-height:1em;
	text-align:center;
	outline:0px solid #FF0000;
}
#centerNum01 .s_submit .s_center .b1{
	background:url(common/images/icon_s_01.png) no-repeat;
	background-size:100% 100%;
	
}
#centerNum01 .s_submit .s_center .b2{
	background:url(common/images/icon_s_02.png) no-repeat;
	background-size:100% 100%;
}
#centerNum01 .s_submit .s_center .b3{
	background:url(common/images/icon_s_03.png) no-repeat;
	background-size:100% 100%;
}
#centerNum01 .s_submit .s_center .b4{
	background:url(common/images/icon_s_04.png) no-repeat;
	background-size:100% 100%;
}
#centerNum01 .title{
	border:1px solid #f4f4f4;
	margin-top:0.1em;
}
#centerNum01 .t_01{
	padding:1em 0px 1em 1em;
	font-size:2em;
	background:#FFF;
	border-style:solid none solid none;
}
#centerNum01 .t_02{
	padding:1em 0px 1em 1em;
	font-size:2em;
	text-align:center;
	background:#FFF;
	border-style:solid none none none;
	color:#999;
}

#centerNum01 .t_04 img{
	width:100%;
}
#centerNum01 .chenp{
	background:#FFF;
}
#centerNum01 .list{
	width:49%;
	float:left;
}
#centerNum01 .list img{
	width:100%;
}
#centerNum01 .l_num02{
	border:1px solid #F4F4F4;
	border-style:solid none none solid;
	margin:0px 0px 0px 1px;
}

.pcUrl{
	padding:1em 0px 1em 0em;
	font-size:1.4em;
	text-align:center;
	background:#f4f4f4;
	border:1px solid #FF0000;
	border-style:none none solid none;
	color:#FF0000;
}
.download{
	margin:0em;
	padding:0em;
	border:1px solid #626262;
	background:#626262;
}
.download  img{
	width:100%;
}

</style>
</head>
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
// 		$(location).attr("href","/MyFirstItem/manageServlet?method=showHot");
		var url="/MyFirstItem/manageServlet";
		var dataa={"method":"showHot"};
		$.getJSON(url, dataa, function(data) {
			var len=data.length;
			for (var i = 0; i < len; i++) {
				var image= data[i].image;
				var goodId=data[i].goodId;
				$("#clearfix").append("<li class='list l_num02' imgid='"+goodId+"'><img src='"+image+"' /></li>");
				$("#clearfix2").append("<li class='list l_num02'imgid='"+goodId+"'><img src='"+image+"' /></li>");
			}
			$("#clearfix").children().click(function() {
				var goodId=$(this).attr("imgid");
				$(location).attr("href", "/MyFirstItem/manageServlet?method=forwardToInfo&id="+goodId);
			})
			$("#clearfix2").children().click(function() {
				var goodId=$(this).attr("imgid");
				$(location).attr("href", "/MyFirstItem/manageServlet?method=forwardToInfo&id="+goodId);
			})
		})
	})
</script>
<body>

<div id="indexNum01">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="" class="mall">小米商城</a>
			</div>
		</div>
		
		<div class="right">
			<a href="selfMessage.jsp" class="a1 user" title="个人中心"></a>
			<a href="/MyFirstItem/user/shoppingcar.jsp" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="centerNum01">
	<div class="img_nav">
		<ul>
			<li class="img_center">
				<img src="common/images/T1IAVjBmET1RXrhCrK.jpg" />
			</li>
		</ul>
	</div>
	<div class="s_submit">
		<ul class="clearfix">
			<li class="s_center" onclick="location.href='goods_list.htm';">
				<div class="s_background b1"></div>
				<div class="s_span">全部商品</div>
			</li>
			<li class="s_center">
				<div class="s_background b2"></div>
				<div class="s_span">搜索</div>
			</li>
			<li class="s_center">
				<div class="s_background b3"></div>
				<div class="s_span">小米社区</div>
			</li>
			<li class="s_center c1">
				<div class="s_background b4"></div>
				<div class="s_span">客户端</div>
			</li>
		
		</ul>
	</div>
	
	<div class="title t_01">现货购买</div>
	<div class="chenp">
		<ul class="clearfix" id="clearfix" >
			<li class="list l_num01"><img src="common/images/T1bDE_BKJT1RXrhCrK.jpg" /></li>
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/T1U.jpg" /></li> -->
		</ul>
	</div>
	<div class="title t_01">热卖商品</div>
	<div class="chenp">
		<ul class="clearfix" id="clearfix2">
			<li class="list l_num02"><img src="common/images/T1DLZvBmVT1RXrhCrK.jpg" /></li>
<!-- 			<li class="list l_num02"><img src="common/images/T1Ue_TBCbv1RXrhCrK.jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/tt01 (1).jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/tt01 (2).jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/tt01 (3).jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/tt01 (4).jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/tt01 (5).jpg" /></li> -->
<!-- 			<li class="list l_num02"><img src="common/images/tt01 (6).jpg" /></li> -->
		</ul>
	</div>
	<div class="title t_02" onclick="location.href='goods_list.htm';">查看更多配件&nbsp;&nbsp;&nbsp;&gt;</div>
	<div class="pcUrl">切换到电脑版</div>
	<div class="download"><img src="common/images/icon_s_05.png" /></div>
</div>
</body>
</html>


