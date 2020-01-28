9887/<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common.jsp"%>

<jsp:useBean id="cart" scope="session" class="book.store.ShoppingCart"/>

<%
    bookDB.buyBooks(cart);
    session.invalidate();
%>
<html>
<head><title>TitleReceipt</title></head>
<%@include file="banner.jsp"%>

<h3><%=request.getParameter("cardname")%>: 欢迎光临</h3>
<strong><a href="<%=request.getContextPath()%>/bookstore.jsp">继续购物</a></strong>
</body>
</html>