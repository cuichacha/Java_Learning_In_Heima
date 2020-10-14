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

public class UDPChatReview3 {
    /*
        试图实现三人聊天
        功能未实现，没有解决端口冲突问题
     */

    public static void main(String[] args) {
        SendInfo3 sendInfo1 = new SendInfo3(10005);
//        SendInfo3 sendInfo2 = new SendInfo3(10006);
        ReceiveInfo3 receiveInfo1 = new ReceiveInfo3(10001);
//        ReceiveInfo3 receiveInfo2 = new ReceiveInfo3(10002);
        ReceiveInfo3 receiveInfo3 = new ReceiveInfo3(10003);
//        ReceiveInfo3 receiveInfo4 = new ReceiveInfo3(10004);
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

class SendInfo3 implements Runnable {
    Scanner scanner = new Scanner(System.in);
    int port;

    public SendInfo3(int port) {
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

class ReceiveInfo3 implements Runnable {
    DatagramSocket datagramSocket = null;
    byte[] bytes = new byte[1024];
    int port;

    public ReceiveInfo3(int port) {
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

