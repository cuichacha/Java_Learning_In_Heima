package Day15.CodeReview1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerReview4 {
    /*
        调用shutdownOutput()方法后，socket无法继续传输数据，无法完成需求
        未解决bug
     */

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10000);
            Socket accept = serverSocket.accept();
//            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
//                    100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(2),
//                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
            Receiver receiver = new Receiver(accept);

            new Thread(receiver).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receiver implements Runnable {
    Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String str;
        try {
            while (true) {
                InputStream inputStream = socket.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                OutputStream outputStream = socket.getOutputStream();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
                bufferedWriter.write("收到");
                bufferedWriter.flush();
//                socket.shutdownOutput();
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }
}