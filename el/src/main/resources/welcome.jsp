<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>use tag file</title>
</head>
<body>
<tf:welcome>
    <jsp:attribute name="username">
        ${param.username}
    </jsp:attribute>
    <jsp:body>
        Welcome to my website
    </jsp:body>
</tf:welcome>
</body>
</html>
