package chapter4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/push"})
public class PushServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        PushBuilder pushBuilder = req.newPushBuilder();
        if (pushBuilder != null) {
            pushBuilder.path("store/zyw.jpg");
            pushBuilder.push();
            printWriter.println("<html>");
            printWriter.println("<body>");
            printWriter.println("<p>以下图片来自于服务器端推送</p>");
            printWriter.println("<img src=\"" + req.getContextPath()
                    + "/store/zyw.jpg\"/>");
            printWriter.println("</body>");
            printWriter.println("</html>");
            printWriter.flush();
        } else {
            printWriter.println("当前 HTTP 协议不支持 push");
        }
    }
}
