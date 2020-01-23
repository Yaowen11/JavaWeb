package chapter4;

import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/include"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>MainServlet</title></head>");
        out.println("<body>");

        ServletContext context = getServletContext();
        RequestDispatcher headDispatcher = context.getRequestDispatcher("/header.html");
        RequestDispatcher greetDispatcher = context.getRequestDispatcher("/greet");
        RequestDispatcher footerDispatcher = context.getRequestDispatcher("/footer.html");

        headDispatcher.include(req, resp);
        greetDispatcher.include(req, resp);
        footerDispatcher.include(req, resp);

        out.println("</body></html>");
        out.close();
    }
}
