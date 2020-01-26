<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>data scroll jsp</title>
    </head>
    <body>
        <%
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/bookDB");
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        %>
        <%@ include file="page-scorll.jsp"%>
        <%
            }
        %>
    </body>
</html>