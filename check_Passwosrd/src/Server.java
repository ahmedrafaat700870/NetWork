import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        String [] data = new String[] {"a","1"};
        Boolean check = false ;
        ServerSocket s = new ServerSocket(4000);
        Socket client = s.accept();
        DataInputStream input = new DataInputStream(client.getInputStream());
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        String username = "";
        String Password = "";
        while (!check) {
            output.writeBoolean(check);
            username = input.readUTF();
            Password = input.readUTF();
            if (username.equals(data[0]) && Password.equals(data[1]))
            {
                check = true;
                output.writeBoolean(check);
                break;
            }
        }
        output.writeUTF("Enter your Message ? ");
        String Message =  input.readUTF();
        System.out.println(Message);
    }
}
