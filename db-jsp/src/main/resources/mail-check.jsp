<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="session.web.User,session.web.OnlineUsers,java.util.*" %>
<html>
<head>
    <title>mail check jsp</title>
</head>
<body>
<%
    String name = request.getParameter("username");
    if (name != null) {
        session.setAttribute("user", new User(name));
    } else {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(response.encodeRedirectURL("mail-login.jsp")) ;
        }
    }
%>

<a href="<%=response.encodeURL("mail-login.jsp")%>">登录</a>
<a href="<%=response.encodeURL("mail-logout.jsp")%>">注销</a>
<p>当前用户为: <%=name%></p>
<p>你的信箱中有 100 封邮件</p>

<hr>
<%
    Integer counter = (Integer) application.getAttribute("counter");
    if (counter != null) {
%>
<p>总人数为：<%=counter %></p>
<%
    }
%>
<p>当前在线人数:
<%
    OnlineUsers onlineUsers = OnlineUsers.getInstance();
%>>
    <%= onlineUsers.getCount()%>
</p>
</body>
</html>