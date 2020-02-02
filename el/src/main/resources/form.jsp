<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/1
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form content</title>
</head>
<body>
<h3>Fill-out-form</h3>
<p>
    <form action="form.jsp" method="GET">
        name=<label><input type="text" name="username" value="${param["username"]}"></label>
        <input type="submit" value="submit">
    </form>
<p>The name is: ${param.username}</p>
</body>
</html>
