<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>截取的用户信息</title>
<link rel="stylesheet" href="js/Bootstrap/css/bootstrap.min.css"
	type="text/css"></link>
</head>

<body>
	<div
		style="width:61.8%;height: 100%;margin-left: auto;margin-right: auto;background-color: azure;text-align: center;">

		<div
			style="position: absolute;top: 0;bottom: 0;left:0;right:0;margin: auto;width:50%;height:30%;text-align: left">
			<table class="table table-hover">
				<caption>获取的用户数据</caption>
				<thead>
					<tr>
						<th>用户名称</th>
						<th>密码</th>
						<th>获取时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.userInfos}" var="u">
						<tr>
							<td>${u.userName}</td>
							<td>${u.passWord}</td>
							<td>${u.createTime}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
