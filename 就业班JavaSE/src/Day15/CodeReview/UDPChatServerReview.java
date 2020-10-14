package Day15.CodeReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPChatServerReview {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        byte[] bytes = new byte[1024];

        try {
            datagramSocket = new DatagramSocket(10000);
            while (true) {
                DatagramPacket datagramPacketReceive = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(datagramPacketReceive);
                byte[] data = datagramPacketReceive.getData();
                int length = datagramPacketReceive.getLength();
                String text = new String(data, 0, length);
                System.out.println(text);
//                InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
//                DatagramPacket datagramPacketSend = new DatagramPacket(text.getBytes(), text.getBytes().length, inetAddress, 10000);
//                datagramSocket.send(datagramPacketSend);
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
