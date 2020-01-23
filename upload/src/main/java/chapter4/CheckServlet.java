package chapter4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/check"})
public class CheckServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String message = null;
        if (username == null) {
            message = "input username";
        } else {
            message = "Hello, " + username;
        }

        req.setAttribute("msg", message);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/output");
        // 等价于
        //RequestDispatcher dispatcher =req.getRequestDispatcher("output");
        PrintWriter out = res.getWriter();
        out.println("Output from CheckServlet before forwarding request.");
        dispatcher.forward(req, res);
        out.println("Output from CheckServlet after forwarding request.");
    }
}
