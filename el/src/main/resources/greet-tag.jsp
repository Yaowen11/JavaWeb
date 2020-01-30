<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/30
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mm" uri="/maytag" %>
<html>
<head>
    <title>greet tag</title>
</head>
<body>
<%
    int size = 3;
%>

<mm:greet count="3">
    <font size="<%=size++%>">
        Hi.${param.username}
    </font>
</mm:greet>
</body>
</html>
