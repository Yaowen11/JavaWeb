<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="session.web.User" %>
<html>
<head>
    <title>login out</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    String name = null;
    if (user != null) {
        name = user.getName();
    }
    session.invalidate();
%>

<%=name%>, 再见
<p></p>
<a href="<%=response.encodeURL("mail-login.jsp")%>">重新登录</a>
</body>
</html>
