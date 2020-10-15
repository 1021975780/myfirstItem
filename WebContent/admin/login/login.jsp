<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录</title>
<link href="images/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
//ajax不合适
	$(
			function() {

				$("a:eq(0)").click(function() {
					var url = this.href;
					var data = {
						"email" : $("#em").val(),
						"pwd" : $("#pwd").val(),
						"code" : $("#cod").val()
					};
					//alert(data);
					$.getJSON(url, data, function(data) {
						var err = data.error;
						$("#error").remove();
						if (err == null) {
							var success = data.success;
							$(location).attr("href", success);
							return false;
						}
						$("#pwd").after("<div id='error'>" + err + "</div>");
					})
					return false;
				})
				$("img").click(
						function() {
							//alert(1);
							$(this).attr(
									"src",
									"/MyFirstItem/validateColorServlet?ran="
											+ Math.random());
						})
				$(document).keyup(
						function(event) {
							if (event.keyCode == 13) {
								//代码重用了
								var url = "/MyFirstItem/loginServlet?method=adminLogin";
								var data = {
									"email" : $("#em").val(),
									"pwd" : $("#pwd").val(),
									"code" : $("#cod").val()
								};
								//alert(data);
								$.getJSON(url, data, function(data) {
									var err = data.error;
									$("#error").remove();
									if (err == null) {
										var success = data.success;
										$(location).attr("href", success);
										return;
									}
									$("#pwd")
											.after(
													"<div id='error'>" + err
															+ "</div>");
								})
								//$(location).attr("href","/MyFirstItem/loginServlet?method=adminLogin");
							}
						})
			})
</script>
</head>
<body>
	<div id="login">
		<div id="top">
			<div id="top_left">
				<img src="images/login_03.gif" />
			</div>
			<div id="top_center"></div>
		</div>

		<div id="center">
			<div id="center_left"></div>
			<div id="center_middle">
				<div id="user">
					Email： <input type="text" autocomplete="off" name="email" id="em" />
				</div>
				<div id="password">
					密 码： <input type="password" name="pwd" id="pwd" />
				</div>
				<div id="code">
					验证码： <input type="text" autocomplete="off" name="code" id="cod"
						onFocus="showCode();" onclick="showCode()" />
				</div>
				<div id="btn">
					<img src="../../validateColorServlet" />
					<!-- 						<a href="javascript:login();">登录</a> -->
					<a href="../../loginServlet?method=adminLogin">登录</a> <a
						href="reg.html">注册</a>
				</div>

			</div>
			<div id="center_right"></div>
		</div>
		<div id="down">
			<div id="down_left">
				<div id="inf">
					<span class="inf_text">版本信息</span> <span class="copyright">中软创新综合管理系统
						2015 v1.0</span>
				</div>
			</div>
			<div id="down_center">
				<a href="forget.html">忘记密码！</a>
			</div>
		</div>
	</div>
</body>
</html>
