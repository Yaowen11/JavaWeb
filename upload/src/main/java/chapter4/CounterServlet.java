package chapter4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author z
 */
@WebServlet(urlPatterns = {"/counter"})
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Counter counter = (Counter) context.getAttribute("counter");
        if (counter == null) {
            counter = new Counter(1);
            context.setAttribute("counter", counter);
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>CounterServlet</title></head><body>");
        String imageLink = "<img src='image?count=" + counter.getCount() + "'/>";
        out.println("欢迎关林本站，您是第 " + imageLink + " 位访问者");
        out.println("</body></html>");
        counter.add(1);
        out.close();
    }
}
