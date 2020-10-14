package Day15.CodeReview1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressReview {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("Wills-MacBook-Pro.local");
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
