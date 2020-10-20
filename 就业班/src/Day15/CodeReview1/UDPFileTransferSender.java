package Day15.CodeReview1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPFileTransferSender {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        FileInputStream fileInputStream = null;
        byte[] bytes = new byte[8192];
        try {
            datagramSocket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 10000;
            fileInputStream = new FileInputStream(new File("/Users/willdufresne/Downloads/BG1.png"));
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                DatagramPacket datagramPacket = new DatagramPacket(bytes, len, inetAddress, port);
                datagramSocket.send(datagramPacket);
                Thread.sleep(5);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
