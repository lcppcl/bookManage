<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="css/S_index.css" />
		<script src="js/jquery-2.1.4.min.js"></script>
		<title></title>
		<script>
			 window.onload = function height() {
				var h = window.screen.height + 300 + "px";
				var w = window.screen.width - 150 + "px";
				var rh = window.screen.height + 200 + "px";
				var rw = window.screen.width - 150 + "px";
				document.getElementById('left').style.height = h;
				document.getElementById('top').style.width = w;
				document.getElementById('right').style.height = rh;
				document.getElementById('right').style.width = rw;
			}
			$(function() {
				$(".menu-list a").click(function() {
					$(".menu-list li").removeClass("active");
					$(".hidden").css("display", "none");
					$(this).children("li").addClass("active");
					$(this).prev("div").css("display", "block");
				});
			})
		</script>
	</head>

	<body>
		<div id="top">
			<span class="text-top">图书馆书籍管理系统</span>
			<span class="text-bottom">— 学 生 端</span>
		</div>
		<div id="left">
			<div class="id-box">
				<div>
					<img class="head-img" src="img/profile-pic.jpg" />
				</div>
			</div>.
			<div class="left-name">Student</div>
			<div class="menu">
				<ul class="menu-list">
					<div class="hidden"></div>
					<a target="right" href="bookList">
						<li>书 籍 查 询</li>
					</a>
					<div class="hidden"></div>
					<a target="right" href="lendList">
						<li>借 阅 管 理</li>
					</a>
				</ul>
			</div>
		</div>
		<iframe id="right" src="M_find.jsp" name="right" frameborder="0" scrolling="no"></iframe>
	</body>

</html>