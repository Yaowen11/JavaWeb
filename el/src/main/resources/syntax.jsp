<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/1
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>expression language examples</title>
</head>
<body>
    <h3>jsp expression language examples</h3>
    <p>the following table illustrates some el expressions and implicit objects:</p>
    <table>
        <thead>
            <td>expression</td>
            <td>value</td>
        </thead>
        <tr>
            <td>\${2 + 5}</td>
            <td>${2 + 5}</td>
        <tr>
            <td>\${4/5}</td>
            <td>${4/5}</td>
        </tr>
        <tr>
            <td>\${5 div 6}</td>
            <td>${5 div 6}</td>
        </tr>
        <tr>
            <td>\${5 mod 7}</td>
            <td>${5 mod 7}</td>
        </tr>
        <tr>
            <td>\${2 < 3}</td>
            <td>${2 < 3}</td>
        </tr>
        <tr>
            <td>\${2 gt 3}</td>
            <td>${2 gt 3}</td>
        </tr>
        <tr>
            <td>\${3.1 le 3.2}</td>
            <td>${3.1 le 3.2}</td>
        </tr>
        <tr>
            <td>\${(5 > 3) ? 5 : 3}</td>
            <td>${(5 > 3) ? 5 : 3}</td>
        </tr>
        <tr>
            <td>\${header.host}</td>
            <td>${header.host}</td>
        </tr>
        <tr>
            <td>\${header["user-agent"]}</td>
            <td>${header["user-agent"]}</td>
        </tr>
    </table>
</body>
</html>
