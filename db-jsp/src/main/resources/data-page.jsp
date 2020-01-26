<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>data page jsp</title>
    </head>
    <body>
        <%
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/bookDB");
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = null;
        %>

        <%@ include file="pages.jsp"%>
        <%
            }
        %>
    </body>
</html>