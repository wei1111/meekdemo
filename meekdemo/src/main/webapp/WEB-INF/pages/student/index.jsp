<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>NJUPT网站 主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>

	<a href="${pageContext.request.contextPath}/njupt/login.action">登陆</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/njupt/regist.action">注册</a>

	<hr/>
	NJUPT网站主页
	<br>
	<hr/>
	NJUPT网站主页
	<br>
	<hr />
	NJUPT网站主页
	<br>
	<hr />
	NJUPT网站主页
	<br>
	<hr />
</body>
</html>
