import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHendler extends Thread{
     ClinetHendlerConntrols client = new ClinetHendlerConntrols ();
    private Socket socket;
    DataInputStream input ;
    DataOutputStream output ;
    public ClientHendler(Socket s) throws  Exception{
        socket = s ;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());


    }
    @Override
    public  void run() {
        try {
            client.checkLogin(socket,input,output);
        } catch (Exception e) {}
    }
}
