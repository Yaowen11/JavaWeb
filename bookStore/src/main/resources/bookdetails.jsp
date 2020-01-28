<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common.jsp" %>
<html>
<head>
    <title>book details</title>
</head>
<%@include file="banner.jsp"%>
<br>
<%
    String bookId = request.getParameter("bookId");
    if (bookId == null) {
        bookId = "201";
    }
    BookDetails bookDetails = bookDB.getBookDetails(bookId);
%>
<%
    if (bookDetails == null) {
%>
    <p>book: <%=bookId%> not in database</p>
    <strong><a href="<%=request.getContextPath()%>/catalog.jsp">继续购物</a></strong>
<%
    return;
    }
%>
<p>book id: <%=bookId%></p>
<p>book name: <%=bookDetails.getTitle()%></p>
<p>book author: <%=bookDetails.getAuthor()%></p>
<p>book published date: <%=bookDetails.getOnline()%></p>
<p>book price: <%=bookDetails.getPrice()%></p>
<p>book sale amount: <%=bookDetails.getSaleAmount()%></p>
<p>book description: <%=bookDetails.getDescription()%></p>
<p>
    <strong>
        <a href="<%=request.getContextPath()%>/catalog.jsp?Add=<%=bookId%>">加入购物车</a>
    </strong>
</p>
<p>
    <strong>
        <a href="<%=request.getContextPath()%>/catalog.jsp">继续购物</a>
    </strong>
</p>
</body>
</html>