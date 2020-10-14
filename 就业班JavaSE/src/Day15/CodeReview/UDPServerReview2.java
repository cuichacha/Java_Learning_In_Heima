package Day15.CodeReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerReview2 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket(10000);
            byte[] bytes = new byte[1024];
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                int length = datagramPacket.getLength();
                String str = new String(data, 0, length);
                System.out.println(str);
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
