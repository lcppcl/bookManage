<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link href="css/user_info.css" rel="stylesheet">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/table_2.css" rel="stylesheet" />
		<script src="js/jquery-2.1.4.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" href="css/table.css" />
		<script src="js/tancuang.js"></script>
		<title></title>
	</head>

	<body>
		<div class="info">
			<form action="" method="post">
				<div class="tables">
					<div class="row">
						<div class="batch-btn"><%--<span>批 量 操 作 ：</span>
							<button class="btn btn-danger" name="actiontype" value="delete" type="submit">删 除</button>--%>

						</div>
						<div class="col-xs-12">
							<div class="table-header">
								图 书 馆 读 者 管 理
							</div>
							<div class="table-responsive">
								<table id="sample-table-2" class="table table-striped table-bordered table-hover">
									<caption>
										<label style="color: #ac2925">${msg}</label>
									</caption>
									<thead>
										<tr>
											<th class="center">
												<label>
													<input type="checkbox" class="ace" />
													<span class="lbl"></span>
												</label>
											</th>
											<th>序 号&nbsp;</th>
											<th>读者编号 </th>
											<th>读者用户名 </th>
											<th>性别</th>
											<th>专业 </th>
											<th>列表操作 </th>
										</tr>
									</thead>
									<tbody>

									<s:iterator id="lu" value="#request.listUser" status="su">
										<tr>
											<td class="center">
												<label>
													<input type="checkbox" class="ace" name="ids" value="" />
													<span class="lbl"></span>
												</label>
											</td>
											<td><s:property value="#su"></s:property></td>
											<td><s:property value="#lu.readerId"></s:property></td>
											<td><s:property value="#lu.name"></s:property></td>
											<td><s:property value="#lu.sex==0?'女':'男'"></s:property></td>
											<td><s:property value="#lu.spec"></s:property></td>
											<td>
												<a href="delUser.action?readerId=<s:property value="#lu.readerId"/>"/>
												<input type="button" class="btn btn-danger" value="删除">
												</a>
											</td>
										</tr>
									</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='js/jquery-2.1.4.min.js'>" + "<" + "/script>");
		</script>
		<script type="text/javascript">
			if ("ontouchend" in document) document.write("<script src='js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
		</script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/jquery.dataTables.bootstrap.js"></script>
		<script type="text/javascript">
			$(function(){
	        	var len = $('tr').length;
	        	for(var i = 1;i<len;i++){
	            	$('tr:eq('+i+') td:eq(1)').text(i);
	        	}  
			});
			jQuery(function($) {
				var oTable1 = $('#sample-table-2').dataTable({
					"aoColumns": [{
							"bSortable": false
						},
						null, null, null, null, null, {
							"bSortable": false
						}
					]
				});
				$('table th input:checkbox').on('click', function() {
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
						.each(function() {
							this.checked = that.checked;
							$(this).closest('tr').toggleClass('selected');
						});
				});
				$('[data-rel="tooltip"]').tooltip({
					placement: tooltip_placement
				});

				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
					var off2 = $source.offset();
					var w2 = $source.width();
					if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
					return 'left';
				}
			})
		</script>
	</body>

</html>