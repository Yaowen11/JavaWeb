<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    //分页变量定义
    final int e=3;            //每页显示的记录数
    int totalPages=0;         //页面总数
    int currentPage=1;        //当前页面编号
    int totalCount=0;         //数据库中数据的总记录数
    int p=1;                  //当前页面所显示的第一条记录的游标

    String tempStr = request.getParameter("currentPage");

    if (tempStr != null && !tempStr.isEmpty()) {
        currentPage = Integer.parseInt(tempStr);
    }

    String sql = "select id, author, title, price from books order by id";

    try (ResultSet resultSet = statement.executeQuery(sql)) {
        resultSet.last();
        totalCount = resultSet.getRow();

        totalPages = (totalCount %e == 0) ? (totalCount / e) : (totalCount / e + 1);
        if (totalPages == 0) {
            totalPages = 1;
        }

        if (currentPage > totalPages) {
            currentPage = totalPages;
        } else if (currentPage < 1) {
            currentPage = 1;
        }

        p = (currentPage - 1)  * e + 1;
        resultSet.absolute(p);
%>

页码:
<% for(int i = 1; i <= totalPages; i++) {
    if (i== currentPage) {
%>

<%=i%>
<% } else { %>
<a href="data-scroll.jsp?currentPage=<%=i%>"><%=i %></a>
<% } %>

<% } %>

共<%=totalPages%>页,共<%=totalCount%>条记录

<table border="1" width=400>

    <tr>
        <td bgcolor="#D8E4F1"><b>书编号</b></td>
        <td bgcolor="#D8E4F1"><b>作者</b></td>
        <td bgcolor="#D8E4F1"><b>书名</b></td>
        <td bgcolor="#D8E4F1"><b>价格</b></td>
    </tr>

    <%
    int count = 0;
    do {
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
    } while (resultSet.next() && ++ count < e);
    %>

</table>
<%
    }
%>