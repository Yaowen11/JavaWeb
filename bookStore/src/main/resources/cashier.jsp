<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common.jsp"%>
<%@ page import="java.util.*"%>

<jsp:useBean id="cart" scope="session" class="book.store.ShoppingCart"/>

<html>
<head>
    <title>title cashier</title>
</head>
<%@ include file="banner.jsp"%>
<p>一共购买了：<%=cart.getNumberOfItems()%>本书</p>
<p>应付金额为：<%=cart.getTotal()%>元</p>

<form action="<%=request.getContextPath()%>/receipt.jsp" method="post">
    <table>
        <tr>
            <td><strong>信用卡用户名：</strong></td>
            <td><input type="text" name="cardname" value="guest" size="19"></td>
        </tr>
        <tr>
            <td><strong>信用卡账号：</strong></td>
            <td><input type="text" name="cardnum" value="xxxx xxxx xxxx xxxx" size="19"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</html>