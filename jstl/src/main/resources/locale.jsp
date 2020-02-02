<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/1
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<%@ page import="java.util.Locale" %>
<html>
<head>
    <title>locale</title>
</head>
<body>
<fmt:setLocale value="${header['accept-language']}" scope="session"/>
<p>1:${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'].language}</p>
<%
    Locale locale = (Locale) Config.find(pageContext, Config.FMT_LOCALE);
%>
<p>2:<%=locale.getLanguage()%></p>
</body>
</html>
