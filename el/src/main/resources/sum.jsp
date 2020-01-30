<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="mf" uri="/mytaglib" %>

<html>
    <head>
        <title>el functions</title>
    </head>
    <body>
        <h3>Add Number</h3>
        <form action="sum.jsp" method="get">
            user = <label><input type="text" name="user" value="${mf:convert(param.user)}"></label>
            x = <label><input type="text" name="x" value="${param.x}"></label>
            y = <label><input type="text" name="y" value="${param.y}"></label>
            <input type="submit" value="Add">
        </form>
        <p>the sum is: ${mf:add(param.x, param.y)}</p>
    </body>
</html>