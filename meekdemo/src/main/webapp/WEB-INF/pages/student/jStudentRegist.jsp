<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form enctype="multipart/form-data"
      action="${pageContext.request.contextPath}/njupt/saveOrUpdate.action" method="post">


    <c:if test="${hasAccount=='N'}">
        您尚未注册，请注册后登陆。
        <hr>
    </c:if>
    <div style="padding:20px;">
        注册：
    </div>

    <table>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" value=""/></td>
        </tr>
        <tr>
            <td>学号:</td>
            <td><input type="text" name="stuId" value=""/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="password" value=""/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="btnOK" value="保存"/></td>
        </tr>
    </table>


</form>

</body>
</html>