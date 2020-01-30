<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/29
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="mm" uri="/maytag" %>
<html>
<head>
    <title><mm:message key="hello.title" /></title>
</head>
<body>
<%
    request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
%>
<p><mm:message key="hello.hi" />:${param.username}</p>
</body>
</html>
