import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.HashMap;

public class Server {
    private static Map<String, Servlet> servletCache = new HashMap<>();

    public static void main(String[] args)
            throws Exception {
        int port = 9090;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.printf("server lestening prot: %d\n", port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("client connection done client addr: " + clientSocket.getInetAddress() + ":"
                            + clientSocket.getPort());
                    service(clientSocket);
                } catch (IOException | InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void service(Socket socket) throws Exception {
        InputStream socketIn = socket.getInputStream();
        Thread.sleep(500);
        int size = socketIn.available();
        byte[] requestBuffer = new byte[size];
        socketIn.read(requestBuffer);
        String request = new String(requestBuffer);
        System.out.println(request);
        int endIndex = request.indexOf("\r\n");
        if (endIndex == -1) {
            endIndex = request.length();
        }
        String firstLineOfRequest = request.substring(0, endIndex);
        String[] parts = firstLineOfRequest.split(" ");
        String uri = "";
        if (parts.length >= 2) {
            uri = parts[1];
        }

        if (uri.indexOf("servlet") != -1) {
            String servletName = uri.substring(uri.indexOf("servlet/") + 8, uri.length());
            if (uri.indexOf("?") != -1) {
                servletName = uri.substring(uri.indexOf("servlet/") + 8, uri.indexOf("?"));
            }
            Servlet servlet = servletCache.get(servletName);
            if (servlet == null) {
                servlet = (Servlet) Class.forName(servletName).getDeclaredConstructor().newInstance();
                servlet.init();
                servletCache.put(servletName, servlet);
            }
            servlet.service(requestBuffer, socket.getOutputStream());
            Thread.sleep(1000);
            socket.close();
            return;
        }
        String contentType = "application/octet-stream";
        if (uri.indexOf("html") != -1 || uri.indexOf("htm") != -1) {
            contentType = "text/html";
        }
        if (uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1) {
            contentType = "image/jpeg";
        }
        if (uri.indexOf("gif") != -1) {
            contentType = "image/gif";
        }

        String responseFirstLine = "HTTP/1.1 200 OK\r\n";
        String responseHeader = "Content-Type:" + contentType + "\r\n\r\n";
        if ("/favicon.ico".equals(uri)) {
            socket.close();
            return;
        }
        InputStream in = Server.class.getResourceAsStream(uri);
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(responseFirstLine.toString().getBytes());
        socketOut.write(responseHeader.toString().getBytes());
        int len = 0;
        byte[] buffer = new byte[128];
        while ((len = in.read(buffer)) != -1) {
            socketOut.write(buffer, 0, len);
        }
        Thread.sleep(1000);
        socket.close();
    }
}