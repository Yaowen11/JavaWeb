<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/2/2
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mm" uri="/maytag" %>
<html>
<head>
    <title>simple tag class max</title>
</head>
<body>
<mm:max num1="100" num2="200" num3="300"/>
<p>Max Value: ${max}</p>
<mm:max num1="500"  num2="300"  num3="400"  num4="200"  />
Max Value: ${max}
</body>
</html>
