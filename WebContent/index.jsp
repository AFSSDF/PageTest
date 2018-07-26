<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>所有人员信息</h1>
	<table id="table" border="1px">

	</table>
	<p>
		当前页:<span id="pageCur"></span>
	</p>
	<p>
		总页数:<span id="pageTotal"></span>
	</p>
	<div class="btn btn-group">
		<button id="pre">上一页</button>
		<button id="next">下一页</button>
	</div>
	<script src="js/jquery-1.8.3.min.js"></script>
</body>
</html>
<script>
	function flsh(pageCur) {
		$.getJSON('UserServlet', 'pageCur=' + pageCur, function(data) {
			var $table = $("#table").empty();
			$("#pageCur").html(data.pageCur);
			pageCur=data.pageCur;
			$("#pageTotal").html(data.pageTotal);
			var list = data.list;
			$table.append('<tr><td>用户名</td><td>密码</td><td>性别</td></tr>');
			for (var i = 0; i < list.length; i++) {
				var $tr = $('<tr><td>' + list[i].userName + '</td><td>'
						+ list[i].password + '</td><td>' + list[i].sex
						+ '</td></tr>');
				$table.append($tr);
			}
		});
		$("#next").on('click', function() {
			flsh(pageCur + 1);
		});
		$("#pre").on('click', function() {
			flsh(pageCur - 1);
		});

	}
	$(function() {
		flsh(1);
	});
</script>