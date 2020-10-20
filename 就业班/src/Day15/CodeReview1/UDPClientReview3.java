package Day15.CodeReview1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientReview3 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            datagramSocket = new DatagramSocket();
            while (true) {
                String str = scanner.nextLine();
                byte[] bytes = str.getBytes();
                InetAddress inetAddress = InetAddress.getByName("224.0.1.0");
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, 10000);
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
