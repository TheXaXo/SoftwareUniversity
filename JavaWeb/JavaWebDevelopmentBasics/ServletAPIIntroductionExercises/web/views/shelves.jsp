<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TheXaXo
  Date: 2/19/2018
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shelves</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<table class="tb">
    <thead>
    <th>Title</th>
    <th>Author</th>
    <th>Pages</th>
    <th>Delete</th>
    </thead>
    <tbody>
    <c:set var="books" value="${books}"/>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>
                <c:out value="${book.getTitle()}"/>
            </td>
            <td>
                <c:out value="${book.getAuthor()}"/>
            </td>
            <td>
                <c:out value="${book.getPages()}"/>
            </td>
            <td>
                <a href="/shelves/delete/${book.getTitle()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>