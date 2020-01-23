package chapter4;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/concurrency"})
public class ConcurrencyServlet extends GenericServlet {
    private String username = null;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        username = req.getParameter("username");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<html><head><title>HelloServlet</TITLE></head>");
        out.println("<body>");
        out.println("你好: "+username);
        out.println("</body></html>");
        out.close(); //关闭PrintWriter
    }
}
