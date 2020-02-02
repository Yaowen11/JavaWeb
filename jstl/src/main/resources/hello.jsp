<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/1
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="hello.title"/></title>
</head>
<body>
    <fmt:requestEncoding value="UTF-8"/>
<b>
    <fmt:message key="hello.hi">
        <fmt:param value="${param.username}"/>
        <fmt:param value="<%=new Date()%>"/>
    </fmt:message>
</b>
</body>
</html>
