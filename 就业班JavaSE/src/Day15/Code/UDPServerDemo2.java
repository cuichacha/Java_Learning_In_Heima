package Day15.Code;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo2 {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        byte[] bytes = new byte[1024];
        byte[] data;
        int len;

        try {
            datagramSocket = new DatagramSocket(10001);
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            while (true) {
                datagramSocket.receive(datagramPacket);
                data = datagramPacket.getData();
                len = datagramPacket.getLength();
                System.out.println(new String(data, 0, len));
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
