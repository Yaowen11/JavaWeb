package web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author z
 */
public class NoteFilter implements Filter {

    private FilterConfig config;
    private String blackList;
    private String ipblock;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        this.ipblock = config.getInitParameter("ipblock");
        this.blackList = config.getInitParameter("blacklist");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        if (checkRemoteIp(request, response) && checkUsername(request, response)) {
            long before = System.currentTimeMillis();
            config.getServletContext().log("NoteFilter:before call chain.doFilter()");
            chain.doFilter(request, response);
            config.getServletContext().log("NoteFilter:after call chain.doFilter()");
            long after = System.currentTimeMillis();
            String name = "";
            if (request instanceof HttpServletRequest) {
                name = ((HttpServletRequest) request).getRequestURI();
            }
            config.getServletContext().log("NoteFilter:" + name + ": " + (after - before) + "ms");
        }
    }

    @Override
    public void destroy() {
        config = null;
    }

    private boolean checkRemoteIp(ServletRequest request, ServletResponse response) throws IOException {
        String addr = request.getRemoteAddr();
        if (addr.indexOf(ipblock) == 0) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>你地址处于黑名单</h1>");
            out.flush();
            return false;
        }
        return true;
    }
    
    private boolean checkUsername(ServletRequest request, ServletResponse response) throws IOException {
        String username = ((HttpServletRequest) request).getParameter("username");
        if (username != null) {
            username = new String(username.getBytes(StandardCharsets.ISO_8859_1), "GB2312");
        }
        if (username != null && username.contains(blackList)) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>对不起，" + username + ", 你处于黑名单");
            out.flush();
            return false;
        }
        return true;
    }
}
