package Day15.CodeReview1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientReview5 {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        String str;

        try {
            while (true) {
                socket = new Socket("127.0.0.1", 10000);
                OutputStream outputStream = socket.getOutputStream();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                InputStream inputStream = socket.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                System.out.println("输入信息");
                String s = scanner.nextLine();
                bufferedWriter.write(s);
                bufferedWriter.flush();
                socket.shutdownOutput();

                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
            }
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
