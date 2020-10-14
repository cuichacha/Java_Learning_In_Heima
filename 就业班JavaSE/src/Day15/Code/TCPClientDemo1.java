package Day15.Code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientDemo1 {
    public static void main(String[] args) {
        Socket socket = null;
        byte[] bytes = new byte[1024];
        int len;

        try {
            socket = new Socket("127.0.0.1", 10000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("你好".getBytes());
            InputStream inputStream = socket.getInputStream();
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
//            len = inputStream.read(bytes);
//            System.out.println(new String(bytes, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
