import java.io.*;

public class HelloServlet implements Servlet {
    public void init() throws Exception {
        System.out.println("HelloServlet is inited");
    }

    public void service(byte[] requestBuffer, OutputStream out) throws Exception {
        String request = new String(requestBuffer);
        String firstLineOfRequest = request.substring(0, request.indexOf("\r\n"));
        String[] parts = firstLineOfRequest.split(" ");
        String method = parts[0];
        String uri = parts[1];

        String username = null;
        if (method.equalsIgnoreCase("get") && uri.indexOf("username=") != -1) {
            String parameters = uri.substring(uri.indexOf("?"), uri.length());
            parts = parameters.split("&");
            parts = parts[0].split("=");
            username = parts[1];
        }
        if (method.equalsIgnoreCase("post")) {
            int locate = request.indexOf("\r\n\r\n");
            String content = request.substring(locate + 4, request.length());
            if (content.indexOf("username=") != -1) {
                parts = content.split("&");
                parts = parts[0].split("=");
                username = parts[1];
            }
        }

        out.write("HTTP/1.1 200 OK\r\n".getBytes());
        out.write("Content-Type:text/html\r\n\r\n".getBytes());
        StringBuffer content = new StringBuffer("<html><head><title>HelloWorld</title></head><body><h1>Hello:")
            .append(username)
            .append("</h1></body></html>");
        out.write(content.toString().getBytes());
    }
}