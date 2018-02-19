<%--
  Created by IntelliJ IDEA.
  User: TheXaXo
  Date: 2/19/2018
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing Up</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post">
    <label for="username">Username</label>
    <input type="text" placeholder="Username" name="username" id="username">
    <label for="password">Password</label>
    <input type="password" placeholder="Password" name="password" id="password">
    <label for="confirmPassword">Confirm Password</label>
    <input type="password" placeholder="Confirm Password" name="confirmPassword" id="confirmPassword">
    <input type="submit" value="Sing Up">
</form>
</body>
</html>
