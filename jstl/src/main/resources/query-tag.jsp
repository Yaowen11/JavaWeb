<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL query tag</title>
</head>
<body>
<sql:setDataSource dataSource="jdbc/books" var="bookRes"/>
<sql:query var="books" startRow="1" maxRows="4" dataSource="${bookRes}">
    select id, author, title, price from books order by price;
</sql:query>
<table border="1">
    <tr>
        <th>${books.columnNames[0]}</th>
        <th>${books.columnNames[1]}</th>
        <th>${books.columnNames[2]}</th>
        <th>${books.columnNames[3]}</th>
    </tr>

    <c:forEach var="book" items="${books.rowsByIndex}">
    <tr>
        <td>${book[0]}</td>
        <td>${book[1]}</td>
        <td>${book[2]}</td>
        <td>${book[3]}</td>
    </tr>
    </c:forEach>
</body>
</html>
