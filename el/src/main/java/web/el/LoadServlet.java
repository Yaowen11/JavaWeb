package web.el;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @author z
 */
@WebServlet(loadOnStartup = 1, urlPatterns = {"/load"})
public class LoadServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Properties ps = new Properties();
        Properties psCh = new Properties();
        try {
            ServletContext context = getServletContext();
            InputStream in = context.getResourceAsStream("/WEB-INF/message_resource.properties");
            InputStream inCh = context.getResourceAsStream("/WEB-INF/message_resource_ch.properties");
            ps.load(in);
            psCh.load(inCh);
            in.close();
            inCh.close();
            context.setAttribute("ps", ps);
            context.setAttribute("psCh", psCh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init();
        PrintWriter out = resp.getWriter();
        out.println("The resource file is reloaded");
    }
}
