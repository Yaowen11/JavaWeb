package web.filter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author z
 */
public class NoteServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        ServletOutputStream out = resp.getOutputStream();
        out.println("<html>");
        out.println("<head><title>留言薄</title></head>");
        out.println("<body>");

        String username = req.getParameter("username");
        String content = req.getParameter("content");

        if(content != null) {
            out.println("<p>" + username + "的留言为：" + content + "</p>");
        }
        out.println("<form action=" + req.getContextPath()
                +"/note method=POST>");

        out.println("<b>姓名:</b>");
        out.println("<input type=text size=10 name=username><br>");
        out.println("<b>留言:</b><br>");
        out.println("<textarea name=content rows=5 cols=20></textarea><br><br>");
        out.println("<input type=submit  value=提交>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
