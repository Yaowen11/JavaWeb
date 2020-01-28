<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="common.jsp"%>

<jsp:useBean id="cart" scope="session" class="book.store.ShoppingCart"/>

<html>
<head>
    <title>title shopping cart</title>
</head>
<%@ include file="banner.jsp"%>
<%
    String bookId = request.getParameter("Remove");
    if (bookId != null) {
        cart.remove(bookId);
        BookDetails bookDetails = bookDB.getBookDetails(bookId);
%>
<font color="red" size="+2">你删除了一本书:<em><%=bookDetails.getTitle()%></em><br></font>

<%
    }
    if (request.getParameter("Clear") != null) {
        cart.clear();
%>

<font color="red" size="+2"><strong>清空购物车</strong><br></font>

<%
    }
    int num = cart.getNumberOfItems();
    if (num > 0) {
%>

<font size="+2">您的购物车内有<%=num%>本书</font><br>

<table>
    <tr>
        <th align="left">数量</th>
        <th align="left">书名</th>
        <th align="left">价格</th>
    </tr>

    <%
        Iterator i = cart.getItems().iterator();
        while (i.hasNext()) {
            ShoppingCartItem item = (ShoppingCartItem) i.next();
            BookDetails bookDetails = (BookDetails) item.getItem();
    %>

    <tr>
        <td align="right" bgcolor="#ffffff">
            <%=item.getQuantity()%>
        </td>

        <td bgcolor="#ffffaa">
            <strong><a href="<%=request.getContextPath()%>/bookdetails.jsp?bookId=<%=bookDetails.getBookId()%>"><%=bookDetails.getTitle()%></a></strong>
        </td>

        <td bgcolor="#ffffaa" align="right">
            <%=bookDetails.getPrice()%>
        </td>

        <td bgcolor="#ffffaa">
            <strong>
                <a href="<%=request.getContextPath()%>/showcart.jsp?Remove=<%=bookDetails.getBookId()%>">删除</a>
            </strong>
        </td>
    </tr>
    <%
        }
    %>

    <tr>
        <td colspan="5" bgcolor="#ffffff"><br></td>
    </tr>

    <tr>
        <td colspan="2" align="right" bgcolor="#ffffff">总额</td>
        <td bgcolor="#ffffaa" align="right"><%=cart.getTotal()%></td>
    </tr>
</table>

<p>
    <strong>
        <a href="<%=request.getContextPath()%>/catalog.jsp">继续购物</a>
        <a href="<%=request.getContextPath()%>/cashier.jsp">付账</a>
        <a href="<%=request.getContextPath()%>/showcart.jsp?Clear=clear">清空购物车</a>
    </strong>
</p>
<%
    } else {
%>

<font size="+2">你的购物车为空</font>
<br>
<a href="<%=request.getContextPath()%>/catalog.jsp">继续购物</a>

<%
    }
%>

</body>
</html>