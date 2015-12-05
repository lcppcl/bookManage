<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/find.css" />
	<script src="js/jquery-2.1.4.min.js"></script>
	<!--<script src="bootstrap/js/bootstrap.min.js"></script>-->
	<title></title>
	<style>

	</style>
	<script>
		$(function(){
			$(".find-btn").click(function(){
				$(".shows,.shows-head").slideUp(300,function(){
					$(".result").slideDown(100);
				});

			})
		})
		$(document).ready(function() {
			var $table = $('.list-table');
			var currentPage = 0;
			var pageSize = 5;
			$table.bind('repaginate', function() {
				$table.find('tbody tr').hide().slice(currentPage * pageSize, (currentPage + 1) * pageSize).show();
			});
			var numRows = $table.find('tbody tr').length;
			var numPages = Math.ceil(numRows / pageSize);
			var $pager = $('.pagination');
			for (var page = 0; page < numPages; page++) {
				$('<li><a href="#">' + (page + 1) + '</a></li>')
						.bind("click", {
							"newPage": page
						}, function(event) {
							currentPage = event.data["newPage"];
							$table.trigger("repaginate");
						})
						.appendTo($pager);
				$pager.append("  ");
			}
			$table.trigger("repaginate");
		});

		var m = 0;
		function slide(){
			document.getElementById('box').scrollTop=m;
			m = m+1;
			if(m>80){
				m=0;
			}
		}
		setInterval("slide()",50);

		//图书查询
		$(function(){
			$("#filterName").keyup(function(){
				$("table tbody tr")
						.hide()
						.filter(":contains('"+( $(this).val() )+"')")
						.show();
			})
		})
	</script>
</head>

<body>
<div class="search">
	<div class="form-group">
		<input type="text" class="find-text" id="filterName" placeholder="请输入书名进行查询......">
	</div>
	<span class="shows-head">热门搜索</span>
	<div class="shows" id="box">
		<table class="shows-list" cellpadding="0" cellspacing="0">
			<thead>
			<tr>
				<th>书籍名称</th>
				<th>作者姓名</th>
				<th>书籍类型</th>
				<th>书籍编号</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<s:iterator id="lb" value="#request.listBook">
				<tr>
					<td><s:property value="#lb.bookName"></s:property></td>
					<td><s:property value="#lb.author"></s:property></td>
					<td><s:property value="#lb.publish"></s:property></td>
					<td><s:property value="#lb.isbn"></s:property></td>
					<td>
						<a href="book.action?isbn=<s:property value="#lb.isbn"/>">
							<button class="btn btn-warning">查看详情</button>
						</a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>