<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>JSTL SQL Tag</title>
</head>
<body>
    <sql:setDataSource url="jdbc:mysql://mysql8/web" user="root" password="secret"/>
    <sql:query sql="select id,author,title,price from books order by id" startRow="1" maxRows="4" var="books"/>
    <p>共有 ${books.rowCount} 本书</p>
    <table>
        <tr>
            <th>${books.columnNames[0]}</th>
            <th>${books.columnNames[1]}</th>
            <th>${books.columnNames[2]}</th>
            <th>${books.columnNames[3]}</th>
        </tr>
        <c:forEach var="book" items="${books.rows}">
            <tr>
                <td>${book.id}</td>
                <td>${book.author}</td>
                <td>${book.title}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
