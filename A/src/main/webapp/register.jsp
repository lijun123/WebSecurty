<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Web安全_注册</title>
<link rel="stylesheet" href="js/Bootstrap/css/bootstrap.min.css"
	type="text/css"></link>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
	
	$("a").hide();
	
		$("#submit").click(function() {
			var username = $("#username").val();
			var password = $("#password").val();

			if (username && password) {
				$.ajax({
					cache : true,
					type : "POST",
					url : '${pageContext.request.contextPath}/register',
					data : $('#userInfoForm').serialize(),
					async : false,
					success : function(data) {
						$("#username").val("");
						$("#password").val("");
						$("#returnMsg").html(data);
						$("a").show();
					}
				});
			} else {
				alert("注册信息不完整!");
			}
		});
	});
</script>
</head>
<body>
	<div
		style="width: 61.8%;height: 100%;background-color: azure;margin-left: auto;margin-right: auto;">
		<div style="padding:30% 40%;">
			<form id="userInfoForm" method="post">
				<table>
					<tr>
						<td><input type="text" class="form-control" id="username"
							name="username" placeholder="请输入用户名"></td>
					</tr>
					<tr>
						<td><input type="password" class="form-control" id="password"
							name="password" placeholder="请输入密码"></td>
					</tr>
					<tr>
						<td><input class="btn btn-primary btn-sm btn-block"
							type="button" id="submit" value="提交" />
						</td>
					</tr>
					<tr>
						<td><p id="returnMsg" style="text-align: center"></p></td>
					</tr>
					<tr><td style="text-align: right;"><a href="${pageContext.request.contextPath}/login.jsp">点我登录...</a></td></tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
