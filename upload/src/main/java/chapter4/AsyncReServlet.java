package chapter4;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/asy"}, asyncSupported = true)
public class AsyncReServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(60 * 1000);
        new Thread(new MyTask(asyncContext)).start();
    }
}
