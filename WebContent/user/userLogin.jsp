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
* {
	outline-style:none;
}
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

#user_info{outline:1px solid #FF0000;background:#ebeced;}
#login_info .info{
	font-size:2em;
	text-align:center;
	color:#000;
	padding:1em 0px;
}
#login_info .win{
	border:1px solid #d4d4d3;
	border-radius:1em;
	background:#faffbd;
	width:80%;
	margin:0 auto;
}
#login_info .io{
	border:0px solid #d4d4d3;
	background:#faffbd;
	height:2em;
	font-size:2em;
	font-weight:bold;
	width:100%;
	border-radius:1em;
}
#login_info .but{
	border:1px solid #219718;
	background:#3ec234;
	padding:0.4em 0px;
	font-size:2em;
	font-weight:bold;
	width:80%;
	margin:0 auto;
	border-radius:1em;
	color:#FFF;
}
#login_info .but_reg{
	border:1px solid #ccc;
	background:#FFF;
	padding:0.4em 0px;
	font-size:2em;
	font-weight:bold;
	width:80%;
	margin:0 auto;
	border-radius:1em;
	color:#7c7c7c;
}
</style>
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".but").click(function() {
			var user=$(":text").val();
			var pwd=$(":password").val();
			var url="/MyFirstItem/userLoginServlet";
			var dataa={"method":"login","phone":user,"password":pwd};
			$.getJSON(url, dataa, function(data) {
				var error=data.error;
				if (error=="1") {
					alert("用户名不存在或密码错误");
				}
				if (error=="0") {
					$(location).attr("href","/MyFirstItem/user/index.jsp");
				}
			})
			//$(location).attr("href", "userLoginServlet?method=login&phone="+user+"&password="+pwd);
		})
	})
</script>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="index.htm" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">小米-账号登陆</span></center>
		<div class="right">
			<a href="" class="a1 cart" title="购物车"></a>
		</div>
	</div>
</div>
<div id="login_info">
	<div class="info">一个账号，玩转小米服务</div>
		<div class="win">
			<table width="100%" border=1>
				<tr>
					<td style="border:1px solid #d4d4d3;border-style:none none solid none;"><input type="text" class="io" /></td>
				</tr>
				<tr>
					<td><input type="password" class="io" /></td>
				</tr>
			</table>
		</div>
	<center>
	<br/>
	<input class="but" type="submit" name="send" value="立即登陆"/>
	</center>
	<br /><br /><br />
	<center>
	<input class="but_reg" type="button" value="注册小米账号" />
	</center>
</div>
</body>
</html>


