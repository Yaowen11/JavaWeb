<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/30
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mm" uri="/maytag" %>
<html>
<head>
    <title>show tag content</title>
</head>
<body>
<%
    int size = 3;
%>
<%
    int count = 3;
    String username = request.getParameter("username");
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < count; i++) {
        buffer.append("<font size='")
                .append(size++)
                .append("'>")
                .append("\r\n")
                .append("Hi,")
                .append(username)
                .append("<br>")
                .append("\r\n")
                .append("</font>")
                .append("\r\n");
    }
    System.out.println(buffer);
    if ("Monster".equals(username)) {
%>
    Go away,Monster!
<%
    } else {
%>
<%=buffer.toString()%>
<%
    }
%>
</body>
</html>
