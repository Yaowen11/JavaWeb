package chapter4;

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
@WebServlet(urlPatterns = {"/redirect"})
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String message = null;
        if (username == null) {
            message = "input username.";
        } else {
            message = "Hello," + username;
        }

        req.setAttribute("msg", message);
        out.println("Output from CheckServlet before redirecting");
        resp.sendRedirect("/upload/out?msg=" + message);
        out.println("output from CheckServlet1 after redirecting");
    }
}
