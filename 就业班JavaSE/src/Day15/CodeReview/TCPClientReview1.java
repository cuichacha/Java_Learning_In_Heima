package Day15.CodeReview;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientReview1 {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("127.0.0.1", 10000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("HelloWorld".getBytes());
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
