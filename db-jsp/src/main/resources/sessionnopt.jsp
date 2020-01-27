<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="session.web.MyData" %>

<%
    String action = request.getParameter("action");
    if (action == null) {
%>

<a href="sessionnopt.jsp?action=add">加入属性</a><br>
<a href="sessionnopt.jsp?action=invalidate">结束会话</a><br>

<%
} else if ("invalidate".equals(action)) {
    session.invalidate();
%>

<a href="sessionnopt.jsp">开始新的会话</a><br>

<%
} else if ("add".equals(action)) {
    session.setAttribute("data", new MyData(1));
%>

<a href="sessionnopt.jsp?action=replace">替换属性</a><br>
<a href="sessionnopt.jsp?action=remove">删除属性</a><br>
<a href="sessionnopt.jsp?action=invalidate">结束会话</a><br>

<%
} else if ("remove".equals(action)) {
    session.removeAttribute("data");
%>
<a href="sessionnopt.jsp?action=add">加入属性</a><br>
<a href="sessionnopt.jsp?action=invalidate">结束会话</a><br>

<%
} else if ("replace".equals(action)) {
    session.setAttribute("data", new MyData(1));
%>
<a href="sessionnopt.jsp?action=remove">删除属性</a><br>
<a href="sessionnopt.jsp?action=invalidate">结束会话</a><br>

<%
    }
%>