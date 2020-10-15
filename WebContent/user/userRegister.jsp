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

#user_info{outline:1px solid #FF0000;background:#ebeced;}
#login_info .info{
	font-size:2em;
	text-align:center;
	color:#000;
	padding:1em 0px;
}
#login_info .win{
	width:80%;
	margin:0 auto;
}
#login_info .win .cher{
	width:30%;
	height:4em;
	float:right;
	outline:0px solid #FF0000;
	margin-left:2em;
}
#login_info .win .cher img{
	width:100%;
	height:100%;
}
#login_info .io{
	border:1px solid #b3b3b3;
	background:#FFF;
	height:2em;
	font-size:2em;
	font-weight:bold;
	width:100%;
	border-radius:0.3em;
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
#login_info .sm{
	width:80%;
	margin:0 auto;
}
#login_info .sm .s1{
	font-size:1.4em;
	color:#9d9d9d;
}
#login_info .sm .s2{
	font-size:1.4em;
	color:#333;
}
</style>
</head>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="index.htm" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">小米-账号注册</span></center>

	</div>
</div>
<div id="login_info">
	<br /><br /><br />	
	<div class="win clearfix">
		<input type="text" class="io" placeholder="请输入手机号码" />
		<br/><br/>		
		<input type="password" class="io" placeholder="请输入密码" />
		<br/><br/>
		<input type="password" class="io" placeholder="请输入密码确认" />
		<br/><br/>
		<input type="text" class="io" placeholder="图片验证码" style="width:60%;float:left;" />
		<div class="cher">
			<img src="common/images/icon_s_11.png" />
		</div>
	</div>
	<br /><br />	
	<center>
	<input class="but" type="submit" name="send" value="立即注册" />
	</center>
	<br /><br /><br />
	<div class="sm">
		<span class="s1">点击"立即注册"，即表示您同意并愿意遵守小米</span>
		<span class="s2">用户协议</span>
		<span class="s1">和</span>
		<span class="s2">政策隐私</span>
	</div>
	<br /><br />
</div>
</body>
</html>


