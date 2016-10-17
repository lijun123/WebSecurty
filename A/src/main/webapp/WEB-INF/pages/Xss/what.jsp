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

<title>My JSP 'what.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="http://libs.baidu.com/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
	$("button").click(function() {

	});
	function test() {

		var inputValue = $("#xss_value").val();
		$("p").append("您输入的字符串是:" + inputValue);

	}
</script>
</head>

<body>
	<form id="xssForm" action="" method="get">
		<input id="xss_value" type="text" name="xss_input" /> <input
			id="submit" value="测试" onclick="test()" type="button" />
	</form>
	<hr />
	<div>
		<p></p>
	</div>
</body>
</html>
