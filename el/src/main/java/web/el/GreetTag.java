package web.el;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * @author z
 */
public class GreetTag extends BodyTagSupport {
    private int count;
    private String username;

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int doStartTag() {
        System.out.println("call doStartTag()");
        if (count > 0) {
            return EVAL_BODY_BUFFERED;
        }
        return SKIP_BODY;
    }
    @Override
    public void setBodyContent(BodyContent bodyContent) {
        System.out.println("call setBodyContent() ");
        super.setBodyContent(bodyContent);
    }

    @Override
    public void doInitBody() {
        System.out.println("call doInitBody() ");
        username = pageContext.getRequest().getParameter("username");
    }

    @Override
    public int doAfterBody() {
        System.out.println("call doAfterBody() ");
        if (count > 1) {
            count--;
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        System.out.println("call doEndTag() ");
        JspWriter out = bodyContent.getEnclosingWriter();
        try {
            String content = bodyContent.getString();
            System.out.println(bodyContent.getString());

            if ("Monster".equals(username)) {
                content = "Go away, Monster!";
            }
            out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
