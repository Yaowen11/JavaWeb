<%@ page contentType="text/html; charset=UTF-8" %>
<%
    final int e = 3;
    int totalPages = 0;
    int currentPage = 1;
    int totalCount = 0;
    int p = 1;

    String tempStr = request.getParameter("currentPage");
    if (tempStr != null && !tempStr.isEmpty()) {
        currentPage = Integer.parseInt(tempStr);
    }

    resultSet = statement.executeQuery("select count(*) from books");
    if (resultSet.next()) {
        totalCount = resultSet.getInt(1);
    }
    totalPages = ((totalCount%e==0)?(totalCount/e):(totalCount/e+1));
    if (totalPages == 0) {
        totalPages = 1;
    }
    if (currentPage > totalPages) {
        currentPage = totalPages;
    } else if (currentPage < 1) {
        currentPage = 1;
    }
    p = (currentPage - 1) * e + 1;
    String sql = "select id, author, title, price from books order by id limit " + (p - 1) + "," + e;
    resultSet = statement.executeQuery(sql);
%>

<% for(int i = 1; i < totalPages; i++) {
    if (i == currentPage) {
%>
    <%=i%>
<% } else { %>
    <a href="data-page.jsp?currentPage=<%=i%>"><%=i %></a>
<% } %>
<% } %>

共<%=totalPages%>页,共<%=totalCount%>条记录

<table border="1" width="400">
    <tr>
        <td bgcolor="#D8E4F1"><b>书编号</b></td>
        <td bgcolor="#D8E4F1"><b>作者</b></td>
        <td bgcolor="#D8E4F1"><b>书名</b></td>
        <td bgcolor="#D8E4F1"><b>价格</b></td>
    </tr>
    <%
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String author = resultSet.getString("author");
            String title = resultSet.getString("title");
            float price = resultSet.getFloat("price");
    %>

    <tr>
        <td><%=id %></td>
        <td><%=author %></td>
        <td><%=title %></td>
        <td><%=price %></td>
    </tr>

    <%
        }
    %>
</table>