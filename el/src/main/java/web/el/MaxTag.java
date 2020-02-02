package web.el;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author z
 */
public class MaxTag extends SimpleTagSupport implements DynamicAttributes {
    private ArrayList<String> al = new ArrayList<>();

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        al.add((String) value);
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        int max = 0;
        for (String s : al) {
            int num = Integer.parseInt(s);
            max = Math.max(num, max);
        }
        context.setAttribute("max", max);
    }
}
