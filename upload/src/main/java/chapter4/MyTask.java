package chapter4;

import javax.servlet.AsyncContext;
import java.io.IOException;

/**
 * @author z
 */
public class MyTask implements Runnable {

    private AsyncContext asyncContext;

    public MyTask(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5 * 1000);
            asyncContext.getResponse()
                    .getWriter()
                    .write("async is done");
            asyncContext.complete();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
