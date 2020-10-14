package Day15.Code;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 10001;

            while (true) {
                String str = scanner.nextLine();
                byte[] bytes = str.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, port);
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
