package chapter4;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;

/**
 * @author z
 */
public class MyReadListener implements ReadListener {
    private ServletInputStream inputStream;
    private AsyncContext context;
    private StringBuilder stringBuilder = new StringBuilder();

    MyReadListener(ServletInputStream inputStream, AsyncContext context) {
        this.inputStream = inputStream;
        this.context = context;
    }

    @Override
    public void onDataAvailable() throws IOException {
        try {
            Thread.sleep(5000);
            int len = -1;
            byte[] buff = new byte[1024];
            while (inputStream.isReady() && (len = inputStream.read(buff)) > 0) {
                String data = new String(buff, 0, len);
                stringBuilder.append(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAllDataRead() throws IOException {
        context.getRequest().setAttribute("msg", stringBuilder.toString());
        context.dispatch("/output");
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
