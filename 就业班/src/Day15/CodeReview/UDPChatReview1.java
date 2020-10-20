package Day15.CodeReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UDPChatReview1 {
    /*
        试图实现三人聊天
        功能未实现，没有解决端口冲突问题
     */

    public static void main(String[] args) {

//        SendInfo1 sendInfo1 = new SendInfo1(10001, getText());
//        SendInfo1 sendInfo1 = new SendInfo1(10001, getText());
//        SendInfo1 sendInfo1 = new SendInfo1();
//        SendInfo1 sendInfo2 = new SendInfo1(10002);
//        ReceiveInfo1 receiveInfo1 = new ReceiveInfo1(10003);
//        ReceiveInfo1 receiveInfo2 = new ReceiveInfo1(10004);
        ReceiveInfo1 receiveInfo3 = new ReceiveInfo1(10001);
//        ReceiveInfo1 receiveInfo4 = new ReceiveInfo1(10006);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6,
                100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//        threadPoolExecutor.submit(sendInfo1);
//        threadPoolExecutor.submit(sendInfo2);
//        threadPoolExecutor.submit(receiveInfo1);
//        threadPoolExecutor.submit(receiveInfo2);
        threadPoolExecutor.submit(receiveInfo3);
//        threadPoolExecutor.submit(receiveInfo4);
    }

//    private static String getText() {
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }
}

class SendInfo1 implements Runnable {
    Scanner scanner = new Scanner(System.in);
    int port;
//    String text;

//    public SendInfo1(int port, String text) {
//        this.text = text;
//        this.port = port;
//    }


    public SendInfo1(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        DatagramSocket datagramSocket = null;
        byte[] bytes;
        try {
            datagramSocket = new DatagramSocket();
            while (true) {
                String textSend = scanner.nextLine();
                bytes = textSend.getBytes();
                InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, port);
                datagramSocket.send(datagramPacket);
                if (textSend.equals("886")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}

class ReceiveInfo1 implements Runnable {
    DatagramSocket datagramSocket = null;
    byte[] bytes = new byte[1024];
    int port;

    public ReceiveInfo1(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            datagramSocket = new DatagramSocket(port);
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                int length = datagramPacket.getLength();
                String text = new String(data, 0, length);
                String hostAddress = datagramPacket.getAddress().getHostAddress();
                System.out.println("-----" + hostAddress + ":" + port + "-----");
                System.out.println(text);
                if (text.equals("886")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}

