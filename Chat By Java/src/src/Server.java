import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws Exception {
        ServerSocket server = new ServerSocket(4000);
        do {
            Socket s = server.accept();
            ClientHendler clientes = new ClientHendler(s);
            clientes.start();
        } while (true);
    }
}
