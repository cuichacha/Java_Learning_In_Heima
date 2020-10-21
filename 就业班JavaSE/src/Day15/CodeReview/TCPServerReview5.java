package Day15.CodeReview;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerReview5 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String str;
        try {
            serverSocket = new ServerSocket(10000);

            while (true) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                OutputStream outputStream = accept.getOutputStream();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
                bufferedWriter.write("收到");
                bufferedWriter.flush();



                accept.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
