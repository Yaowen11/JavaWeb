<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="common.jsp"%>

<html>
<head>
    <title>book store</title>
</head>
<%@include file="banner.jsp"%>
<center>
    <p>
        <b>
            <a href="<%=request.getContextPath()%>/catalog.jsp">查看所有书目</a>
        </b>
    </p>
    <form action="bookdetails.jsp" method="POST">
        <h3>input </h3>
        <b>book id: </b>
        <input type="text" size="20" name="bookId" value=""><br>
        <center><input type="submit" value="查询"></center>
    </form>
</center>
</body>
</html>