<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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

#user_dd{
	/*outline:1px solid #FF0000;background:#eee;*/
	padding-bottom:1em;
}
#user_dd .dd_center{
	width:90%;
	margin:0 auto;
}
#user_dd .dd_center .s1{
	font-size:1.4em;
	padding:0.4em 0px;
	color:#666;
}
#user_dd .dd_center .io_01{
	width:100%;
	border-radius:0.2em;
	border:1px solid #d3d4d6;
	font-size:1.4em;
	padding:0.4em 0px;
}
#user_dd .dd_center .select01{
	width:49%;
	border-radius:0.2em;
	border:1px solid #d3d4d6;
	font-size:1.6em;
	float:left;
}
#user_dd .dd_center .select02{
	width:100%;
	border-radius:0.2em;
	border:1px solid #d3d4d6;
	font-size:1.6em;
}
#user_dd .dd_center .text1{
	font-size:1.4em;
	width:100%;
	height:6em;
}

#user_dd .dd_center .io_02{
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
	$("select").change(function() {
		var name=$(this).val();
		var id=$(this).attr("id");
		if (name!="") {
			if (id=="s1") {
				$("#s2 option").remove();
				$("#s3 option").remove();
				var url="/MyFirstItem/addressServlet?method=city";
				var data={"provinceId":name};
				$.getJSON(url, data, function(data) {
					for(var i=0;i<data.length;i++){
						$("#s2").append("<option value='"+data[i].cityId+"'>"+data[i].cityName+"</option>")
					}
				})
			}
			if (id=="s2") {
				var url="/MyFirstItem/addressServlet?method=district";
				var data={"districtId":name};
				$.getJSON(url, data, function(data) {
					for(var i=0;i<data.length;i++){
						$("#s3").append("<option value='"+data[i].districtId+"'>"+data[i].districtName+"</option>")
					}
				})
			}
		}
	})
})
</script>
<body>

<div id="indexNum02">
	<div class="index-head clearfix">
		<div class="left">
			<div class="home">
				<a href="/MyFirstItem/user/index.jsp" class="mall"></a>
			</div>
		</div>
		<center><span class="s_title">订单确认</span></center>

	</div>
</div>
<div id="user_dd">
	<div class="dd_center">
		<div class="s1">收货人姓名</div>
		<input type="text" class="io_01" placeholder="请填写真实姓名" />
		<div class="s1">收货地址</div>
		<div class="clearfix" style="padding:px 0px 0.4em 0px;">
			<select id="s1" name="我是name" class="select01">
				<option  value ="">请选择省</option>
				<c:forEach items="${requestScope.list }" var="province">
				<option value="${province.provinceId }">${province.provinceName }</option>
				</c:forEach>
			</select>
			<select id="s2" name="我是name" class="select01" style="float:right;">
				<option value ="">请选择市</option>
			</select>
		</div>
		<div style="height:1em;"></div>
		<select id="s3" name="我是name" class="select02">
			<option  value ="">请选择区</option>
		</select>
		<div style="height:1em;"></div>
		<textarea name="name" class="text1" placeholder="路名或街道地址，门牌号，不少于10个字"></textarea>
		
		<div class="s1">邮政编码</div>
		<input type="text" class="io_01" placeholder="邮政编码，为6位数字" />
		<div class="s1">手机号码</div>
		<input type="text" class="io_01" placeholder="联系人电话，11位数字" />
		<div style="height:1em;"></div>
		<input type="submit" class="io_02" value="确认完成" />
	</div>
</div>
<br /><br /><br /><br />
</body>
</html>


