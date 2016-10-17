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

<title>用户信息查看</title>
</head>

<body>
	<div
		style="width: 61.8%;height: 100%;background-color: azure;margin-left: auto;margin-right: auto;">
		<div style="padding:30% 40%;">
			<a href="${pageContext.request.contextPath}/showUserDataAction">查看用户信息</a>
		</div>
	</div>
</body>
</html>
