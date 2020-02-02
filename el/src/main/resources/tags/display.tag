<%@ attribute name="color" %>
<%@ attribute name="bgcolor" %>
<%@ attribute name="title" %>

<table border="0" bgcolor="${color}">
    <tr>
        <td>${title}</td>
    </tr>
    <tr>
        <td bgcolor="${bgcolor}">
            <jsp:doBody/>
        </td>
    </tr>
</table>