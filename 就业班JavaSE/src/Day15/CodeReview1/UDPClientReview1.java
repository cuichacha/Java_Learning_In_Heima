package Day15.CodeReview1;

import java.io.IOException;
import java.net.*;

public class UDPClientReview1 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        String str = "啦啦啦";
        byte[] bytes = str.getBytes();

        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            datagramSocket = new DatagramSocket();
            DatagramPacket datagramPacket = new DatagramPacket(bytes,
                    bytes.length, inetAddress, 10000);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
