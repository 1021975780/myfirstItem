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
<link rel="stylesheet" type="text/css" href="/MyFirstItem/user/common/css/common.css">
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

#goods_info{outline:1px solid #FF0000;}
#goods_info .centerNum20150619{}

#goods_info .centerNum20150619 .c_img{
	margin:0em auto;
	outline:0px solid #FF0000;
}
#goods_info .centerNum20150619 .c_img img{
	width:100%;
}

#goods_info .centerNum20150619 .s_name{
	font-size:2em;
	padding:0.1em 0px;
	color:#333;
	outline:0px solid #FF0000;
}
#goods_info .centerNum20150619 .s_money{
	font-size:2em;
	padding:0.1em 0px;
	color:#FF6600;
	outline:0px solid #FF0000;
}

#goods_info .centerNum20150619 .buy{
	background:#FFF;
	padding:1em 0em 1em 0em;
}
#goods_info .centerNum20150619 .buy .buy_ok{
	width:100%;
	text-align:center;
	font-size:1.4em;
	padding:1em 0em 1em 0em;
	background:#FF6600;
	color:#FFF;
}
#goods_info .centerNum20150619  .s_button{
	padding:1em 0px;
}
#goods_info .centerNum20150619  .s_button a{
	font-size:1.4em;
	padding:0.2em 0px;
	color:#666;
}

#goods_info .centerNum20150619 .s_center div {
	padding:2em;
}

#goods_info .centerNum20150619 .s_center div h1 {
	font-size:1.4em;
}

#goods_info .centerNum20150619 .s_center img{
	width:100%;
}
.copyright{
	font-size:1.2em;
	padding:2em 0px;
	text-align:center;
	border:1px solid #CCC;border-style:solid none none none;
}
</style>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="/MyFirstItem/user/index.jsp" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">${good.goodName}</span></center>
		<div class="right">
			<a href="/MyFirstItem/user/shoppingcar.jsp" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="goods_info">
	<div class="centerNum20150619"> 
		<div class="c_img"><img src="${good.image }" /></div>
		<div style="border:1px solid #CCC;border-style:none none solid none;"></div>
		<div class="s_name">${good.goodName} </div> 
		<div class="s_money">${good.price }元起</div>
		<div class="buy">
			<table width="100%">
				<tr>
					<td><center><a class="buy_ok" href="">直接购买</a></center></td>
					<td><center><a class="buy_ok" href="/MyFirstItem/manageServlet?method=addToCar&id=${good.goodId }">加入购物车</a></center></td>
				</tr>
			</table>
		</div>
		<div style="border:1px solid #CCC;border-style:none none solid none;"></div>
		<div class="s_button">
			<table width="100%">
				<tr>
					<td><center><a class="aa1">概述</a></center></td>
					<td><center><a class="aa1">参数</a></center></td>
				</tr>
			</table>
		</div>
		<div class="s_center">
			<div>
				<h1>顶尖科技于一身</h1><br/>
				${good.miaoshu} 
<!-- 				小米Note 不仅是一部手机，更凝聚了全新的顶尖科技。除了强大的处理器，还有以往专业相机才会用到的光学防抖技术、高档音乐播放器的 HiFi 音乐模块、使对比度更高的负液晶技术，这些都在小米Note 上得以实现。功能越来越强大，机身越来越薄，在轻薄同时更容纳了3000mAh（顶配版3090mAh）的大容量电池。更快的无线网络、双卡双待，还有数不胜数的新科技。这一切用语言描述已远远不够，拿起小米Note 那一刻，你就能真正感受到它的强大。 -->
			</div>
<!-- 			<img src="小米参考/小米商城-物品详细_files/0_187068f.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/0_d25727e.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/1_8f48687.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/1_1249f67.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/2_4cd5555.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/2_32c68e7.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/4_a6b9b13.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/5_cd68266.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/6_1bb4929.jpg" /> -->
<!-- 			<img src="小米参考/小米商城-物品详细_files/10_1b40258.jpg" /> -->
		</div>
	</div>
	
	<div class="copyright">@2015 m.mi.com</div>
</div>


</body>
</html>


