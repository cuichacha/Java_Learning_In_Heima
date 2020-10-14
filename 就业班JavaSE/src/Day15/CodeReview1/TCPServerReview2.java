package Day15.CodeReview1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerReview2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        byte[] bytes = new byte[1024];
        try {
            serverSocket = new ServerSocket(10000);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
//            while (true) {
                String str = "";
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    str = new String(bytes, 0, len);
                    System.out.println(str);
                }
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write("收到".getBytes());
                outputStream.flush();
//                if (str.equals("886")) {
//                    break;
//                }
                accept.shutdownOutput();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
