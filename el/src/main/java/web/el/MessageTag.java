package web.el;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * EL 自定义标签库
 * @author z
 */
public class MessageTag extends TagSupport {

    private String key = null;

    private static final String LOCAL_LANGUAGE = "Chinese";

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            Properties ps = (Properties) pageContext.getAttribute("ps", PageContext.APPLICATION_SCOPE);
            Properties psCh = (Properties) pageContext.getAttribute("psCh", PageContext.APPLICATION_SCOPE);
            HttpSession session = pageContext.getSession();
            String language = (String) session.getAttribute("language");
            String message = LOCAL_LANGUAGE.equals(language) ?
                    new String(psCh.getProperty(key).getBytes(StandardCharsets.ISO_8859_1), "GB2312") :
                    ps.getProperty(key);
            System.out.println(message + getValueEncoding(message) + ";");
            pageContext.getOut().print(message);
        } catch (Exception ex) {
            throw new JspException(ex);
        }
        return EVAL_PAGE;
    }

    private String getValueEncoding(String value) throws UnsupportedEncodingException {
        for (String encoding: new String[]{"ASCII", "UTF-8", "ISO-8859-1"}) {
            if (value.equals(new String(value.getBytes(encoding), encoding))) {
                return encoding;
            }
        }
        return "no encoding";
    }
}
