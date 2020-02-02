package web.jstl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
/**
 * @author z
 */
@WebServlet(urlPatterns = {"/locale"}, loadOnStartup = 1)
public class LocaleServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>The Example Locale Servlet</title></head>");
        out.println("<body>");
        Locale preferredLocale = req.getLocale();
        out.println("<p>The user's preferred Locale is " + preferredLocale + "</p>");
        out.println("<p>A list of preferred Locales in descresing order</p>");
        Enumeration allUserSupportedLocales = req.getLocales();
        out.println("<ul>");
        while (allUserSupportedLocales.hasMoreElements()) {
            Locale supportedLocale = (Locale) allUserSupportedLocales.nextElement();
            out.println("<li>" + "Locale: " + supportedLocale + " - " + supportedLocale.getDisplayName() + "</li>");
        }
        out.println("</ul>");
        Locale servletContainerLocale = Locale.getDefault();
        out.println("<p>The container's Locale " + servletContainerLocale + "</p>");
        out.println("</body></html>");
    }
}
