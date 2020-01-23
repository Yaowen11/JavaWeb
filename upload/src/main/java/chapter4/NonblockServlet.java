package chapter4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/nonblock"}, asyncSupported = true)
public class NonblockServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<title>nonblock</title>");
        out.println("进入 Servlet 的 service() 方法时间: " + new java.util.Date() + ".<br/>");

        AsyncContext context = req.startAsync();
        context.setTimeout(60 * 1000);
        ServletInputStream inputStream = req.getInputStream();
        inputStream.setReadListener(new MyReadListener(inputStream, context));
        out.println("退出 Servlet 的 service() 方法时间: " + new java.util.Date() + ".<br/><hr>");
        out.flush();
    }
}
