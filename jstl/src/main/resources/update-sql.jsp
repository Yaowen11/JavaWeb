<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sq" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>JSTL sql tab update </title>
</head>
<body>
<sql:setDataSource dataSource="jdbc/books"/>
<sql:transaction>
    <sql:update var="update">
        update books set price = price + 100 where price > ?
        <sql:param>50</sql:param>
    </sql:update>
    <sq:update var="insert">
        insert into books values(?,?,?,?,?,?,?)
        <sql:param>207</sql:param>
        <sql:param>王小亚</sql:param>
        <sql:param>Java编程</sql:param>
        <sql:param>60</sql:param>
        <sql:param>2008</sql:param>
        <sql:param>好书</sql:param>
        <sql:param>20000</sql:param>
    </sq:update>
    <sql:update var="delete">
        delete from books where id = ?
        <sql:param>206</sql:param>
    </sql:update>
</sql:transaction>
<p>共更新了${update}条记录</p>
<p>插入了${insert}条记录</p>
<p>删除了${delete}</p>
</body>
</html>
