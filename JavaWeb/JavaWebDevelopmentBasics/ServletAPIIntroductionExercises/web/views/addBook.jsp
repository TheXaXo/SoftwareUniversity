<%--
  Created by IntelliJ IDEA.
  User: TheXaXo
  Date: 2/19/2018
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post">
    <label for="title">Title</label>
    <input type="text" placeholder="Title" name="title" id="title">
    <label for="author">Author</label>
    <input type="text" placeholder="Author" name="author" id="author">
    <label for="pages">Pages</label>
    <input type="text" placeholder="Pages" name="pages" id="pages">
    <input type="submit" value="Add">
</form>
</body>
</html>