<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>JSTL Func tag</title>
</head>
<body>
    <%
        int[] array = {1, 2, 3, 4};
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
    %>
    <c:set var="array" value="<%=array %>" />
    <c:set var="list" value="<%=list %>"/>
<p>数组长度: ${fn:length(array)}</p>
<p>数组长度: ${fn:length(list)}</p>
<p>字符串 Tomcat 长度：${fn:length("Tomcat")}</p>
</body>
</html>
