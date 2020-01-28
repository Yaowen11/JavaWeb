<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="common.jsp"%>

<jsp:useBean id="cart" scope="session" class="book.store.ShoppingCart" />

<html>
<head>
    <title>book catalog</title>
</head>
<%@ include file="banner.jsp"%>
<%
    String bookId = request.getParameter("Add");
    if (bookId != null) {
        BookDetails bookDetails = bookDB.getBookDetails(bookId);
        cart.add(bookId, bookDetails);
%>
<p><h3><font color="red">您已将 <i><%=bookDetails.getTitle()%></i> 加入购物车</font></h3></p>
<%
    }
    if (cart.getNumberOfItems() > 0) {
%>

<p><strong><a href="<%=request.getContextPath()%>/showcart.jsp">查看购物车</a></strong></p>
<p><strong><a href="<%=request.getContextPath()%>/cashier.jsp">付账</a></strong></p>

<%
    }
%>

<h3>请选择想购买的书：</h3>
<table>
    <%
        Collection c = bookDB.getBooks();
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            BookDetails bookDetails = (BookDetails) iterator.next();
            bookId = bookDetails.getBookId();
    %>
    <tr>
        <td bgcolor="#ffffaa">
            <a href="<%=request.getContextPath()%>/bookdetails.jsp?bookId=<%=bookId%>"><strong><%=bookDetails.getTitle()%></strong></a>
        </td>
        <td bgcolor="#ffffaa" rowspan=2>
            <a href="<%=request.getContextPath()%>/catalog.jsp?Add=<%=bookId%>">加入购物车</a>
        </td>
    </tr>
    <tr>
        <td bgcolor="#ffffff">
            作者: <em><%=bookDetails.getAuthor()%></em>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>