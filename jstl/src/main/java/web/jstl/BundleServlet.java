package web.jstl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/bundle"}, loadOnStartup = 1)
public class BundleServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>The Example Bundle Servlet</title></head>");
        out.println("<body>");

        ResourceBundle bundle = ResourceBundle.getBundle("module_resource");
        String key="hello";
        //返回与key匹配的文本。
        String message=bundle.getString(key);
        out.println("key=" + key + "<br>");
        out.println("message=" + message + "<br>");
        out.println("</body></html>");
    }
}
