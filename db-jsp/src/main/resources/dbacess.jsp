<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>
        <title>jsp access db</title>
    </head>
    <body>
    <%
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://mysql8:3306/web", "root", "secret");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into books  values ('555', 'zyw', 'Tomcat bible', 44.5, 2019, 'tomcat user guide', 10000)");
            try (ResultSet resultSet = statement.executeQuery("select * from books")) {
                out.println("<table border=1 width=400>");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    float price = resultSet.getFloat("price");
                    out.println("<tr><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + price + "</td></tr>");
                }
                out.println("</table>");
            }
            statement.executeUpdate("delete from books where author = 'zyw'");
        }
    %>
    </body>
</html>