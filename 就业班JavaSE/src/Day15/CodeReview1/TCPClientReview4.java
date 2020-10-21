package Day15.CodeReview1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientReview4 {
    /*
       调用shutdownOutput()方法后，socket无法继续传输数据，无法完成需求
       未解决bug
    */

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 10000);
//            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
//                    100, TimeUnit.MILLISECONDS,
//                    new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());
            Sender sender = new Sender(socket);

            new Thread(sender).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Sender implements Runnable {
    Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        String str;
        try {
            while (true) {
                OutputStream outputStream = socket.getOutputStream();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                InputStream inputStream = socket.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                System.out.println("输入信息");
                String s = scanner.nextLine();
                bufferedWriter.write(s);
                bufferedWriter.flush();
//                socket.shutdownOutput();
                bufferedWriter.close();
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