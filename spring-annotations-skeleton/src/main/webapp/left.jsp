<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Left Page</title>
</head>

<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/user/list" target="main">获取用户集合</a></li>
		<li><a href="${pageContext.request.contextPath}/user/presave" target="main">添加用户</a></li>
		<li><a href="${pageContext.request.contextPath}/user/1" target="main">获取用户为1的信息</a></li>
		<%--<li><a href="${pageContext.request.contextPath}/user/xmlmock" target="main">demo xml</a></li>--%>
		<li><a href="${pageContext.request.contextPath}/user/jsonmock" target="main">demo json</a></li>
		<li><a href="${pageContext.request.contextPath}/user/flashcache/1" target="main">删除缓存</a></li>
		<li><a href="${pageContext.request.contextPath}/user/uploadPic" target="main">上传图片</a></li>
	</ul>
</body>
</html>