<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/1
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.HashMap" %>

<p>variable container is: ${empty pageScope.container}</p>

<%
    HashMap<String, String> container = new HashMap<>();
    pageContext.setAttribute("container", container, PageContext.PAGE_SCOPE);
%>

<p>page variable container is: ${empty pageScope.container}</p>

<%
    container.put("name", "Tom");
    container.put("age", "18");
%>

<p>page variable ${empty pageScope.container}</p>
<p>page variable request param ${empty param.username}</p>
<p>page variable map ${pageScope.container.user}</p>
<p>page variable map ${pageScope.container["age"]}</p>