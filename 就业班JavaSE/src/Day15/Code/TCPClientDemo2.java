package Day15.Code;

import java.io.*;
import java.net.Socket;

public class TCPClientDemo2 {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        BufferedReader bufferedReader = null;
        byte[] bytes = new byte[1024];
        int len;
        String str;

        try {
            socket = new Socket("192.168.34.35", 10000);
            bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/willdufresne/Downloads/b.txt"));
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
            bufferedOutputStream.flush();
            socket.shutdownOutput();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
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
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
