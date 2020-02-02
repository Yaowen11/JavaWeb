<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
    <title>jstl out</title>
</header>
<body>
<c:out value="${param.username}" default="unknown"/>
<c:out value="${param.username}">
    unknown
</c:out>
1: ${fn:escapeXml("<b>表示粗体字</b>")} <br>
2: <c:out value="<b>表示粗体字</b>" escapeXml="true" /> <br>
3: ${"<b>表示粗体字</b>"} <br>
</body>
</html>
