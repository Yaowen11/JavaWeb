<%@ attribute name="frag1" fragment="true" %>
<%@ attribute name="frag2" fragment="true" %>
<table border="1">
    <tr>
        <td>frag1</td>
        <td>
            <jsp:invoke fragment="frag1"/>
        </td>
    </tr>
    <tr>
        <td>
            frag2
        </td>
        <td>
            <jsp:invoke fragment="frag2"/>
        </td>
    </tr>
</table>