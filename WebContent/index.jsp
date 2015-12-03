<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700'
	rel='stylesheet' type='text/css'>
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
				<input type="text" class="text" name="readerid"> 
				<input type="password" name="password">
				<div class="submit">
					<input type="submit" value="LOGIN">
				</div>
			</form>
		</div>
	</div>
</body>
</html>