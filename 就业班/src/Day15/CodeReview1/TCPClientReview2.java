package Day15.CodeReview1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientReview2 {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        byte[] bytes = new byte[1024];
        try {
            socket = new Socket("127.0.0.1", 10000);
            OutputStream outputStream = socket.getOutputStream();
//            while (true) {
                System.out.println("输入信息");
                String s = scanner.nextLine();
                outputStream.write(s.getBytes());
                outputStream.flush();
                socket.shutdownOutput();

                InputStream inputStream = socket.getInputStream();
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes, 0, len));
                }
//                if (s.equals("886")) {
//                    break;
//                }
//            }
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
