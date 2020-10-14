package Question22;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 10000);
        Scanner scanner = new Scanner(System.in);
        String address;

        while (true) {
            System.out.println("请输入上传文件的路径");
            address = scanner.nextLine();
            File file = new File(address);
            if (file.exists() && file.isFile()) {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                OutputStream outputStream = socket.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(outputStream);
                int len;
                byte[] bytes = new byte[1024];
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bos.flush();
                socket.shutdownOutput();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
                bis.close();
                socket.close();
                break;
            } else {
                System.out.println("请输入正确的图片文件路径，请重新输入");
            }
        }
    }
}
