package Day15.Code;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo1 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        byte[] bytes = new byte[1024];
        int len;

        try {
            serverSocket = new ServerSocket(10000);
            Socket accept = serverSocket.accept();

            while ((len = accept.getInputStream().read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
//            len = accept.getInputStream().read(bytes);
//            System.out.println(new String(bytes, 0, len));
            accept.getOutputStream().write("收到".getBytes());
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
