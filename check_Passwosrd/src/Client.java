import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket Server =new Socket(InetAddress.getLocalHost(),4000);
        DataInputStream input = new DataInputStream(Server.getInputStream());
        DataOutputStream output = new DataOutputStream(Server.getOutputStream());
        Scanner write = new Scanner(System.in);
        while (!input.readBoolean()) {
            System.out.println("Enter UserName ? ");
            output.writeUTF(write.nextLine());
            System.out.println("Enter PassWord ?");
            output.writeUTF(write.nextLine());
        }
        System.out.println(input.readUTF());
        output.writeUTF(write.nextLine());
    }
}
