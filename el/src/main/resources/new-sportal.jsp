<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Tag file</title>
</head>
<body>
<h2>News Portal: Another Tag File Example</h2>
<table border="0">
    <tr valign="top">
        <td>
            <tf:display color="#ff0000" bgcolor="#ffc0c0" title="Travel">
                Last French Concorde Arrives in NY<br>
                Another Travel Headline<br>
                Yet Another Travel Headline<br>
            </tf:display>
        </td>
        <td>
            <tf:display color="#00fc00" bgcolor="#c0ffc0"  title="Technology">
                Java for in-flight entertainment<br>
                Another Technology Headline<br>
                Another Technology Headline<br>
            </tf:display>
        </td>

        <td>
            <tf:display color="#ffcc11" bgcolor="#ffffcc" title="Sports">
                Football<br>
                NBA<br>
                Soccer<br>
            </tf:display>
        </td>
    </tr>
</table>
</body>
</html>
