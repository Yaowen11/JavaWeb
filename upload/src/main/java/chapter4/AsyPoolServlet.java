package chapter4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author z
 */
@WebServlet(urlPatterns = {"/asyPool"}, asyncSupported = true)
public class AsyPoolServlet extends GenericServlet {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 50000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(60 * 1000);
        executor.execute(new MyTask(asyncContext));
    }

    @Override
    public void destroy() {
        executor.shutdownNow();
    }
}
