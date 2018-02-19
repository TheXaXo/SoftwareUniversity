<%--
  Created by IntelliJ IDEA.
  User: TheXaXo
  Date: 2/19/2018
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing In</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post">
    <label for="username">Username</label>
    <input type="text" placeholder="Username" name="username" id="username">
    <label for="password">Password</label>
    <input type="password" placeholder="Password" name="password" id="password">
    <input type="submit" value="Sing In">
</form>
</body>
</html>