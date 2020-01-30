package web.el;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author z
 */
public class IterateTag extends TagSupport {

    private Iterator items;

    private String var;

    private Object item;

    public void setItems(Collection items) {
        if (items.size() > 0) {
            this.items = items.iterator();
        }
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public int doStartTag() {
        if (items.hasNext()) {
            item = items.next();
            saveItem();
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    @Override
    public int doAfterBody() {
        return doStartTag();
    }

    private void saveItem() {
        if (item == null) {
            pageContext.removeAttribute(var, PageContext.PAGE_SCOPE);
        } else {
            pageContext.setAttribute(var, item);
        }
    }
}
