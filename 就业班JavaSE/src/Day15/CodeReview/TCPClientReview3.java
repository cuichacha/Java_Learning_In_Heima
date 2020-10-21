package Day15.CodeReview;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientReview3 {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        String str;
        try {
            socket = new Socket("127.0.0.1", 10000);
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            while (true) {
                System.out.println("输入信息");
                String s = scanner.nextLine();
                bufferedWriter.write(s);
                bufferedWriter.flush();
//                if (s.equals("886")) {
//                    break;
//                }
            socket.shutdownOutput();
            while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
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
