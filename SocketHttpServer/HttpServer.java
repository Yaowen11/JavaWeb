import java.io.*;
import java.net.*;

public class HttpServer
{
    public static void main(String[] args) {
        ServerSocket serverSocket;
        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("default port 9090 ");
            port = 9090;
        }
        try {
            serverSocket = new ServerSocket(port);
            System.out.printf("server lesten port: %d\n:", serverSocket.getLocalPort());
            while (true) {
                try {
                    final Socket socket = serverSocket.accept();
                    System.out.println("connection client address is: " + 
                    socket.getInetAddress() + ":" + socket.getPort());
                    service(socket);
                } catch (Exception e) {
                    System.out.println("connection error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void service(Socket socket) throws Exception {
        InputStream socketIn = socket.getInputStream();
        Thread.sleep(500);
        int size = socketIn.available();
        byte[] buffer = new byte[size];
        socketIn.read(buffer);
        String request = new String(buffer);
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
        String contentType;
        if (uri.indexOf("html") != -1 || uri.indexOf("htm") != -1) {
            contentType = "text/html";
        } else if (uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1) {
            contentType = "image/jpeg";
        } else if (uri.indexOf("gif") != -1) {
            contentType = "image/gif";
        } else {
            contentType = "application/octet-stream";
        }

        String responseFirstLine = "HTTP/1.1 200 OK\r\n";
        String responseHeader = "Content-Type:" + contentType + "\r\n\r\n";
        InputStream in = HttpServer.class.getResourceAsStream(uri);
        OutputStream socketOut = socket.getOutputStream();
        socketOut.write(responseFirstLine.getBytes());
        socketOut.write(responseHeader.getBytes());
        int len = 0;
        buffer = new byte[128];
        while ((len = in.read(buffer)) != -1) {
            socketOut.write(buffer, 0, len);
        }
        Thread.sleep(1000);
        socket.close();
    }
}