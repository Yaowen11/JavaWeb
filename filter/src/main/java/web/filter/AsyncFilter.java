package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author z
 */
@WebFilter(
        filterName = "AsyncFilter",
        urlPatterns = "/async",
        asyncSupported = true
)
public class AsyncFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(60 * 1000);
        asyncContext.start(new MyTask(asyncContext));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

    class MyTask implements Runnable {

        public MyTask(AsyncContext asyncContext) {
        }

        @Override
        public void run() {
            filterConfig.getServletContext().log("AsyncFilter:doFilter()");
            }
    }
}
