<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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

    <title>用户登陆</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
<div align="center">
    <c:if test="${passwordError!=null}">
        密码错误，请从新输入！
        <hr>
    </c:if>
</div>
<form enctype="multipart/form-data"
      action="${pageContext.request.contextPath}/njupt/login.action"
      method="post"
>
    <table border="1" width="50%" align="center">
        <tr>
            <td>请输入学号：</td>
            <td><input type="text" name="stuId"/></td>
        </tr>
        <tr>
            <td>请输入密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登陆" align="right"/></td>
        </tr>
    </table>
</form>
</body>
</html>
