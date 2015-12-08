<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700'
	rel='stylesheet' type='text/css'>
	
<script type="text/javascript">
	/* $(function(){
		$(":input[name='readerid']").change(function(){
			var val = $(this).val();
			val = $.trim(val);//去除填写的空格
			if(val != ''){// 如果数据不为空，就发送ajax请求数据
				var url = "${pageContext.request.contextPath}/login"//请求action的地址
				var args = {
						"readerid" : val,
						"time":new Date() //解决缓存问题
				};
				$.post(url,args,function(data){
					$("#message").html(data);
				});
			}
		});
	}) */
</script>	


</head>
<body>
	<!-----start-main---->
	<div class="main">
		<div class="login-form">
			<h1>Library Login</h1>
			<div class="head">
				<img src="img/user.png" alt="" />
			</div>
			<form action="login" method="post">
				<input type="text" class="text" name="readerid"> <div id="message"></div><!-- 预留空格写入后台返回的数据 -->
				<input type="password" name="password"><div id="message"></div><!-- 预留空格写入后台返回的数据 -->
				<div class="submit">
					<input type="submit" value="LOGIN">
				</div>
			</form>
		</div>
	</div>
</body>
</html>