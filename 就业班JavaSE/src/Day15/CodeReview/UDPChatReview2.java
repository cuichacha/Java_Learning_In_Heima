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

public class UDPChatReview2 {
    /*
        试图实现三人聊天
        功能未实现，没有解决端口冲突问题
     */

    public static void main(String[] args) {
        SendInfo2 sendInfo1 = new SendInfo2(10003);
//        SendInfo2 sendInfo2 = new SendInfo2(10004);
        ReceiveInfo2 receiveInfo1 = new ReceiveInfo2(10001);
//        ReceiveInfo2 receiveInfo2 = new ReceiveInfo2(10002);
        ReceiveInfo2 receiveInfo3 = new ReceiveInfo2(10005);
//        ReceiveInfo2 receiveInfo4 = new ReceiveInfo2(10006);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6,
                100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.submit(sendInfo1);
//        threadPoolExecutor.submit(sendInfo2);
        threadPoolExecutor.submit(receiveInfo1);
//        threadPoolExecutor.submit(receiveInfo2);
        threadPoolExecutor.submit(receiveInfo3);
//        threadPoolExecutor.submit(receiveInfo4);
    }
}

class SendInfo2 implements Runnable {
    Scanner scanner = new Scanner(System.in);
    int port;

    public SendInfo2(int port) {
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

class ReceiveInfo2 implements Runnable {
    DatagramSocket datagramSocket = null;
    byte[] bytes = new byte[1024];
    int port;

    public ReceiveInfo2(int port) {
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

