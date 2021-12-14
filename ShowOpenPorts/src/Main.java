import java.net.InetAddress;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int startPort =  0;
        int endPort = 65365 ;
        for (int i = startPort ; i< endPort ; i++) {
            try {
                Socket server = new Socket(InetAddress.getLocalHost(),i);
                System.out.println("Port " + i +" is Opened");
            } catch (Exception e) {}
            System.out.println("Port " + i +" is Not Opened");
        }
    }
}
