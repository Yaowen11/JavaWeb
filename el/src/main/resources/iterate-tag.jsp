<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/30
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="web.el.*" %>
<%@ page import="java.util.*" %>
<%
    BookDetails book1=new BookDetails("201", "孙卫琴",
            "Java面向对象编程", 65, 2006,
            "让读者由浅入深掌握Java语言", 20000);
    BookDetails book2=new BookDetails("202", "孙卫琴",
            "精通Struts", 49, 2004, "真的很棒", 80000);
    BookDetails book3=new BookDetails("203", "孙卫琴",
            "Tomcat与JavaWeb开发技术详解", 45, 2004,
            "关于JavaWeb开发的最畅销书", 40000);
    BookDetails book4=new BookDetails("204", "孙卫琴",
            "Java网络编程精解",55, 2007, "很值得一看", 20000);
    List<BookDetails> bookDetails = new ArrayList<>();
    bookDetails.add(book1);
    bookDetails.add(book2);
    bookDetails.add(book3);
    bookDetails.add(book4);
%>
<html>
<head>
    <title>iterator tag</title>
</head>
<body>
    <table border="1">
        <caption><b>书的信息</b></caption>
        <tr>
            <th>作者</th>
            <th>书名</th>
            <th>价格</th>
            <th>评价</th>
        </tr>
        <%
            for (BookDetails bookInfo: bookDetails) {
                pageContext.setAttribute("book", bookInfo, PageContext.PAGE_SCOPE);
        %>
        <tr>
            <td>${book.name}</td>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>${book.description}</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
