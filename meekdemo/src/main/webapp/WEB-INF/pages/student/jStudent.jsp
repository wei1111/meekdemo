<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script language="javascript">
        //批量提交
        function deleteMuch() {
            document.forms[0].action = "${pageContext.request.contextPath}/njupt/deleteMuch.action?stuId=${stuId}";
            document.forms[0].submit();		//手动提交
        }
    </script>
</head>
<body>

<form method="post">

    <div style="padding:20px;" align="left">
        <c:if test="${hasAccess }">
            全部用户信息：
        </c:if>
        <c:if test="${!hasAccess}">
            个人信息：
        </c:if>
    </div>
    <table border="1">
        <tr>
            <c:if test="${hasAccess}">
                <td>选择</td>
            </c:if>

            <td>头像:</td>

            <td>学号:</td>
            <td>姓名:</td>
            <c:if test="${studentList[0].age !=null || hasAccess}">
                <td>年龄:</td>
            </c:if>
            <c:if test="${studentList[0].gender !=null || hasAccess}">
                <td>性别：</td>
            </c:if>
            <td>完善资料</td>
            <c:if test="${hasAccess}">
                <td>	<a href="#" onclick="deleteMuch();">批量删除</a></td>
            </c:if>

        </tr>

        <c:forEach items="${studentList}" var="s">
            <tr>
                <c:if test="${hasAccess}">
                    <td><input type="checkbox" name="stuIds" value="${s.stuId}" /></td>
                </c:if>
                <td><img src="${pageContext.request.contextPath}${s.photopath}" lang="50" width="50"/></td>
                <td>${s.stuId}</td>
                <td>${s.name}</td>
                <c:if test="${s.age !=null || hasAccess}">
                    <td>${s.age }</td>
                </c:if>
                <c:if test="${s.gender !=null || hasAccess}">
                </c:if>
                    <td>${s.gender }</td>
                <td>
                    <a href="${pageContext.request.contextPath}/njupt/update.action?stuId=${s.stuId}">完善资料</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <div align="left"><a href="${pageContext.request.contextPath}/njupt/index.action">注销</a></div>


</form>

</body>
</html>