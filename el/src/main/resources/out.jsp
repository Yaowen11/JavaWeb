<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>tag file</title>
</head>
<body>
    <tf:precode>
        <jsp:attribute name="preserve">
            <p>${code}</p>
        </jsp:attribute>
        <jsp:body>
            ${fn:toUpperCase(" Tomcat ")}
        </jsp:body>
    </tf:precode>
</body>
</html>
