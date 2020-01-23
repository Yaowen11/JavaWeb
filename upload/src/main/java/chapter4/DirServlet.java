package chapter4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/dir"})
public class DirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Enumeration enumeration = context.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String attributeName = (String) enumeration.nextElement();
            out.println("<br>" + attributeName + ": " + context.getAttribute(attributeName));
        }
        out.close();
        File workDir = (File) context.getAttribute("javax.servlet.context.tempdir");
        FileOutputStream fileOutputStream = new FileOutputStream(workDir + "/temp.txt");
        fileOutputStream.write("Hello World!".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }
}
