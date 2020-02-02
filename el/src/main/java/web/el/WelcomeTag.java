package web.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author z
 */
public class WelcomeTag extends SimpleTagSupport {
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().print(username + ",");
        JspFragment jspFragment = getJspBody();
        jspFragment.invoke(null);
    }
}
