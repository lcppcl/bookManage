<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
			<link href="css/user_info.css" rel="stylesheet">
		<script src="js/jquery-2.1.4.min.js"></script>
		<!--<script src="bootstrap/js/bootstrap.min.js"></script>-->
		<title></title>
	</head>

	<body>
		<div class="info">
			<form action="" method="post">
				<table class="book-info" cellpadding="0" cellspacing="0">
					<tr>
						<th width="80" height="55">书籍名称：</th>
						<td width="220"><input type="text" class="find-text"></td>
						<th width="80">作 者：</th>
						<td width="220"><input type="text" class="find-text"></td>
					</tr>
					<tr>
						<th width="80" height="55">ISBN &nbsp;码：</th>
						<td width="220"><input type="text" class="find-text"></td>
						<th width="80">出版日期：</th>
						<td width="220"><input type="text" class="find-text"></td>
					</tr>
					<tr>
						<th width="80" height="55">出版社名：</th>
						<td width="220"><input type="text" class="find-text"></td>
						<th width="80">书籍编号：</th>
						<td width="220"><input type="text" class="find-text"></td>
					</tr>
					<tr>
						<th width="80" height="50">书籍图片：</th>
						<td colspan="3"><input type="file"></td>
					</tr>
					<tr>
						<th colspan="2" width="80" height="50">书籍简介：</th>
					</tr>
					<tr>
						<td colspan="4"><textarea class="find-textarea"></textarea></td>
					</tr>
				</table>
				<span class="text-warn">未填写信息将保持原样</span>
				<button class="btn btn-info add-btn">修 改</button>
			</form>
		</div>
	</body>

</html>