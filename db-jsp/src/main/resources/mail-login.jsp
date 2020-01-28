<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="session.web.User" %>
<html>
    <head>
        <title>mail login jsp</title>
    </head>
    <body bgcolor="#FFFFFF" onload="document.loginForm.username.focus()">
        <%
            String name = "";
            User user = null;
            if (!session.isNew()) {
                user = (User) session.getAttribute("user");
                if (user != null) {
                    name = user.getName();
                }
            }
        %>
        <p>欢迎光临邮件系统</p>
        <p>Session ID:<%=session.getId()%></p>

        <table width="500" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <table width="500" border="0" cellpadding="0" cellspacing="0">
                        <form name="loginForm" method="post" action="<%=response.encodeURL("mail-check.jsp")%>">
                            <tr>
                                <td width="401"><div align="right">User Name: </div></td>
                                <td width="399"><input type="text" name="username" value="<%=name%>"></td>
                            </tr>
                            <tr>
                                <td width="401"><div align="right">Password: </div> </td>
                                <td width="399"><input type="password" name="password"></td>
                            </tr>
                            <tr>
                                <td width="401"></td>
                                <td width="399"><br><input type="Submit" name="Submit" value="提交"></td>
                            </tr>
                        </form>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>