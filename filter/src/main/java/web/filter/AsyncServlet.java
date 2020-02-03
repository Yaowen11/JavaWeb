package web.filter;

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
@WebServlet(
        name = "AsyncServlet",
        urlPatterns = "/async",
        asyncSupported = true
)
public class AsyncServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain;charset=UTF-8");
        AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(new MyTask(asyncContext));
    }

    class MyTask implements Runnable {

        private AsyncContext asyncContext;

        public MyTask(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5 * 1000);
                try {
                    asyncContext.getResponse()
                            .getWriter()
                            .write("async task it's done");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
