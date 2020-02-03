package web.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author z
 */
public class ReplaceTextStream extends ServletOutputStream {
    private ServletOutputStream intStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    private boolean closed = false;
    private String oldStr;
    private String newStr;
    public ReplaceTextStream(ServletOutputStream outputStream, String searchStr, String replaceStr) {
        intStream = outputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        oldStr = searchStr;
        newStr = replaceStr;
    }

    @Override
    public void write(int a) throws IOException {
        byteArrayOutputStream.write(a);
    }

    @Override
    public void println(String s) throws IOException {
        s = s + "\n";
        byte[] bytes = s.getBytes();
        byteArrayOutputStream.write(bytes);
    }

    @Override
    public void close() throws IOException {
        if (!closed) {
            processStream();
            intStream.close();
            closed = true;
        }
    }

    @Override
    public void flush() throws IOException {
        if (byteArrayOutputStream.size() != 0) {
            if (!closed) {
                processStream();
                byteArrayOutputStream = new ByteArrayOutputStream();
            }
        }
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public boolean isReady() {
        return true;
    }

    public void processStream() throws IOException {
        intStream.write(replaceContent(byteArrayOutputStream.toByteArray()));
        intStream.flush();
    }

    public byte[] replaceContent(byte[] inBytes) {
        String string = new String(inBytes);
        return string.replace(oldStr, newStr).getBytes();
    }
}
