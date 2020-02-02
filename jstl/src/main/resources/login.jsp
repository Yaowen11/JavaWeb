<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/1
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.locale}" scope="session" />
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="login.title"/></title>
</head>
<body>
<form name="loginForm" method="post" action="hello.jsp">
    <table>
        <tr>
            <td>
                <div align="right">
                    <fmt:message key="login.user" />:
                </div></td>
            <td>
                <label>
                    <input type="text" name="username">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <div align="right"><fmt:message key="login.password" />:
                </div>
            </td>
            <td>
                <label>
                    <input type="password" name="password">
                </label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="submit" value="<fmt:message key="login.submit"/>"></td>
        </tr>
    </table>
</form>
</body>
</html>
