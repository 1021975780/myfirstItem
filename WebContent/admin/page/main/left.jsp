<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/MyFirstItem/js/jquery-1.7.2.js"></script>
</head>
<body>
	<div id="left">
		<div id="left_menu"></div>
		<div id="left_tree">
			<div id="tree_text">
				<ul id="globalNav">
					<li>
						<a>商品管理</a>
						<ul>
						<li>
								<a class="a" href="/MyFirstItem/admin/page/page/admin/list.jsp" target="right">管理员信息修改</a>
							</li>
							<li>
								<a class="a" href="/MyFirstItem/admin/page/page/goods/table.jsp" target="right">商品管理</a>
							</li>
							<li>
							<a class="a" href="/MyFirstItem/admin/page/page/gclass/list.jsp" target="right">商品类别管理</a>
							</li>
						</ul>
					</li>
					
				</ul>
			</div>
		</div>
		<div id="tree_down"/>
     </div>
</body>
</html>

<script type="text/javascript">
$(function(){
	initHeight();
	$("#globalNav").children().each(function(index){
		var item = $(this);
		var tag_a = item.children().eq(0);
		tag_a.attr("href", "#this");
		var tag_ul = item.children().eq(1);
		if(index == 0) {
			tag_ul.show();
		}
		tag_a.click(function(){
			tag_ul.toggle();
		});
	});
	
	$(".a").click(function(){
		$(".a").css({"color":"black", "font-weight":"normal"});
		$(this).css({"color":"red", "font-weight":"bold"});
	});
})
window.onresize=function() {
	initHeight();
}
function initHeight(){
	$("#left_tree").css("height", document.documentElement.clientHeight-80);
	$("#tree_text").css("height", document.documentElement.clientHeight-80);
}
</script>
