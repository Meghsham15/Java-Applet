import java.net.InetAddress;
import java.net.UnknownHostException;

public class addressExp6 {
    public static void main(String[] args) {
        try {
            // Get the local host address
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local host address: " + localAddress.getHostAddress());

            // Get the address for a specific host name
            InetAddress googleAddress = InetAddress.getByName("www.google.com");
            System.out.println("Google address: " + googleAddress.getHostAddress());

         
        } catch (UnknownHostException e) {
            System.err.println("Unknown host");
            e.printStackTrace();
        }
    }
}
