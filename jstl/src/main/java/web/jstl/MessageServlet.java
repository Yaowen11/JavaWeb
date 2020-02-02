package web.jstl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/message"}, loadOnStartup = 1)
public class MessageServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>The Example Message Servlet</title></head>");
        out.println("<body>");
        ResourceBundle bundle = ResourceBundle.getBundle("module_resource");
        String requiredFieldMessage = bundle.getString("error.required.field");
        String formattedNameMessage = MessageFormat.format(requiredFieldMessage, bundle.getString("label.name"));
        out.println(formattedNameMessage + "<br>");
        String formattedPhoneMessage = MessageFormat.format(requiredFieldMessage, bundle.getString("label.phone"));
        out.println(formattedPhoneMessage + "<br>");
        out.println("</body></html>");
    }
}
