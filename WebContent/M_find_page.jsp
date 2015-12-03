<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="css/user_info.css" rel="stylesheet">
		<script src="js/jquery-2.1.4.min.js"></script>
		<title></title>
		<style>
			.book-img{
				height: 220px;
			}
		</style>
	</head>

	<body>
		<div class="info">
			<form action="" method="post">
				<table class="book-info" cellpadding="0" cellspacing="0">
					<tr>
						<th width="80" height="55">书籍名称：</th>
						<td width="220"><s:property value="#request.book.bookName"></s:property> </td>
						<th width="80">作 者：</th>
						<td width="220"><s:property value="#request.book.author"></s:property></td>
					</tr>
					<tr>
						<th width="80" height="55">ISBN &nbsp;码：</th>
						<td width="220"><s:property value="#request.book.isbn"></s:property></td>
						<th width="80">价格：</th>
						<td width="220"><s:property value="#request.book.price"></s:property></td>
					</tr>
					<tr>
						<th width="80" height="55">库存：</th>
						<td width="220"><s:property value="#request.book.sunm"></s:property></td>
						<th width="80">出版社：</th>
						<td width="220"><s:property value="#request.book.publish"></s:property></td>
					</tr>
					<tr>
						<th colspan="2" width="80" height="50">书籍简介：</th>
						<th colspan="2" width="80" height="50">书籍图片：</th>
					</tr>
					<tr>
						<td colspan="2"><span class="user-text"><s:property value="#request.book.summary"></s:property></span></td>
						<td colspan="2"><img class="book-img" src="<s:property value="#request.book.photo"></s:property>" /></td>
					</tr>
					
				</table>
			</form>
		</div>
	</body>

</html>