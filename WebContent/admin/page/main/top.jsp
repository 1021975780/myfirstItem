<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TOP</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function showTime() {
		var curTime = new Date();
	    $("#clock").html(curTime.toLocaleString());
	    setTimeout("showTime()", 1000); 
	}
	$(function() {
		showTime();
	})
</script>
</head>

<body>
<div id="top">
	      <div id="logo"></div>
		  <div id="user">【欢迎您】：${sessionScope.userName}【IP】：${sessionScope.ip }admin【今天】：<span id="clock"></span></div>	
<%-- 		  <div id="user">【欢迎您】：${sessionScope.userName}【${sessionScope.ip }】：admin【今天】：${sessionScope.date }</div>	   --%>
	 </div>
</body>
</html>
