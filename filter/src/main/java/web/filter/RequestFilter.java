package web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author z
 */
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        MyRequestWrapper requestWrapper= new MyRequestWrapper((HttpServletRequest)request);
        chain.doFilter(requestWrapper, response);
    }
    @Override
    public void destroy() {}
}
