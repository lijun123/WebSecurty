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
<title>Web安全_登录</title>
<link rel="stylesheet" href="js/Bootstrap/css/bootstrap.min.css"
	type="text/css"></link>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#username").focus(); 
		$("#btnOK").click(function() {
			var username = $("#username").val();
			var password = $("#password").val();

			if (username && password) {
				$.ajax({
					cache : true,
					type : "POST",
					url : '${pageContext.request.contextPath}/LoginAction',
					data : $('#loginForm').serialize(),
					async : false,
					success : function(data) {
						initContent();
					}
				});
			} else {
				alert("用户名或者密码不能为空!");
				return;
			}
		});
	});
	function initContent() {
		$.ajax({
			cache : true,
			type : "POST",
			url : '${pageContext.request.contextPath}/ContentAction',
			async : false
		});
	}
</script>
</head>
<body>
	<div
		style="width: 61.8%;height: 100%;background-color: azure;margin-left: auto;margin-right: auto;">
		<div style="padding:30% 40%;">
		<table>
			<form id="loginForm"
				action="${pageContext.request.contextPath}/LoginAction"
				method="Post">
				<tr>
					<td><input type="text" class="form-control" id="username"
						name="username" placeholder="请输入用户名"></td>
				</tr>
				<tr>
					<td><input type="password" class="form-control" id="password"
						name="password" placeholder="请输入密码"></td>
				</tr>
				<tr>
					<td><input id="btnOK" class="btn btn-primary btn-sm btn-block"
						type="submit" value="登录" /></td>
				</tr>
				<tr>
					<td><p id="returnMsg" style="text-align: center"></p>
					</td>
				</tr>
				<tr>
					<td style="text-align: right;"><a
						href="${pageContext.request.contextPath}/register.jsp">点我注册...</a>
					</td>
				</tr>
			</form>
		</table>
	</div>
	</div>
</body>
</html>
