package Day15.CodeReview1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerReview1 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket(10000);
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            int length = datagramPacket.getLength();
            System.out.println(new String(data, 0, length));
//            System.out.println(new String(bytes, 0, length)); 直接用byte字节数组也可以
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
