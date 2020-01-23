import java.net.*;
import java.io.*;

public class HttpClient {
    public static void main(String[] args) {
        String uri="index.html";
        if (args.length != 0) {
            uri = args[0];
        }
        doGet("localhost", 9090, uri);
    }

    private static void doGet(String host, int post, String uri) {
        try (Socket socket = new Socket(host, post)) {
            StringBuffer sb = new StringBuffer("GET " + uri + " HTTP/1.1\r\n");
            sb.append("Accept: */*\r\n")
                .append("Accept-Language: zh-cn\r\n")
                .append("Accept-Encoding: gzip, deflat\r\n")
                .append("User-Agent: HTTPClient\r\n")
                .append("Host: localhost:8080\r\n")
                .append("Connection: Keep-Alive\r\n\r\n");
            OutputStream socketOut = socket.getOutputStream();
            socketOut.write(sb.toString().getBytes());
            Thread.sleep(2000);
            InputStream socketIn = socket.getInputStream();
            int size = socketIn.available();
            byte[] buffer = new byte[size];
            socketIn.read(buffer);
            System.out.println(new String(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
