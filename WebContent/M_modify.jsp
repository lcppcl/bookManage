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
		<div class="info">z
			<form action="updateBook" method="post" enctype="multipart/form-data">
				<table class="book-info" cellpadding="0" cellspacing="0" >
					<caption>
						<label style="color: #ac2925">${msg}</label>
					</caption>
					<tr>
						<th width="80" height="55">书籍名称：</th>
						<td width="220"><input type="text" class="find-text" name="bookName" value=<s:property value="#request.book2.bookName"/>></td>
						<th width="80">作 者：</th>
						<td width="220"><input type="text" class="find-text" name="author" value=<s:property value="#request.book2.author"/>></td>
					</tr>
					<tr>
						<th width="80" height="55">ISBN &nbsp;码：</th>
						<td width="220"><input type="text" class="find-text" name="isbn" value=<s:property value="#request.book2.isbn"/>></td>
						<th width="80">出版社：</th>
						<td width="220"><input type="text" class="find-text" name="publish" value=<s:property value="#request.book2.publish"/>></td>
					</tr>
					<tr>
						<th width="80" height="55">价格：</th>
						<td width="220"><input type="text" class="find-text" name="price" value=<s:property value="#request.book2.price"/>></td>
					</tr>
					<tr>
						<th width="80" height="50">书籍图片：</th>
						<td colspan="3"><img src="<s:property value="#request.book2.photo"/>" height="150px" width="250px"><input type="file" name="uploadFile" onchange="fileChange(this)"/></</td>
					</tr>
					<tr>
						<th colspan="2" width="80" height="50">书籍简介：</th>
					</tr>
					<tr>
						<td colspan="4"><textarea class="find-textarea" name="summary"><s:property value="#request.book2.summary"/> </textarea></td>
					</tr>
				</table>
				<span class="text-warn">未填写信息将保持原样</span>
				<button class="btn btn-info add-btn">修 改</button>
			</form>
		</div>
	</body>

</html>