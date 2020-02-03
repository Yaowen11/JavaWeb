package web.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author z
 */
public class ReplaceTextFilter implements Filter {
    private FilterConfig config;
    private String searchStr = null;
    private String replaceStr = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        searchStr = config.getInitParameter("search");
        replaceStr = config.getInitParameter("replace");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //创建由Servlet容器提供的ServletResponse对象的包装类对象
        ReplaceTextWrapper myWrappedResp = new ReplaceTextWrapper(response,searchStr, replaceStr);
        config.getServletContext().log("ReplaceTextFilter:before call chain.doFilter()");
        //把ServletResponse对象的包装类对象传给后续Web组件
        chain.doFilter(request, myWrappedResp);
        config.getServletContext().log("ReplaceTextFilter:after call chain.doFilter()");
        myWrappedResp.getOutputStream().close();
    }

    @Override
    public void destroy() {
        config = null;
    }
}
