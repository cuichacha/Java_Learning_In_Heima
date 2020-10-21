package Day15.CodeReview1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerReview3 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        String str;
        try {
            serverSocket = new ServerSocket(10000);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
            OutputStream outputStream = accept.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("收到");
            bufferedWriter.flush();
            accept.shutdownOutput();
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
