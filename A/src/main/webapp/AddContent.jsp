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
<title>发布内容</title>
<script type="text/javascript" src="js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/ckfinder/ckfinder.js"></script>
<link rel="stylesheet" href="js/Bootstrap/css/bootstrap.min.css"
	type="text/css"></link>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnOK")
				.click(
						function() {
							var title = $("#title").val();
							var content= CKEDITOR.instances.content.getData();
							//var content = $("#content").val();
							if (title && content) {
								$
										.ajax({
											cache : true,
											type : "POST",
											url : '${pageContext.request.contextPath}/AddContentAction',
											data : {
												title : title,
												content : content
											},
											async : false,
											success : function(data) {
												if (data == 'true') {
													alert('发布成功');
												} else if(data == 'false') {
													alert('发布失败');
												}else{
													alert('会话过期,请重新登录！');
													window.location.href="login.jsp";
												}
												$('#title').html('');
												CKEDITOR.instances.content
														.setData("");
											}
										});
							} else {
								alert("标题或者内容不能为空!");
							}
						});
	});
</script>
</head>
<body>
	<div
		style="width: 61.8%;height: 100%;margin-left: auto;margin-right: auto;background-color: azure;text-align: center;">
		<div
			style="margin-top: 100px;margin-left: auto;margin-right: auto;clear: both;">
			<form id="addContent">
				<input type="input" class="form-control" id="title" name="title"
					placeholder="请输入标题" /><br />
				<textarea id="content" name="content" placeholder="请输入内容"
					class="form-control" rows="10" cols="10"></textarea>
				<br /> <input id="btnOK" class="btn btn-primary btn-sm btn-block"
					type="button" value="提交" />
			</form>
			 <script type="text/javascript">
				CKEDITOR.replace('content');
				CKEDITOR.on('instanceReady', function(ev) {
					ev.editor.execCommand('toolbarCollapse');
				});
			</script>
		</div>
	</div>
</body>
</html>
