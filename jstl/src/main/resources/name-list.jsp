<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashSet" %>

<%
    HashSet<String> names = new HashSet<>();
    names.add("Tom");
    names.add("Make");
    names.add("Linda");
%>

<table>
    <tr>
        <td>序号</td>
        <td>索引</td>
        <td>是否是第一个元素</td>
        <td>是否是最后一个元素</td>
        <td>元素值</td>
    </tr>
    <c:forEach var="name" items="<%=names%>" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${status.index}</td>
            <td>${status.first}</td>
            <td>${status.last}</td>
            <td>
                <c:choose>
                    <c:when test="${status.last}">
                        <span style="color: red; ">${name}</span>
                    </c:when>
                    <c:otherwise>
                        <span style="color: green">${name}</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
