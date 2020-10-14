package Day15.CodeReview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPServerReview3 {
    public static void main(String[] args) {
        MulticastSocket multicastSocket = null;
        byte[] bytes = new byte[1024];

        try {
            multicastSocket = new MulticastSocket(10000);

//            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                multicastSocket.joinGroup(InetAddress.getByName("224.0.1.0"));
                multicastSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                int length = datagramPacket.getLength();
                System.out.println(new String(data, 0, length));
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (multicastSocket != null) {
                multicastSocket.close();
            }
        }
    }
}
