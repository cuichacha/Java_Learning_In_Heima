package Day15.CodeReview1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientReview2 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            datagramSocket = new DatagramSocket();
            while (true) {
                System.out.println("输入信息");
                String str = scanner.nextLine();
                InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
                byte[] data = str.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, 10000);
                datagramSocket.send(datagramPacket);
                if (str.equals("886")) {
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
