package web.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author z
 */
public class ReplaceTextWrapper extends HttpServletResponseWrapper {

    /**
     * ServletOutputStream的包装对象
     */
    private ReplaceTextStream tpStream;

    public ReplaceTextWrapper(ServletResponse inResp, String searchText,
                              String replaceText)throws java.io.IOException {
        super((HttpServletResponse) inResp);
        tpStream = new ReplaceTextStream(inResp.getOutputStream(),
                searchText,replaceText);

    }

    @Override
    public ServletOutputStream getOutputStream() throws java.io.IOException {
        return tpStream;
    }
}
