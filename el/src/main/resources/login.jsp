<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/29
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mm" uri="/maytag" %>
<%
    String language = request.getParameter("language");
    if (language == null) {
        language = "Chinese";
    }
    session.setAttribute("language", language);
%>
<html>
<head>
    <title><mm:message key="login.title"/></title>
</head>
<body>
<form name="loginForm" method="post" action="hello.jsp">
    <table>
        <tr>
            <td>
                <div align="right"><mm:message key="login.user" />:</div>
            </td>
            <td>
                <label>
                    <input type="text" name="username">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <div align="right"><mm:message key="login.password" />:</div>
            </td>
            <td>
                <label>
                    <input type="password" name="password">
                </label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="Submit" name="Submit" value=<mm:message key="login.submit" /> >
            </td>
        </tr>
    </table>
</form>
</body>
</html>
