<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/1
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSTL fmt message</title>
</head>
<body>
    <fmt:setBundle basename="messages"/>
    <fmt:setBundle basename="module_resource" var="myres"/>
    <p>module_resource properties file key: 'myword': <fmt:message key="myword"/></p>
    <fmt:bundle basename="module_resource">
        <p>\fmt:bundle 标签不指定 var 属性，在 body content 输出 myword: <fmt:message key="myword"/></p>
    </fmt:bundle>
    <p><fmt:message key="myword" bundle="${myres}"/></p>
</body>
</html>
