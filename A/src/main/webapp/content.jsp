<%@page import="com.lijun.web.model.ContentInfo"%>
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
<title>文章列表</title>
<link rel="stylesheet" href="js/Bootstrap/css/bootstrap.min.css"
	type="text/css"></link>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<div
		style="width:61.8%;height: 100%;margin-left: auto;margin-right: auto;background-color: azure;text-align: center;">
		
		<div
			style="position: absolute;top: 0;bottom: 0;left:0;right:0;margin: auto;width:50%;height:30%;text-align: left">
			<div style="text-align: right;"><a href="${pageContext.request.contextPath}/AddContent.jsp">我要发布</a></div>
			<c:forEach items="${requestScope.contents}" var="c">
				<div style="width: 100%;text-align: center;">
				<h3>
				${c.title}
				</h3>
				</div>
				<br/>
				<div style="text-align: right;width: 100%"><font color="red">作者:${c.bySomeOne }&nbsp;&nbsp;&nbsp;发布时间：${c.createTime }</font></div>
				<br />
				<div style="width: 100%;text-align: center;">
				${c.content}
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
