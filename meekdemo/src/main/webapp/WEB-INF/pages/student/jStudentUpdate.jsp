<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<sf:form
        action="${pageContext.request.contextPath}/njupt/saveOrUpdate.action"
        modelAttribute="student"
        method="post">

    <div style="padding:20px;">
        完善信息
    </div>


    <table>
        <sf:hidden path="id"/>
        <sf:hidden path="access"/>
        <sf:hidden path="stuId"/>


        <tr>
            <td>姓名:</td>
            <td><sf:input path="name"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><sf:input path="password"/></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><sf:input path="age"/></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><sf:input path="gender"/></td>
        </tr>
        <tr>
            <td>头像:</td>
            <td><input type="file" name="photo" value=""/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" name="btnOK" value="保存"/></td>
        </tr>
    </table>


</sf:form>

</body>
</html>