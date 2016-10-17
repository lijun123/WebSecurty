<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Web安全</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="js/Bootstrap/css/bootstrap.min.css" type="text/css"></link>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <div style="width: 70%;height: 100%;margin-left: auto;margin-right: auto;background-color: azure;text-align: center;">
        <div style="position: absolute;top: 0;bottom: 0;left:0;right:0;margin: auto;width:50%;height:30%">
           
            <input type="button" onclick="JavaScript:window.open('register.jsp')" class="btn btn-primary btn-lg" value="注册"/>
            &nbsp;
            <button type="button" onclick="JavaScript:window.open('login.jsp')" class="btn btn-info btn-lg">登录</button>
            
        </div>
        <div style="text-align: right;"> <p><a href="${pageContext.request.contextPath}/whatXss.jsp">有输入就有攻击...</a></p></div>
    </div>
  </body>
</html>
