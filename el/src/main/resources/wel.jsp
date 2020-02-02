<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sc" uri="/maytag" %>
<html>
<head>
    <title>Simple class Tag</title>
</head>
<body>
<sc:welcome username="${param.username}">
    WelCome to my website.
</sc:welcome>
</body>
</html>
