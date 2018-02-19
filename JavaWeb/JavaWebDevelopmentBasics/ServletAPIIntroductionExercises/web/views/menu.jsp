<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.bindingModels.LoginModel" %><%--
  Created by IntelliJ IDEA.
  User: TheXaXo
  Date: 2/19/2018
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<div style="color: blue">
    <a href="/">Home</a>
    <%
        LoginModel loginModel = (LoginModel) session.getAttribute("LOGIN_MODEL");
        String username = null;

        if (loginModel != null) {
            username = loginModel.getUsername();
        }

        pageContext.setAttribute("username", username);
    %>
    <c:set var="username" value="${username}" scope="session"/>
    <c:choose>
        <c:when test="${username != null}">
            <a href="/add">Add Book</a>
            <a href="/shelves">Shelves</a>
            <a href="/singout">Sing Out(${username})</a>
        </c:when>
        <c:otherwise>
            <a href="/singup">Sign Up</a>
            <a href="/singin">Sign In</a>
        </c:otherwise>
    </c:choose>
</div>
<br>
</body>
</html>