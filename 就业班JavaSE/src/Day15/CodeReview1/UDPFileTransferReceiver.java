package Day15.CodeReview1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPFileTransferReceiver {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        FileOutputStream fileOutputStream = null;
        byte[] bytes = new byte[8192];
        try {
            datagramSocket = new DatagramSocket(10000);
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                int length = datagramPacket.getLength();
                datagramSocket.receive(datagramPacket);
                fileOutputStream = new FileOutputStream(new File("/Users/willdufresne/Movies/BG1.png"), true);
                fileOutputStream.write(bytes, 0, length);
                fileOutputStream.flush();
                if (length < 8192) {
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
