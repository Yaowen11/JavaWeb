package session.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/server/info"})
public class ServerInfoServlet extends GenericServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Server is initlized");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = getServletContext();
        PrintWriter out = res.getWriter();
        res.setContentType("application/json;charset=UTF-8");
        File tempDir = (File) context.getAttribute("javax.servlet.context.tempdir");
        String dir = tempDir.getPath();
        out.println("{\"serverInfo\":\"" + context.getServerInfo() + "\",\"tempdir\":\"" + dir + "\"}");
        out.close();
    }
}
