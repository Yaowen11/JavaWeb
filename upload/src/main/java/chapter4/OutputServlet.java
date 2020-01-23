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
@WebServlet(urlPatterns = {"/output"})
public class OutputServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String message = (String) req.getAttribute("msg");
        PrintWriter out = res.getWriter();
        out.println(message);
        out.close();
    }
}
